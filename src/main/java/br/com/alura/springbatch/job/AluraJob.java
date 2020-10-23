package br.com.alura.springbatch.job;

import br.com.alura.springbatch.listen.AluraJobListen;
import br.com.alura.springbatch.step.AlunoStep;
import br.com.alura.springbatch.step.EmailStepProcessor;
import br.com.alura.springbatch.step.EmailStepReader;
import br.com.alura.springbatch.step.EmailStepWrite;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.stereotype.Component;

@Component
public class AluraJob {
    private final AlunoStep clientStep;
    private final EmailStepReader emailStepReader;
    private final EmailStepProcessor emailStepProcessor;
    private final EmailStepWrite emailStepWrite;
    private final AluraJobListen listen;
    private final JobLauncher jobLauncher;
    private final JobBuilderFactory jobBuilder;

    public AluraJob(AlunoStep clientStep,
                    EmailStepReader emailStepReader,
                    EmailStepProcessor emailStepProcessor,
                    EmailStepWrite emailStepWrite,
                    AluraJobListen listen,
                    JobLauncher jobLauncher,
                    JobBuilderFactory jobBuilder) {
        this.clientStep = clientStep;
        this.emailStepReader = emailStepReader;
        this.emailStepProcessor = emailStepProcessor;
        this.emailStepWrite = emailStepWrite;
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
                .next(emailStepReader.step())
                .next(emailStepProcessor.step())
                .next(emailStepWrite.step())
                .listener(listen)
                .build();
    }
}
