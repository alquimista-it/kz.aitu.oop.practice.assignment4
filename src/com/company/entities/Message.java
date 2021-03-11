package com.company.entities;

public class Message {
    private int id;
    private boolean direction;
    private String teacher_login;
    private String student_login;
    private String text;

    public Message() {

    }

    public Message(int id, boolean direction, String teacher_login, String student_login,String text) {
      setId(id);
      setDirection(direction);
      setTeacher_login(teacher_login);
      setStudent_login(student_login);
    }

    public Message(boolean direction, String teacher_login, String student_login,String text) {
        setDirection(direction);
        setTeacher_login(teacher_login);
        setStudent_login(student_login);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean getDirection() {
        return direction;
    }

    public void setDirection(boolean direction) {
        this.direction = direction;
    }

    public String getTeacher_login() {
        return teacher_login;
    }

    public void setTeacher_login(String teacher_login) {
        this.teacher_login = teacher_login;
    }

    public String getStudent_login() {
        return student_login;
    }

    public void setStudent_login(String student_login) {
        this.student_login = student_login;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String toString() {
        return "Loginandpwd{" +
                "id=" + getId() +
                ", teacher_id='" + getTeacher_login() + '\'' +
                ", student_id='" + getStudent_login() + '\'' +
                ", message='" + getText() + '\'' +
                '}';

    }
}
