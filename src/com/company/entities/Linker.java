package com.company.entities;

public class Linker {
    private int id;
    private int company_id;
    private int worker_id;

    public Linker (){}
    public Linker(int id, int company_id,int worker_id){
        setId(id);
        setCompany_id(company_id);
        setWorker_id(worker_id);
    }
    public Linker( int company_id, int worker_id){
        setCompany_id( company_id);
        setWorker_id(worker_id);
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public int getCompany_id() {
        return company_id;
    }

    public int getWorker_id() {
        return worker_id;
    }

    public void setCompany_id(int company_id) {
        this.company_id = company_id;
    }

    public void setWorker_id(int worker_id) {
        this.worker_id = worker_id;
    }
    @Override
    public String toString(){
        return " Company[ id= "+getId()+" , Company id= "+getCompany_id()+" , Worker id= "+getWorker_id()+"] ";
    }
}
