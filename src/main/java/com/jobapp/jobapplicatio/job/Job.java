package com.jobapp.jobapplicatio.job;

public class Job {

    private Long id;
    private String jobTtitle;


    private String description;
    private String minSalary;
    private String maxSalary;
    private String location;

    public Job(String location, String maxSalary, String minSalary, String description, String jobTtitle, Long id) {
        this.location = location;
        this.maxSalary = maxSalary;
        this.minSalary = minSalary;
        this.description = description;
        this.jobTtitle = jobTtitle;
        this.id = id;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getMaxSalary() {
        return maxSalary;
    }

    public void setMaxSalary(String maxSalary) {
        this.maxSalary = maxSalary;
    }

    public String getMinSalary() {
        return minSalary;
    }

    public void setMinSalary(String minSalary) {
        this.minSalary = minSalary;
    }

    public String getJobTtitle() {
        return jobTtitle;
    }

    public void setJobTtitle(String jobTtitle) {
        this.jobTtitle = jobTtitle;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
