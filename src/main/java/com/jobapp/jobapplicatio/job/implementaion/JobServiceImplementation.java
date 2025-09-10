package com.jobapp.jobapplicatio.job.implementaion;

import com.jobapp.jobapplicatio.job.Job;
import com.jobapp.jobapplicatio.job.JobService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobServiceImplementation implements JobService {
    private  List<Job>  jobs = new ArrayList<>();
    @Override
    public List<Job> findALL() {
        return jobs;

    }

    @Override
    public void createJob(Job job) {
        jobs.add(job);

    }
}
