package com.jobapp.jobapplicatio.job;

import java.util.List;

public interface JobService {

    List<Job> findALL();


    void  createJob(Job job);

    Job getJobById(Long id);


    boolean deletebyid(Long id);


    boolean updatejob(Long id, Job updatedjob);


    
}
