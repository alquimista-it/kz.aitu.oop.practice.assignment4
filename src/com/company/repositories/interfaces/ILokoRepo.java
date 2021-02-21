package com.company.repositories.interfaces;

import com.company.entities.Locomotive;
import com.company.entities.Train;

import java.util.List;

public interface ILokoRepo {
    boolean createLocomotive(Locomotive locomotive);
    Locomotive getLocomotive(int id);
    Locomotive getTrainbyLocomotive(int id);
    List<Locomotive> getAllLocomotives();

}
