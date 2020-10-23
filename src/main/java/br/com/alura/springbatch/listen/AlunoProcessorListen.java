package br.com.alura.springbatch.listen;

import br.com.alura.springbatch.dto.AlunoCsv;
import br.com.alura.springbatch.dto.AlunoDb;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.ItemProcessListener;
import org.springframework.stereotype.Component;

@Component
public class AlunoProcessorListen implements ItemProcessListener<AlunoCsv, AlunoDb> {

    private static final Logger LOGGER = LoggerFactory.getLogger(AlunoProcessorListen.class);

    @Override
    public void beforeProcess(AlunoCsv alunoCsv) {}

    @Override
    public void afterProcess(AlunoCsv alunoCsv, AlunoDb alunoDb) {}

    @Override
    public void onProcessError(AlunoCsv alunoCsv, Exception e) {
        LOGGER.error(e.getMessage());
    }

}
