package br.com.alura.springbatch.listen;

import br.com.alura.springbatch.dto.AlunoCsv;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.ItemReadListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class AlunoReaderListen implements ItemReadListener<AlunoCsv> {

    @Value("${alura.file.path}")
    private String path;

    @Value("${alura.file.file}")
    private String fileCsv;

    private static final Logger LOGGER = LoggerFactory.getLogger(AlunoReaderListen.class);

    @Override
    public void beforeRead() {}

    @Override
    public void afterRead(AlunoCsv alunoAlura) {
        new File( path + fileCsv).delete();
    }

    @Override
    public void onReadError(Exception e) {
        LOGGER.error(e.getMessage());
    }

}
