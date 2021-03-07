package com.company.entities;

public class Stone {
    private int id;//variable
    private String name;//variable
    private double weight;//variable
    private int cost;//variable

    public Stone(){}//method
    public Stone(String name, double weight, int cost){//method
        setName(name);
        setCost(cost);

    }
    public Stone(int id, String name, double weight, int cost){//method
        setId(id);
        setName(name);
        setCost(cost);

    }
    // getter and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
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
    //override for toString
    @Override
    public String toString(){
        return " Stone[ id= "+getId()+" ,name= "+getName()+" ,cost= "+getCost()+" weight="+getWeight()+"] ";
    }
}
