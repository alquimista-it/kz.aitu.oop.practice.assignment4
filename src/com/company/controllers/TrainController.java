package com.company.controllers;

import com.company.entities.Train;
import com.company.entities.User;
import com.company.repositories.interfaces.ITrainRepo;
import com.company.repositories.interfaces.IUserRepository;

import java.util.List;

public class TrainController {
    private final ITrainRepo repo;

    public TrainController(ITrainRepo repo) {
        this.repo = repo;
    }

    public String createTrain( String name, Integer capacity) {

        Train train = new Train(name, capacity);

        boolean created = repo.createTrain(train);

        return (created ? "Train was created!" : "Train creation was failed!");
    }

    public String getTrain(int id) {
        Train train = repo.getTrain(id);

        return (train == null ? "Train was not found!" : train.toString());
    }

    public String getAllTrains() {
        List<Train> trains = repo.getAllTrains();

        return trains.toString();
    }
}
