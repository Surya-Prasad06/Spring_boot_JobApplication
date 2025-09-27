package com.jobapp.jobapplicatio.job.implementaion;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jobapp.jobapplicatio.job.Job;
import com.jobapp.jobapplicatio.job.JobRepository;
import com.jobapp.jobapplicatio.job.JobService;

@Service
public class JobServiceImplementation implements JobService {
    // private List<Job> jobs = new ArrayList<>();
    JobRepository jobrepo;
    

    public JobServiceImplementation(JobRepository jobrepo) {
        this.jobrepo = jobrepo;
    }

    @Override
    public List<Job> findALL() {
        return jobrepo.findAll();
    }

    @Override
    public void createJob(Job job) {
        
        jobrepo.save(job);

    }

    @Override
    public Job getJobById(Long id) {
        return jobrepo.findById(id).orElse(null);
    }

    @Override
    public boolean deletebyid(Long id) {
        try {
            jobrepo.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean updatejob(Long id, Job updatedjob) {
        Optional<Job> joboptional = jobrepo.findById(id);
        if (joboptional.isPresent()) {
            Job job = joboptional.get();
            job.setJobTtitle(updatedjob.getJobTtitle());
            job.setDescription(updatedjob.getDescription());
            job.setLocation(updatedjob.getLocation());
            job.setMaxSalary(updatedjob.getMaxSalary());
            job.setMinSalary(updatedjob.getMinSalary());
            jobrepo.save(job);
            return true;
        }
        return false;

    }

}
