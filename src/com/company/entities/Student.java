package com.company.entities;

public class Student {
    private int id;
    private String login;
    private String fname;
    private String lname;
    private int age;
    private boolean gender;
    private int phone;
    private String email;

    public Student(){}

    public Student(String login, String fname, String lname, int age, boolean gender, int phone, String email) {
    setLogin(login);
    setFname(fname);
    setLname(lname);
    setAge(age);
    setGender(gender);
    setPhone(phone);
    setEmail(email);
    }

    public Student(int id, String login, String fname, String lname, int age, boolean gender, int phone, String email) {
        setId(id);
        setLogin(login);
        setFname(fname);
        setLname(lname);
        setAge(age);
        setGender(gender);
        setPhone(phone);
        setEmail(email);
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
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
        return "Student{" +
                "id=" + getId() +
                ", login='" + getLogin() + '\'' +
                ", fname='" + getFname() + '\'' +
                ", lname='" + getLname() + '\'' +
                ", age=" + getAge() +
                ", gender=" + isGender() +
                ", phone=" + getPhone() +
                ", email='" + getEmail() + '\'' +
                '}';
    }
}
