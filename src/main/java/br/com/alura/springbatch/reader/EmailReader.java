package br.com.alura.springbatch.reader;

import br.com.alura.springbatch.dto.UsuarioDb;
import br.com.alura.springbatch.repository.UsuarioRepository;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class EmailReader implements Tasklet, StepExecutionListener {

    private List<UsuarioDb> list;

    private final UsuarioRepository repository;

    public EmailReader(UsuarioRepository repository) {
        this.repository = repository;
    }

    @Override
    public void beforeStep(StepExecution stepExecution) {
        list = new ArrayList<>();
    }

    @Override
    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
        Iterable<UsuarioDb> iterable = repository.findAll();
        list = StreamSupport.stream(iterable.spliterator(), false)
                .collect(Collectors.toList());
        return RepeatStatus.FINISHED;
    }

    @Override
    public ExitStatus afterStep(StepExecution stepExecution) {
        stepExecution
                .getJobExecution()
                .getExecutionContext()
                .put("listUser", this.list);
        return ExitStatus.COMPLETED;
    }
}
