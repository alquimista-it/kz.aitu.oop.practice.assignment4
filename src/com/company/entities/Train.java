package com.company.entities;

public class Train {
    private int id;
    private String name;
    private int capacity;
    public Train(){

    }
    public Train(String name, int capacity){
        this.name=name;
        this.capacity=capacity;

    }
    public Train(int id, String name, int capacity){
        this.id=id;
        this.name=name;
        this.capacity=capacity;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    @Override
    public String toString(){
        return " Train[ id= "+getId()+" ,name= "+getName()+" ,capacity= "+getCapacity()+"] ";
    }
}
