package com.company.entities;

public class Linker {
    private int id; //variable
    private int necklace_id; //variable
    private int stone_id; //variable

    public Linker(){}
    public Linker(int id, int necklace_id, int stone_id){//method
        setId(id);
        setStone_id(stone_id);
        setNecklace_id(necklace_id);
    }
    public Linker(int necklace_id, int stone_id){//method
        setStone_id(stone_id);
        setNecklace_id(necklace_id);
    }
    //getter and setters
    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public int getStone_id() {
        return stone_id;
    }

    public int getNecklace_id() {
        return necklace_id;
    }

    public void setStone_id(int stone_id) {
        this.stone_id = stone_id;
    }

    public void setNecklace_id(int necklace_id) {
        this.necklace_id = necklace_id;
    }
    //override for toString
    @Override
    public String toString(){
        return " Linker id [ id= "+getId()+" , Necklace id= "+ getNecklace_id()+" , Stone id= "+ getStone_id()+"] ";
    }
}
