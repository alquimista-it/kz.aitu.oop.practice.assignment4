package com.company.controllers;

import com.company.entities.Stone;
import com.company.repositories.interfaces.IStoneRepo;


import java.util.List;

public class StoneController {
    private final IStoneRepo repo;
    //using repositories
    public StoneController(IStoneRepo repo) {
        this.repo = repo;
    }

    public String createStone( String name,double weight,int cost) {

        Stone stone = new Stone(name,weight,cost); //do function

        boolean created = repo.createStone(stone); //do function

        return (created ? "Stone was created!" : "Failed!");
    }

    public String getStone(int id) {
        Stone stone = repo.getStoneById(id);//do function

        return (stone == null ? "Not founded!" : stone.toString());
    }

    public String getAllStones() {
        List<Stone> stoneList = repo.getAllStones(); //do function

        return stoneList.toString();
    }
}
