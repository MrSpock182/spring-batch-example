package br.com.alura.springbatch.reader;

import br.com.alura.springbatch.dto.AlunoCsv;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.support.IteratorItemReader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AlunoReader implements ItemReader<AlunoCsv> {
    private final String path;
    private final String file;

    private ItemReader<AlunoCsv> reader;

    public AlunoReader(String path, String file) {
        this.path = path;
        this.file = file;
    }

    @Override
    public AlunoCsv read() throws Exception {
        if(reader == null) {
            reader = new IteratorItemReader<>(load());
        }
        return reader.read();
    }

    private List<AlunoCsv> load() throws IOException {
        List<AlunoCsv> list = new ArrayList<>();
        try(final BufferedReader buffered = new BufferedReader(new FileReader(path + file))) {
            String row;
            while((row = buffered.readLine()) != null) {
                String value = row.split(";")[0];
                String[] csvRow = value.split(",");
                AlunoCsv client = new AlunoCsv();
                client.setCpf(csvRow[0]);
                client.setNome(csvRow[1]);
                client.setIdade(csvRow[2]);
                client.setCidade(csvRow[3]);
                list.add(client);
            }
        }
        return list;
    }
}
