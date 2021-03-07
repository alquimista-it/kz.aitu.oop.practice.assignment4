package com.company.entities;

import java.util.List;

public class Necklace {
    private int id;//variable
    private String name;//variable
    private double weight;//variable
    private int cost;//variable

    private List<Stone> stoneList;//variable

    public Necklace(){}//method
    public Necklace(String name, double weight, int cost){//method
        setName(name);
        setCost(cost);

    }
    public Necklace(int id, String name, double weight, int cost){//method
        setId(id);
        setName(name);
        setCost(cost);

    }
    //getter and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getCost() {
        return cost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStoneList(List<Stone> stoneList) {
        this.stoneList = stoneList;
    }

    public List<Stone> getStoneList() {
        return stoneList;
    }
    //override for toString
    @Override
    public String toString(){
        return " Necklace[ id= "+getId()+" ,name= "+getName()+" ,cost= "+getCost()+"] ";
    }
}
