package com.company.repositories.interfaces;

import com.company.data.interfaces.IDB;
import com.company.entities.Admin;
import com.company.entities.Student;
import com.company.entities.Subject;
import com.company.entities.Teacher;

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


    boolean CreateStudent(Student student);
    Student DeleteStudentById(int id);
    Student UpdateStudentById(int id);


    boolean CreateSubject(Subject subject);
    Subject DeleteSubjectById(int id);
    Subject UpdateSubjectById(int id);


}
