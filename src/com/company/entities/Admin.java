package com.company.entities;

public class Admin {
    private int id;
    private String login;
    private String fname;
    private String lname;
    private int phone;
    private String email;

    public Admin(){
    }

    public Admin(int id, String login, String fname, String lname, int phone, String email) {
       setId(id);
       setEmail(email);
       setFname(fname);
       setLname(lname);
       setLogin(login);
       setPhone(phone);
    }

    public Admin(String login, String fname, String lname, int phone, String email) {

        setEmail(email);
        setFname(fname);
        setLname(lname);
        setLogin(login);
        setPhone(phone);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
       return " Admin id [ id= "+getId()+" , Login= "+getLogin()+" , First name= "+getFname()+" , Last name= "+getLname()+" , Phone= "+getPhone()+" , Email= "+getEmail()+"] ";
    }
}
