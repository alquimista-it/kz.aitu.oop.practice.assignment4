package com.company.repositories.interfaces;

import com.company.entities.Message;
import com.company.entities.TeacherAndStudents;

import java.util.List;

public interface IStudentRepo {
    TeacherAndStudents JoinToNewTeacher(TeacherAndStudents teacherAndStudents); //создаем учеников для учител
    TeacherAndStudents ExitFromTeacher(TeacherAndStudents teacherAndStudents); //выходим из учителя тип из класса

    Message WriteMessage(Message message);
    List<Message> ShowAllTeacherMessages(String student_login);//for student
    List<Message> ShowAllStudentMessages(String teacher_login);//for teacher
    List<Message> ShowMessagesStudentWithTeacher(String student_login,String teacher_login); //for student
    List<Message> ShowMessagesTeacherWithStudent(String student_login,String teacher_login); //for teacher
}
