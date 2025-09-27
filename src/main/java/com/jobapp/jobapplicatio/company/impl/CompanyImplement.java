package com.jobapp.jobapplicatio.company.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jobapp.jobapplicatio.company.Company;
import com.jobapp.jobapplicatio.company.CompanyRepository;
import com.jobapp.jobapplicatio.company.CompanyService;
import com.jobapp.jobapplicatio.job.Job;

@Service
public class CompanyImplement implements CompanyService {

    private CompanyRepository companyrepo;

    public CompanyImplement(CompanyRepository companyrepo) {
        this.companyrepo = companyrepo;
    }

    @Override
    public List<Company> getAllCompanies() {
        return companyrepo.findAll();
    }

    @Override
    public boolean updateCompany(Company company, Long id) {
        Optional<Company> companyoptional = companyrepo.findById(id);
        if (companyoptional.isPresent()) {
            Company companyupdate = companyoptional.get();
            companyupdate.setName(company.getName());
            companyupdate.setDescription(company.getDescription());
            companyupdate.setJobs(company.getJobs());
            companyrepo.save(companyupdate);
            return true;
        }
        return false;
    }

    @Override
    public void createCompany(Company company) {
        companyrepo.save(company);
    }

    @Override
    public boolean deletebyid(Long id) {
        if (companyrepo.existsById(id)) {
            companyrepo.deleteById(id);
            return true;
        }
        return false;

    }

    @Override
    public Company getJobById(Long id) {
       return companyrepo.findById(id).orElse(null);
    }

}
