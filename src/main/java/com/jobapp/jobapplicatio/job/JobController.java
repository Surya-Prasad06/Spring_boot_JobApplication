package com.jobapp.jobapplicatio.job;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class JobController {

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    private  JobService jobService;


    @GetMapping("/jobs")
    public List<Job> findAll(){
        return jobService.findALL();
    }
    @PostMapping("/jobs")
    public String createJob(@RequestBody  Job job){

       jobService.createJob(job);
       return "successfully added the job";
    }

    @GetMapping("/jobs/{id}")
    public  Job getJobById(@PathVariable Long id){
        Job job = jobService.getJobById(id);
        if (job != null) {
        return  job;
        }
        return new Job("hyderabad", "0", "0", "test job", "tester", 1L)
    }
}
