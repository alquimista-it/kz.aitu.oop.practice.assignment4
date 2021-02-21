package com.company.entities;

public class Locomotive {
    private int id;
    private String name;
    private int train_id;

    public Locomotive(){

    }
    public Locomotive(String name,int train_id){
        setTrain_id(train_id);
        setName(name);
    }
    public Locomotive(int id,String name,int train_id){
        setTrain_id(train_id);
        setName(name);
        setId(id);
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public int getTrain_id() {
        return train_id;
    }

    public void setTrain_id(int train_id) {
        this.train_id = train_id;
    }

    public void setId(int id) {
        this.id = id;
    }
    @Override
    public String toString(){
        return " Locomotive[ id= "+getId()+" ,name= "+getName()+" ,train_id= "+getTrain_id()+"] ";
    }
}
