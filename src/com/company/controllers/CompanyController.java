package com.company.controllers;

import com.company.entities.*;
import com.company.repositories.interfaces.ICompanyRepo;
import com.company.repositories.interfaces.IWorkerRepo;

import java.util.List;

public class CompanyController {
    private final ICompanyRepo repo;
    private final IWorkerRepo repo1;

    public CompanyController(ICompanyRepo repo, IWorkerRepo repo1) {
        this.repo = repo;
        this.repo1 = repo1;
    }


    public String createCompany(String name, int cost) {

        Company company = new Company( name, cost);

        boolean created = repo.createCompany(company);

        return (created ? "Project was created!" : "Project creation was failed!");
    }


    public String getCompany(int id) {
        Company company = repo.getCompany(id);

        return (company == null ? "Project was not found!" : company.toString());
    }

    public String getWorkerbyCompany(int id) {
        Company company = repo.getCompany(id);
        Worker worker=repo1.getWorker(id);


        return (company == null ? "Project was not found!" : company.toString()+worker.toString());
    }

    public String getAllCompanies() {
        List<Company> companies = repo.getAllCompanies();

        return companies.toString();
    }
}
