package com.company.controllers;

import com.company.entities.Linker;
import com.company.repositories.interfaces.ICompanyRepo;
import com.company.repositories.interfaces.ILinker;
import com.company.repositories.interfaces.IWorkerRepo;

public class LinkerController {
    private final ILinker repo;

    public LinkerController(ILinker repo) {
        this.repo = repo;
    }
    public String plusWorkerToCompany(int company_id,int worker_id) {

        Linker linker = new Linker( company_id, worker_id);

        boolean created = repo.createlinker(linker);

        return (created ? "Worker was created in project!" : "Creation was failed!");
    }
}
