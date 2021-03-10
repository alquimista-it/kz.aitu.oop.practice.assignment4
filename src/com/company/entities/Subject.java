package com.company.entities;

public class Subject {
    private int id;
    private String name;

    public Subject(){}

    public Subject(String name) {
        setName(name);
    }

    public Subject(int id, String name) {
    setId(id);
    setName(name);
    }
//gyygvy
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                '}';
    }
}
