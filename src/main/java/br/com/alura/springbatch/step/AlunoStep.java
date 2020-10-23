package br.com.alura.springbatch.step;

import br.com.alura.springbatch.listen.AlunoProcessorListen;
import br.com.alura.springbatch.listen.AlunoReaderListen;
import br.com.alura.springbatch.listen.AlunoWriterListen;
import br.com.alura.springbatch.dto.AlunoCsv;
import br.com.alura.springbatch.dto.AlunoDb;
import br.com.alura.springbatch.processor.AlunoProcessor;
import br.com.alura.springbatch.reader.AlunoReader;
import br.com.alura.springbatch.repository.AlunoRepository;
import br.com.alura.springbatch.writer.AlunoWriter;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.support.CompositeItemProcessor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class AlunoStep {

    private final String path;
    private final String file;
    private final AlunoRepository repository;
    private final StepBuilderFactory stepBuilder;
    private final AlunoReaderListen readerListen;
    private final AlunoWriterListen writerListen;
    private final AlunoProcessorListen processorListen;

    public AlunoStep(@Value("${alura.file.path}") String path,
                     @Value("${alura.file.file}") String file,
                     AlunoRepository repository,
                     StepBuilderFactory stepBuilder,
                     AlunoReaderListen readerListen,
                     AlunoWriterListen writerListen,
                     AlunoProcessorListen processorListen) {
        this.path = path;
        this.file = file;
        this.repository = repository;
        this.stepBuilder = stepBuilder;
        this.readerListen = readerListen;
        this.writerListen = writerListen;
        this.processorListen = processorListen;
    }

    public Step chuckStep() {
        return stepBuilder.get("alunoAluraStep")
                .<AlunoCsv, AlunoDb>chunk(5)
                .reader(getReader())
                .processor(getProcessor())
                .writer(getWriter())
                .listener(processorListen)
                .listener(readerListen)
                .listener(writerListen)
                .build();
    }

    @StepScope
    private ItemReader<AlunoCsv> getReader() {
        return new AlunoReader(path, file);
    }

    @StepScope
    private ItemProcessor<AlunoCsv, AlunoDb> getProcessor() {
        AlunoProcessor processor = new AlunoProcessor();

        CompositeItemProcessor<AlunoCsv, AlunoDb> composite = new CompositeItemProcessor<>();
        composite.setDelegates(Collections.singletonList(processor));
        return composite;
    }

    @StepScope
    private ItemWriter<AlunoDb> getWriter() {
        return new AlunoWriter(repository);
    }

}
