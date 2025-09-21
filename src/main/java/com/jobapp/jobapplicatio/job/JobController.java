package com.jobapp.jobapplicatio.job;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.JobName;
import java.util.List;
@RestController
public class JobController {
    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    private  JobService jobService;
    @GetMapping("/jobs")
    public ResponseEntity<List<Job>> findAll(){
        return  ResponseEntity.ok(jobService.findALL()) ; // return jobs;
    }

    @PostMapping("/jobs")
    public ResponseEntity<String> createJob(@RequestBody  Job job){
       jobService.createJob(job);
       return new ResponseEntity<>("Job Added successfully", HttpStatus.CREATED);
    }

    @GetMapping("/jobs/{id}")
    public ResponseEntity<Job> getJobById(@PathVariable Long id){

        Job job = jobService.getJobById(id);
        if (job != null) {
            return  new ResponseEntity<Job>(job, HttpStatus.OK);
        }
        return new ResponseEntity<Job>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/job/{id}")

    public ResponseEntity<String> deleteJob(@PathVariable Long id){
        boolean deleted = jobService.deletebyid(id);

        if (deleted){
            return new ResponseEntity<>("job deleted successfully" , HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

}
