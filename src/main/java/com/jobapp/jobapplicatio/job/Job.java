package com.jobapp.jobapplicatio.job;

public class Job {

    private Long id;
    private String jobTtitle;


    private String description;
    private String minSalary;
    private String maxSalary;
    private String location;

    public Job(String location, String maxSalary, String minSalary, String description, String jobTtitle, Long id) {
        this.id = id;
        this.jobTtitle = jobTtitle;
        this.description = description;
        this.minSalary = minSalary;
        this.maxSalary = maxSalary;
        this.location = location;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getJobTtitle() {
        return jobTtitle;
    }

    public void setJobTtitle(String jobTtitle) {
        this.jobTtitle = jobTtitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMinSalary() {
        return minSalary;
    }

    public void setMinSalary(String minSalary) {
        this.minSalary = minSalary;
    }
    public String getMaxSalary() {
        return maxSalary;
    }

    public void setMaxSalary(String maxSalary) {
        this.maxSalary = maxSalary;
    }
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
