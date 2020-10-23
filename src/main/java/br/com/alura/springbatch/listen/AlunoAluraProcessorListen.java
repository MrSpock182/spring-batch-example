package br.com.alura.springbatch.listen;

import br.com.alura.springbatch.orm.AlunoAlura;
import br.com.alura.springbatch.orm.AlunoSpringBatch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.ItemProcessListener;
import org.springframework.stereotype.Component;

@Component
public class AlunoAluraProcessorListen implements ItemProcessListener<AlunoAlura, AlunoSpringBatch> {

    private static final Logger LOGGER = LoggerFactory.getLogger(AlunoAluraProcessorListen.class);

    @Override
    public void beforeProcess(AlunoAlura creditCard) {}

    @Override
    public void afterProcess(AlunoAlura creditCard, AlunoSpringBatch creditCardRisk) {}

    @Override
    public void onProcessError(AlunoAlura creditCard, Exception e) {
        LOGGER.error(e.getMessage());
    }

}
