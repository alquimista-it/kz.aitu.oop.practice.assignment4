package com.company.repositories.interfaces;

import com.company.data.interfaces.IDB;
import com.company.entities.*;

import java.util.List;

public interface IAdminRepo {
    boolean CreateAdmin(Admin admin);
    boolean DeleteAdminById(int id);
    boolean UpdateAdminById(int id);
    List<Admin> GetAllAdmins();
    Admin GetAdminById(int id);

    boolean CreateTeacher(Teacher teacher);
    boolean DeleteTeacherById(int id);
    boolean UpdateTeacherById(int id);
    List<Teacher> GetAllTeachers();
    Teacher GetTeacherById(int id);


    boolean CreateStudent(Student student);
    boolean DeleteStudentById(int id);
    boolean UpdateStudentById(int id);
    List<Student> GetAllStudents();
    Student GetStudentById(int id);

    boolean CreateSubject(Subject subject);
    boolean DeleteSubjectById(int id);
    boolean UpdateSubjectById(int id);
    List<Subject> GetAllSubjects();
    Subject GetSubjectById(int id);

    boolean AddTeacherToSubject(SubjectAndTeacher subjectAndTeacher);//создаем тичеру сабджект
    List<Teacher> GetAllTeachersBySubjectId(int id);
}
