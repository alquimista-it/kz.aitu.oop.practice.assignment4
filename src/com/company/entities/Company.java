package com.company.entities;

import java.util.List;

public class Company {
    private int id;
    private String name;
    private int cost;
    private List<Worker> workerList;


    public Company (){}
    public Company(int id, String name, int cost){
        setId(id);
        setName(name);
        setCost(cost);
    }
    public Company( String name, int cost){
        setName(name);
        setCost(cost);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getCost() {
        return cost;
    }

    public int getId() {
        return id;
    }

    public List<Worker> getWorkerList() {
        return workerList;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setWorkerList(List<Worker> workerList) {
        this.workerList = workerList;
    }

    @Override
    public String toString(){
        return " Company[ id= "+getId()+" ,name= "+getName()+" , Cost= "+getCost()+"] ";
    }
}
