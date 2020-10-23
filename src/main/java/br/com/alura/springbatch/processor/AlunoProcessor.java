package br.com.alura.springbatch.processor;

import br.com.alura.springbatch.dto.AlunoCsv;
import br.com.alura.springbatch.dto.AlunoDb;
import org.springframework.batch.item.ItemProcessor;

import java.util.UUID;

public class AlunoProcessor implements ItemProcessor<AlunoCsv, AlunoDb> {

    @Override
    public AlunoDb process(AlunoCsv s) throws Exception {
        AlunoDb alunoSpringBatch = new AlunoDb();
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
