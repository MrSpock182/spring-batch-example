package br.com.alura.springbatch.step;

import br.com.alura.springbatch.reader.EmailReader;
import br.com.alura.springbatch.repository.UsuarioRepository;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.stereotype.Component;

@Component
public class EmailStepReader {

    private final UsuarioRepository repository;
    private final StepBuilderFactory stepBuilder;

    public EmailStepReader(UsuarioRepository repository,
                           StepBuilderFactory stepBuilder) {
        this.repository = repository;
        this.stepBuilder = stepBuilder;
    }

    public Step step() {
        return stepBuilder
                .get("emailReader")
                .tasklet(getReader())
                .build();
    }

    @StepScope
    private Tasklet getReader() {
        return new EmailReader(repository);
    }

}
