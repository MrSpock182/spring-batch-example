package br.com.alura.springbatch.producer;

import br.com.alura.springbatch.orm.AlunoAlura;
import br.com.alura.springbatch.orm.AlunoSpringBatch;
import org.springframework.batch.item.ItemProcessor;

import java.util.UUID;

public class AlunoAluraProcessor implements ItemProcessor<AlunoAlura, AlunoSpringBatch> {

    @Override
    public AlunoSpringBatch process(AlunoAlura s) throws Exception {
        AlunoSpringBatch alunoSpringBatch = new AlunoSpringBatch();
        alunoSpringBatch.setId(UUID.randomUUID().toString());
        alunoSpringBatch.setCpf(s.getCpf());
        alunoSpringBatch.setNome(s.getNome());
        alunoSpringBatch.setCidade(s.getCidade());
        alunoSpringBatch.setIdade(s.getIdade());
        if("Sao Paulo".equals(s.getCidade())) {
            alunoSpringBatch.setSaoPaulo(true);
        }
        alunoSpringBatch.setClassificacao(5);
        alunoSpringBatch.setQtdAulas(4);
        return alunoSpringBatch;
    }
}
