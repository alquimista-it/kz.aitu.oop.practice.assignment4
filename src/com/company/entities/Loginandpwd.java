package com.company.entities;

public class Loginandpwd {
    private int id;
    private String login;
    private String pwd;
    private int userType;

    public Loginandpwd(){}

    public Loginandpwd(String login, String pwd,int userType){
        setLogin(login);
        setPwd(pwd);
        setUserType(userType);
    }

    public Loginandpwd(int id, String login, String pwd,int userType) {
        setId(id);
        setLogin(login);
        setPwd(pwd);
        setUserType(userType);
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
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

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Override
    public String toString() {
        return "Loginandpwd{" +
                "id=" + getId() +
                ", login='" + getLogin() + '\'' +
                ", pwd='" + getPwd() + '\'' +
                '}';
    }
}
