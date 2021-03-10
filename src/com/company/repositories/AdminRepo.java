package com.company.repositories;

import com.company.data.interfaces.IDB;
import com.company.entities.*;
import com.company.repositories.interfaces.IAdminRepo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class AdminRepo implements IAdminRepo {
    private final IDB db;
    public AdminRepo(IDB db){this.db = db;};

    @Override
    public boolean CreateAdmin(Admin admin) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "INSERT INTO admin(login,fname,lname,phone,email) VALUES (?,?,?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, admin.getLogin());
            st.setString(2, admin.getFname());
            st.setString(3, admin.getLname());
            st.setInt(4, admin.getPhone());
            st.setString(5, admin.getEmail());


            boolean executed = st.execute();
            return executed;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return false;
    }


    @Override
    public boolean DeleteAdminById(int id) {
        return false;
    }

    @Override
    public boolean UpdateAdminById(int id) {
        return false;
    }

    @Override
    public List<Admin> GetAllAdmins() {
        return null;
    }

    @Override
    public Admin GetAdminById(int id) {
        return null;
    }

    @Override
    public boolean CreateTeacher(Teacher teacher) {
        return false;
    }

    @Override
    public boolean DeleteTeacherById(int id) {
        return false;
    }

    @Override
    public boolean UpdateTeacherById(int id) {
        return false;
    }

    @Override
    public List<Teacher> GetAllTeachers() {
        return null;
    }

    @Override
    public Teacher GetTeacherById(int id) {
        return null;
    }

    @Override
    public boolean CreateStudent(Student student) {
        return false;
    }

    @Override
    public boolean DeleteStudentById(int id) {
        return false;
    }

    @Override
    public boolean UpdateStudentById(int id) {
        return false;
    }

    @Override
    public List<Student> GetAllStudents() {
        return null;
    }

    @Override
    public Student GetStudentById(int id) {
        return null;
    }

    @Override
    public boolean CreateSubject(Subject subject) {
        return false;
    }

    @Override
    public boolean DeleteSubjectById(int id) {
        return false;
    }

    @Override
    public boolean UpdateSubjectById(int id) {
        return false;
    }

    @Override
    public List<Subject> GetAllSubjects() {
        return null;
    }

    @Override
    public Subject GetSubjectById(int id) {
        return null;
    }

    @Override
    public boolean AddTeacherToSubject(SubjectAndTeacher subjectAndTeacher) {
        return false;
    }

    @Override
    public List<Teacher> GetAllTeachersBySubjectId(int id) {
        return null;
    }
}
