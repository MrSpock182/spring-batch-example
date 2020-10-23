package br.com.alura.springbatch.writer;

import br.com.alura.springbatch.dto.AlunoDb;
import br.com.alura.springbatch.repository.AlunoRepository;
import org.springframework.batch.item.ItemWriter;

import java.util.List;

public class AlunoWriter implements ItemWriter<AlunoDb> {

    private final AlunoRepository repository;

    public AlunoWriter(AlunoRepository repository) {
        this.repository = repository;
    }

    @Override
    public void write(List<? extends AlunoDb> list) throws Exception {
        repository.saveAll(list);
    }
}
