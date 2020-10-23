package br.com.alura.springbatch.step;

import br.com.alura.springbatch.service.EnviaEmail;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.stereotype.Component;

@Component
public class EnvioEmailStep {

    private final EnviaEmail enviaEmail;
    private final StepBuilderFactory stepBuilder;

    public EnvioEmailStep(EnviaEmail enviaEmail, StepBuilderFactory stepBuilder) {
        this.enviaEmail = enviaEmail;
        this.stepBuilder = stepBuilder;
    }

    public Step step() {
        return stepBuilder.get("envioEmailStep").tasklet((stepContribution, chunkContext) -> {
            enviaEmail.envio();
            return RepeatStatus.FINISHED;
        }).build();
    }

}
