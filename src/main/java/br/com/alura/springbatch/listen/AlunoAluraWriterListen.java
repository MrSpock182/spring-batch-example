package br.com.alura.springbatch.listen;

import br.com.alura.springbatch.orm.AlunoAlura;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.ItemWriteListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AlunoAluraWriterListen implements ItemWriteListener<AlunoAlura> {

    private static final Logger LOGGER = LoggerFactory.getLogger(AlunoAluraWriterListen.class);

    @Override
    public void beforeWrite(List<? extends AlunoAlura> list) {}


    @Override
    public void afterWrite(List<? extends AlunoAlura> list) {}

    @Override
    public void onWriteError(Exception e, List<? extends AlunoAlura> list) {
        LOGGER.error(e.getMessage());
    }

}
