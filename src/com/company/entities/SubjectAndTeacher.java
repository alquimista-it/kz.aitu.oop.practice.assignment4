package com.company.entities;

public class SubjectAndTeacher {
    private int id;
    private int teacherId;
    private int subjectId;

    public SubjectAndTeacher(){}

    public SubjectAndTeacher(int teacherId, int subjectId) {
        setTeacherId(teacherId);
        setSubjectId(subjectId);
    }

    public SubjectAndTeacher(int id, int teacherId, int subjectId) {
    setId(id);
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
