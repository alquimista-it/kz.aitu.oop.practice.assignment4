package com.company.repositories.interfaces;

import com.company.entities.Company;
import com.company.entities.Linker;
import com.company.entities.Locomotive;
import com.company.entities.Worker;

import java.util.List;

public interface ICompanyRepo {
    boolean createCompany(Company company);
    Company getCompany(int id);
    List<Worker> getWorkersByCompany(int id);
    List<Company> getAllCompanies();



}
