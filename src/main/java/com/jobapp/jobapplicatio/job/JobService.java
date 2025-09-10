package com.jobapp.jobapplicatio.job;

import java.util.List;

public interface JobService {

    List<Job> findALL();
        void  createJob(Job job);
}
