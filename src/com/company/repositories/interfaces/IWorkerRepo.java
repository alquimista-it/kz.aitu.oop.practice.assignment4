package com.company.repositories.interfaces;

import com.company.entities.Train;
import com.company.entities.Worker;

import java.util.List;

public interface IWorkerRepo {
    boolean createWorker(Worker worker);
    Worker getWorker(int id);
    List<Worker> getAllWorkers();
}
