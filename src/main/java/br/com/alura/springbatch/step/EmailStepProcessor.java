package br.com.alura.springbatch.step;

import br.com.alura.springbatch.processor.EmailProcessor;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.stereotype.Component;

@Component
public class EmailStepProcessor {
    private final StepBuilderFactory stepBuilder;

    public EmailStepProcessor(StepBuilderFactory stepBuilder) {
        this.stepBuilder = stepBuilder;
    }

    public Step step() {
        return stepBuilder
                .get("emailProcessor")
                .tasklet(getProcessor())
                .build();
    }

    @StepScope
    private Tasklet getProcessor() {
        return new EmailProcessor();
    }

}
