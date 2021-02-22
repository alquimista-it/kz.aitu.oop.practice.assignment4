package com.company.controllers;

import com.company.entities.Train;
import com.company.entities.Worker;
import com.company.repositories.interfaces.ITrainRepo;
import com.company.repositories.interfaces.IWorkerRepo;

import java.util.List;

public class WorkerCompany {
    private final IWorkerRepo repo;

    public WorkerCompany(IWorkerRepo repo) {
        this.repo = repo;
    }

    public String createWorker( String fname,String lname,String speciality, int cost, String phone) {

        Worker worker = new Worker(lname,fname,speciality,cost,phone);

        boolean created = repo.createWorker(worker);

        return (created ? "Worker was created!" : "TWorker creation was failed!");
    }

    public String getWorker(int id) {
        Worker worker = repo.getWorker(id);

        return (worker== null ? "Worker was not found!" : worker.toString());
    }

    public String getAllWorkers() {
        List<Worker> workerList = repo.getAllWorkers();

        return workerList.toString();
    }
}
