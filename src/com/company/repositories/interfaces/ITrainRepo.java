package com.company.repositories.interfaces;

import com.company.entities.Train;
import com.company.entities.User;

import java.util.List;

public interface ITrainRepo {
    boolean createTrain(Train train);
    Train getTrain(int id);
    List<Train> getAllTrains();

}
