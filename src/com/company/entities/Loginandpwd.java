package com.company.entities;

public class Loginandpwd {
    private int id;
    private String login;
    private String pwd;

    public Loginandpwd(){}

    public Loginandpwd(String login, String pwd){
        setLogin(login);
        setPwd(pwd);
    }

    public Loginandpwd(int id, String login, String pwd) {
        setId(id);
        setLogin(login);
        setPwd(pwd);
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
