package com.example.bankspringbatch;

import org.springframework.batch.core.*;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.Map;

public class JobRestController {

    @Autowired private JobLauncher jobLauncher;
    @Autowired private Job job;

    @GetMapping
    public BatchStatus load() throws Exception {
        Map<String, JobParameter> params = new HashMap<>();
        params.put("time",new JobParameter(System.currentTimeMillis()));
        JobParameters jobParameters = new JobParameters(params);
        JobExecution jobExecution=jobLauncher.run(job,jobParameters);
        while (jobExecution.isRunning()) {
            System.out.println("...");
        }

        jobExecution.getStatus();
    }
}
