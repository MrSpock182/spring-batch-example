package br.com.alura.springbatch;

import br.com.alura.springbatch.job.AluraJob;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.nio.file.*;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class FileWatcher {

    private final AluraJob aluraJob;
    private final String path;

    public FileWatcher(@Value("${alura.file.path}") String path,
                       AluraJob aluraJob) {
        this.path = path;
        this.aluraJob = aluraJob;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void watch() throws Exception {
        WatchService service = FileSystems.getDefault().newWatchService();
        Paths.get(path).register(service, StandardWatchEventKinds.ENTRY_CREATE);
        WatchKey key;
        while ((key = service.take()) != null) {
            for(WatchEvent<?> event : key.pollEvents()) {
                Map<String, JobParameter> parameters = new HashMap<>();
                parameters.put("path", new JobParameter(path + "/" + event.context()));

                JobParametersBuilder builder = new JobParametersBuilder();
                builder.addJobParameters(new JobParameters(parameters));
                builder.addDate("date", new Date());
                aluraJob.run(builder);
            }
            key.reset();
        }
    }

}
