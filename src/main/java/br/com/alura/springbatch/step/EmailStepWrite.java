package br.com.alura.springbatch.step;

import br.com.alura.springbatch.writer.EmailWriter;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.stereotype.Component;

@Component
public class EmailStepWrite {
    private final StepBuilderFactory stepBuilder;

    public EmailStepWrite(StepBuilderFactory stepBuilder) {
        this.stepBuilder = stepBuilder;
    }

    public Step step() {
        return stepBuilder
                .get("emailWrite")
                .tasklet(getWriter())
                .build();
    }

    @StepScope
    private Tasklet getWriter() {
        return new EmailWriter();
    }

}
