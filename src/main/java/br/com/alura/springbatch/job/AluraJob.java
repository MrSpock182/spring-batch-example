package br.com.alura.springbatch.job;

import br.com.alura.springbatch.listen.AluraJobListen;
import br.com.alura.springbatch.step.AlunoAluraStep;
import br.com.alura.springbatch.step.EnvioEmailStep;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.stereotype.Component;

@Component
public class AluraJob {
    private final AlunoAluraStep clientStep;
    private final EnvioEmailStep infoStep;
    private final AluraJobListen listen;
    private final JobLauncher jobLauncher;
    private final JobBuilderFactory jobBuilder;

    public AluraJob(AlunoAluraStep clientStep,
                    EnvioEmailStep infoStep,
                    AluraJobListen listen,
                    JobLauncher jobLauncher,
                    JobBuilderFactory jobBuilder) {
        this.clientStep = clientStep;
        this.infoStep = infoStep;
        this.listen = listen;
        this.jobLauncher = jobLauncher;
        this.jobBuilder = jobBuilder;
    }

    public void run(JobParametersBuilder parameters) throws Exception {
        jobLauncher.run(start(), parameters.toJobParameters());
    }

    private Job start() {
        return jobBuilder.get("start")
                .start(clientStep.chuckStep())
                .next(infoStep.step())
                .listener(listen)
                .build();
    }
}
