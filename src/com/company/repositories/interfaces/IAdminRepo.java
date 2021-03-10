package com.company.repositories.interfaces;

import com.company.data.interfaces.IDB;
import com.company.entities.*;

import java.util.List;

public interface IAdminRepo {
    boolean CreateAdmin(Admin admin);
    boolean DeleteAdminByLogin(String login);
    boolean UpdateAdminByLogin(String login,String fname,String lname,int phone,String email);
    List<Admin> GetAllAdmins();
    Admin GetAdminById(String login);

    boolean CreateTeacher(Teacher teacher);
    boolean DeleteTeacherByLogin(String login);
    boolean UpdateTeacherByLogin(String login, String fname, String lname, int age, boolean gender, int phone, String email, String subjectId);
    List<Teacher> GetAllTeachers();
    Teacher GetTeacherById(String login);


    boolean CreateStudent(Student student);
    boolean DeleteStudentByLogin(String login);
    boolean UpdateStudentByLogin(String login, String fname, String lname, int age, boolean gender, int phone, String email);
    List<Student> GetAllStudents();
    Student GetStudentById(String login);

    boolean CreateSubject(Subject subject);
    boolean DeleteSubjectById(int id);
    boolean UpdateSubjectById(int id, String name);
    List<Subject> GetAllSubjects();
    Subject GetSubjectById(int id);

    boolean AddTeacherToSubject(SubjectAndTeacher subjectAndTeacher);//создаем тичеру сабджект
    List<Teacher> GetAllTeachersBySubjectId(int id);
}
