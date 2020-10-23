package br.com.alura.springbatch.writer;

import br.com.alura.springbatch.orm.AlunoSpringBatch;
import br.com.alura.springbatch.repository.ClientRepository;
import org.springframework.batch.item.ItemWriter;

import java.util.List;

public class AlunoAluraWriter implements ItemWriter<AlunoSpringBatch> {

    private final ClientRepository repository;

    public AlunoAluraWriter(ClientRepository repository) {
        this.repository = repository;
    }

    @Override
    public void write(List<? extends AlunoSpringBatch> list) throws Exception {
        repository.saveAll(list);
    }
}
