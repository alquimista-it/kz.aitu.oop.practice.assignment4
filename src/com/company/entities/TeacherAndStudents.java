package com.company.entities;

public class TeacherAndStudents {
    private int id;
    private int teacherId;
    private int studentId;


    public TeacherAndStudents(){}

    public TeacherAndStudents(int id, int teacherId, int studentId) {
        setId(id);
        setTeacherId(teacherId);
        setStudentId(studentId);
    }

    public TeacherAndStudents(int teacherId, int studentId) {
        setTeacherId(teacherId);
        setStudentId(studentId);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int subjectId) {
        this.studentId = subjectId;
    }

    @Override
    public String toString() {
        return "TeacherAndStudents{" +
                "id=" + getId() +
                ", teacherId=" + getTeacherId() +
                ", subjectId=" + getStudentId() +
                '}';
    }
}
