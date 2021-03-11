package com.company.repositories;

import com.company.data.interfaces.IDB;
import com.company.entities.*;
import com.company.repositories.interfaces.IAdminRepo;

import java.sql.*;
import java.util.ArrayList;
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
    public boolean DeleteAdminByLogin(String login) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "DELETE FROM admin WHERE login = ?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, login);


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
    public boolean UpdateAdminByLogin(String login,String fname,String lname,int phone,String email) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "UPDATE admin SET fname=?,lname=?,phone=?,email=? WHERE login=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, fname);
            st.setString(2, lname);
            st.setInt(3, phone);
            st.setString(4, email);
            st.setString(5, login);

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
    public List<Admin> GetAllAdmins() {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id,login,fname,lname,phone,email FROM admin";
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);
            List<Admin> adminArrayList = new ArrayList<>();
            while (rs.next()) {
                Admin admin = new Admin(rs.getInt("id"),
                        rs.getString("login"),
                        rs.getString("fname"),
                        rs.getString("lname"),
                        rs.getInt("phone"),
                        rs.getString("email")
                );

                adminArrayList.add(admin);
            }

            return adminArrayList;
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
        return null;
    }

    @Override
    public Admin GetAdminById(String login) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id,login,fname,lname,phone,email FROM admin WHERE login=?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, login);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Admin admin = new Admin(rs.getInt("id"),
                        rs.getString("login"),
                        rs.getString("fname"),
                        rs.getString("lname"),
                        rs.getInt("phone"),
                        rs.getString("email")
                );

                return admin;
            }
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
        return null;
    }

    @Override
    public boolean CreateTeacher(Teacher teacher) {
        return false;
    }

    @Override
    public boolean DeleteTeacherByLogin(String login) {
        return false;
    }

    @Override
    public boolean UpdateTeacherByLogin(String login, String fname, String lname, int age, boolean gender, int phone, String email, String subjectId) {
        return false;
    }

    @Override
    public List<Teacher> GetAllTeachers() {
        return null;
    }

    @Override
    public Teacher GetTeacherById(String login) {
        return null;
    }

    @Override
    public boolean CreateStudent(Student student) {
        return false;
    }

    @Override
    public boolean DeleteStudentByLogin(String login) {
        return false;
    }

    @Override
    public boolean UpdateStudentByLogin(String login, String fname, String lname, int age, boolean gender, int phone, String email) {
        return false;
    }

    @Override
    public List<Student> GetAllStudents() {
        return null;
    }

    @Override
    public Student GetStudentById(String login) {
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
    public boolean UpdateSubjectById(int id, String name) {
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
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "INSERT INTO subjectandteacher(teacher_id,subject_id) VALUES (?,?)";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, subjectAndTeacher.getTeacherId());
            st.setInt(2,subjectAndTeacher.getSubjectId());

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
    public List<Teacher> GetAllTeachersBySubjectId(int id) {
        Connection con = null;
        try {
            con = db.getConnection();

//            boolean male = (gender.toLowerCase().equals("male"));

            String sql =  "SELECT teacher.id,teacher.login,teacher.fname,teacher.lname,teacher.age,teacher.gender,teacher.phone,teacher.email,teacher.subjectid FROM teacher join subjectandteacher ON subjectandteacher.teacher_id=teacher.id WHERE subjectandteacher.subject_id=?;" ;
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            List<Teacher> teacherArrayList = new ArrayList<>();
            while (rs.next()) {
                Teacher teacher = new Teacher(rs.getInt("id"),
                        rs.getString("login"),
                        rs.getString("fname"),
                        rs.getString("lname"),
                        rs.getInt("age"),
                        rs.getBoolean("gender"), //обратный трансфер будет в апликэйшоне или в контроллере
                        rs.getInt("phone"),
                        rs.getString("email"),
                        rs.getString("subjectid")
                );

                teacherArrayList.add(teacher);
            }

            return teacherArrayList;
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
        return null;
    }
}
