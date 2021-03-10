package com.company.repositories.interfaces;

import com.company.data.interfaces.IDB;
import com.company.entities.*;

import java.util.List;

public interface IAdminRepo {
    boolean CreateAdmin(Admin admin);
    Admin DeleteAdminById(int id);
    Admin UpdateAdminById(int id);
    List<Admin> GetAllAdmins();
    Admin GetAdminById(int id);

    boolean CreateTeacher(Teacher teacher);
    Teacher DeleteTeacherById(int id);
    Teacher UpdateTeacherById(int id);
    List<Teacher> GetAllTeachers();
    Teacher GetTeacherById(int id);


    boolean CreateStudent(Student student);
    Student DeleteStudentById(int id);
    Student UpdateStudentById(int id);
    List<Student> GetAllStudents();
    Student GetStudentById(int id);

    boolean CreateSubject(Subject subject);
    Subject DeleteSubjectById(int id);
    Subject UpdateSubjectById(int id);
    List<Subject> GetAllSubjects();
    Subject GetSubjectById(int id);

    boolean AddTeacherToSubject(SubjectAndTeacher subjectAndTeacher);//создаем тичеру сабджект
    List<Teacher> GetAllTeachersBySubjectId(int id);
}
