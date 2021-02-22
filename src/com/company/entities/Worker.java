package com.company.entities;

import java.util.List;

public class Worker {

    private int id;
    private String fname;
    private String lname;
    private String speciality;
    private int cost;
    private String phone;

    public Worker(int id, String name, int cost){}
    public Worker(int id, String fname,String lname,String speciality, int cost, String phone){
        setId(id);
        setFname(fname);
        setLname(lname);
        setSpeciality(speciality);
        setCost(cost);
        setPhone(phone);
    }
    public Worker( String fname,String lname,String speciality, int cost, String phone){
        setFname(fname);
        setLname(lname);
        setSpeciality(speciality);
        setCost(cost);
        setPhone(phone);
    }

    public String getPhone() {
        return phone;
    }

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public int getCost() {
        return cost;
    }

    public int getId() {
        return id;
    }


    public void setCost(int cost) {
        this.cost = cost;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString(){
        return " Worker[ id= "+getId()+" ,fname= "+getLname()+ " ,lname= "+getFname()+" ,Speciality "+getSpeciality() +", Cost" +getCost()+", Phone:"+getPhone() + "] ";
    }

}
