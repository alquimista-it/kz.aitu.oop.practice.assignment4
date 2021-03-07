package com.company.repositories.interfaces;

import com.company.entities.Stone;

import java.util.List;

public interface IStoneRepo {
    boolean createStone(Stone stone);
    Stone getStoneById(int id);
    List<Stone> getAllStones();
}
