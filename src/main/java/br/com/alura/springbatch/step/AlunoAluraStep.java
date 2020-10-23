package br.com.alura.springbatch.step;

import br.com.alura.springbatch.listen.AlunoAluraProcessorListen;
import br.com.alura.springbatch.listen.AlunoAluraReaderListen;
import br.com.alura.springbatch.listen.AlunoAluraWriterListen;
import br.com.alura.springbatch.orm.AlunoAlura;
import br.com.alura.springbatch.orm.AlunoSpringBatch;
import br.com.alura.springbatch.producer.AlunoAluraProcessor;
import br.com.alura.springbatch.reader.AlunoAluraReader;
import br.com.alura.springbatch.repository.ClientRepository;
import br.com.alura.springbatch.writer.AlunoAluraWriter;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.support.CompositeItemProcessor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class AlunoAluraStep {

    private final String path;
    private final String file;
    private final ClientRepository repository;
    private final StepBuilderFactory stepBuilder;
    private final AlunoAluraReaderListen readerListen;
    private final AlunoAluraWriterListen writerListen;
    private final AlunoAluraProcessorListen processorListen;

    public AlunoAluraStep(@Value("${alura.file.path}") String path,
                          @Value("${alura.file.file}") String file,
                          ClientRepository repository,
                          StepBuilderFactory stepBuilder,
                          AlunoAluraReaderListen readerListen,
                          AlunoAluraWriterListen writerListen,
                          AlunoAluraProcessorListen processorListen) {
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
                .<AlunoAlura, AlunoSpringBatch>chunk(5)
                .reader(new AlunoAluraReader(path, file))
                .processor(getProcessor())
                .writer(getWriter())
                .listener(processorListen)
                .listener(readerListen)
                .listener(writerListen)
                .build();
    }

    @StepScope
    private ItemProcessor<AlunoAlura, AlunoSpringBatch> getProcessor() {
        AlunoAluraProcessor processor = new AlunoAluraProcessor();

        CompositeItemProcessor<AlunoAlura, AlunoSpringBatch> composite = new CompositeItemProcessor<>();
        composite.setDelegates(Collections.singletonList(processor));
        return composite;
    }

    @StepScope
    private ItemWriter<AlunoSpringBatch> getWriter() {
        return new AlunoAluraWriter(repository);
    }

}
