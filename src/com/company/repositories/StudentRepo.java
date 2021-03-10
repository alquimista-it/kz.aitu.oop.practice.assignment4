package com.company.repositories;

import com.company.data.interfaces.IDB;
import com.company.entities.Message;
import com.company.entities.TeacherAndStudents;
import com.company.repositories.interfaces.IStudentRepo;

import java.util.List;

public class StudentRepo implements IStudentRepo {
    private final IDB db;
    public StudentRepo(IDB db){this.db = db;};

    @Override
    public TeacherAndStudents JoinToNewTeacher(TeacherAndStudents teacherAndStudents) {
        return null;
    }

    @Override
    public TeacherAndStudents ExitFromTeacher(TeacherAndStudents teacherAndStudents) {
        return null;
    }

    @Override
    public Message WriteMessage(Message message) {
        return null;
    }

    @Override
    public List<Message> ShowAllTeacherMessages(String student_login) {
        return null;
    }

    @Override
    public List<Message> ShowAllStudentMessages(String teacher_login) {
        return null;
    }

    @Override
    public List<Message> ShowMessagesStudentWithTeacher(String student_login, String teacher_login) {
        return null;
    }

    @Override
    public List<Message> ShowMessagesTeacherWithStudent(String student_login, String teacher_login) {
        return null;
    }

}
