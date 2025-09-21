package com.jobapp.jobapplicatio.job.implementaion;

import com.jobapp.jobapplicatio.job.Job;
import com.jobapp.jobapplicatio.job.JobService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class JobServiceImplementation implements JobService {
    private  List<Job>  jobs = new ArrayList<>();
    private  Long nextId = 1L;


    @Override
    public List<Job> findALL() {
        return jobs;
    }


    @Override
    public void createJob(Job job) {
        job.setId(nextId++);
        jobs.add(job);

    }

    @Override
    public Job getJobById(Long id) {
        for( Job job : jobs){
            if(job.getId().equals((id))){
                return job;
            }
        }
        return null;
    }

    @Override
    public boolean deletebyid(Long id) {
        Iterator<Job> iterator = jobs.iterator();
        while (iterator.hasNext()){
            Job job = iterator.next();

            if (job.getId().equals(id)){
                iterator.remove();

                return true;
            }
            return false;
        }
        return false;
    }


}