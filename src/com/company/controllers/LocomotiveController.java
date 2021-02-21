package com.company.controllers;

import com.company.entities.Locomotive;
import com.company.entities.Train;
import com.company.repositories.interfaces.ILokoRepo;
import com.company.repositories.interfaces.ITrainRepo;

import java.util.List;

public class LocomotiveController {
    private final ILokoRepo repo;
    private final ITrainRepo repo1;

    public LocomotiveController(ILokoRepo repo, ITrainRepo repo1) {
        this.repo = repo;this.repo1 = repo1;
    }


    public String createLocomotive(String name, Integer train_id) {

        Locomotive locomotive = new Locomotive( name, train_id);

        boolean created = repo.createLocomotive(locomotive);

        return (created ? "Locomotive was created!" : "Locomotive creation was failed!");
    }

    public String getLocomotive(int id) {
        Locomotive locomotive = repo.getLocomotive(id);

        return (locomotive == null ? "Locomotive was not found!" : locomotive.toString());
    }

    public String getTrainbyLocomotive(int id) {
        Locomotive locomotive = repo.getLocomotive(id);
        Train train=repo1.getTrain(id);


        return (locomotive == null ? "Locomotive was not found!" : locomotive.toString()+train.toString());
    }

    public String getAllLocomotive() {
        List<Locomotive> locomotives = repo.getAllLocomotives();

        return locomotives.toString();
    }
}
