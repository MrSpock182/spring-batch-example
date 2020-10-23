package br.com.alura.springbatch.reader;

import br.com.alura.springbatch.orm.AlunoAlura;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.support.IteratorItemReader;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AlunoAluraReader implements ItemReader<AlunoAlura> {
    private final String path;
    private final String file;

    private ItemReader<AlunoAlura> reader;

    public AlunoAluraReader(String path, String file) {
        this.path = path;
        this.file = file;
    }

    @Override
    public AlunoAlura read() throws Exception {
        if(reader == null) {
            reader = new IteratorItemReader<>(load());
        }
        return reader.read();
    }

    private List<AlunoAlura> load() throws IOException {
        List<AlunoAlura> list = new ArrayList<>();
        try(final BufferedReader buffered = new BufferedReader(new FileReader(path + file))) {
            String row;
            while((row = buffered.readLine()) != null) {
                String value = row.split(";")[0];
                String[] csvRow = value.split(",");
                AlunoAlura client = new AlunoAlura();
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
