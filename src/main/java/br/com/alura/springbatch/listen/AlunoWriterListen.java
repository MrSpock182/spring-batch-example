package br.com.alura.springbatch.listen;

import br.com.alura.springbatch.dto.AlunoCsv;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.ItemWriteListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AlunoWriterListen implements ItemWriteListener<AlunoCsv> {

    private static final Logger LOGGER = LoggerFactory.getLogger(AlunoWriterListen.class);

    @Override
    public void beforeWrite(List<? extends AlunoCsv> list) {}


    @Override
    public void afterWrite(List<? extends AlunoCsv> list) {}

    @Override
    public void onWriteError(Exception e, List<? extends AlunoCsv> list) {
        LOGGER.error(e.getMessage());
    }

}
