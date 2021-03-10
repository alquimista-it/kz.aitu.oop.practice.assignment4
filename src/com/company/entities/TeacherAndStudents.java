package com.company.entities;

public class TeacherAndStudents {
    private int id;
    private int teacherId;
    private int subjectId;


    public TeacherAndStudents(){}

    public TeacherAndStudents(int id, int teacherId, int subjectId) {
        setId(id);
        setTeacherId(teacherId);
        setSubjectId(subjectId);
    }

    public TeacherAndStudents(int teacherId, int subjectId) {
        setTeacherId(teacherId);
        setSubjectId(subjectId);
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

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }
}
