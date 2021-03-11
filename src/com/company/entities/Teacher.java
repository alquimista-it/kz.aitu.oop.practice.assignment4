package com.company.entities;

public class Teacher {
    private int id;
    private String login;
    private String fname;
    private String lname;
    private int age;
    private boolean gender;
    private int phone;
    private String email;
    private int subjectId;

    public Teacher(){}

    public Teacher(int id, String login, String fname, String lname, int age, boolean gender, int phone, String email, int subjectId) {
        setId(id);
        setLogin(login);
        setFname(fname);
        setLname(lname);
        setAge(age);
        setGender(gender);
        setPhone(phone);
        setEmail(email);
        setSubjectId(subjectId);
    }

    public Teacher(String login, String fname, String lname, int age, boolean gender, int phone, String email, int subjectId) {
        setLogin(login);
        setFname(fname);
        setLname(lname);
        setAge(age);
        setGender(gender);
        setPhone(phone);
        setEmail(email);
        setSubjectId(subjectId);
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

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }


    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + getId() +
                ", login='" + getLogin() + '\'' +
                ", fname='" + getFname() + '\'' +
                ", lname='" + getLname() + '\'' +
                ", age=" + getAge() +
                ", gender=" + isGender() +
                ", phone=" + getPhone() +
                ", email='" + getEmail() + '\'' +
                ", subjectId='" + getSubjectId() + '\'' +
                '}';
    }
}
