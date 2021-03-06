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
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "INSERT INTO teacher(login,fname,lname,age,gender,phone,email,subject_id) VALUES (?,?,?,?,?,?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, teacher.getLogin());
            st.setString(2, teacher.getFname());
            st.setString(3, teacher.getLname());
            st.setInt(4, teacher.getAge());
            st.setBoolean(5, teacher.isGender());
            st.setInt(6, teacher.getPhone());
            st.setString(7, teacher.getEmail());
            st.setInt(8, teacher.getSubjectId());


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
    public boolean DeleteTeacherByLogin(String login) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "DELETE FROM teacher WHERE login = ?";
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
    public boolean UpdateTeacherByLogin(String login, String fname, String lname, int age, boolean gender, int phone, String email, int subjectId) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "UPDATE teacher SET fname=?,lname=?,age=?,gender=?,phone=?,email=?,subjectId=? WHERE login=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, fname);
            st.setString(2, lname);
            st.setInt(3, age);
            st.setBoolean(4, gender);
            st.setInt(5, phone);
            st.setString(6, email);
            st.setInt(7, subjectId);

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
    public List<Teacher> GetAllTeachers() {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id,login,fname,lname,age,gender,phone,email,subjectId FROM teacher";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            List<Teacher> teacherArrayList = new ArrayList<>();
            while (rs.next()) {
                Teacher teacher = new Teacher(rs.getInt("id"),
                        rs.getString("login"),
                        rs.getString("fname"),
                        rs.getString("lname"),
                        rs.getInt("age"),
                        rs.getBoolean("gender"),
                        rs.getInt("phone"),
                        rs.getString("email"),
                        rs.getInt("subjectId")
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

    @Override
    public Teacher GetTeacherById(String login) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id,login,fname,lname,age,gender,phone,email,subjectId FROM teacher WHERE login=?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, login);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Teacher teacher = new Teacher(rs.getInt("id"),
                        rs.getString("login"),
                        rs.getString("fname"),
                        rs.getString("lname"),
                        rs.getInt("age"),
                        rs.getBoolean("gender"),
                        rs.getInt("phone"),
                        rs.getString("email"),
                        rs.getInt("subjectId")
                );

                return teacher;
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
    public boolean CreateStudent(Student student) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "INSERT INTO student(login,fname,lname,age,gender,phone,email) VALUES (?,?,?,?,?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, student.getLogin());
            st.setString(2, student.getFname());
            st.setString(3, student.getLname());
            st.setInt(5, student.getAge());
            st.setBoolean(6, student.isGender());
            st.setInt(7, student.getPhone());
            st.setString(8, student.getEmail());


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
    public boolean DeleteStudentByLogin(String login) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "DELETE FROM student WHERE login = ?";
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
    public boolean UpdateStudentByLogin(String login, String fname, String lname, int age, boolean gender, int phone, String email) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "UPDATE student SET fname=?,lname=?,age=?,gender=?,phone=?,email=? WHERE login=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, fname);
            st.setString(2, lname);
            st.setInt(3, age);
            st.setBoolean(4, gender);
            st.setInt(5, phone);
            st.setString(6, email);

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
    public List<Student> GetAllStudents() {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id,login,fname,lname,age,gender,phone,email FROM student";
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);
            List<Student> studentArrayList = new ArrayList<>();
            while (rs.next()) {
                Student student = new Student(rs.getInt("id"),
                        rs.getString("login"),
                        rs.getString("fname"),
                        rs.getString("lname"),
                        rs.getInt("age"),
                        rs.getBoolean("gender"),
                        rs.getInt("phone"),
                        rs.getString("email")
                );

                studentArrayList.add(student);
            }

            return studentArrayList;
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
    public Student GetStudentById(String login) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id,login,fname,lname,age,gender,phone,email FROM student WHERE login=?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, login);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Student student = new Student(rs.getInt("id"),
                        rs.getString("login"),
                        rs.getString("fname"),
                        rs.getString("lname"),
                        rs.getInt("age"),
                        rs.getBoolean("gender"),
                        rs.getInt("phone"),
                        rs.getString("email")
                );

                return student;
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
    public boolean CreateSubject(Subject subject) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "INSERT INTO subject(name) VALUES (?)";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, subject.getName());

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
    public boolean DeleteSubjectById(int id) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "DELETE FROM subject WHERE id = ?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, id);


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
    public boolean UpdateSubjectById(int id, String name) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "UPDATE subject SET name=? WHERE id=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1,name);

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
    public List<Subject> GetAllSubjects() {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id, name FROM subject";
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);
            List<Subject> subjectArrayList = new ArrayList<>();
            while (rs.next()) {
                Subject subject = new Subject(rs.getInt("id"),
                        rs.getString("name")
                );

                subjectArrayList.add(subject);
            }

            return subjectArrayList;
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
    public Subject GetSubjectById(int id) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id,name FROM subject WHERE id=?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, id);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Subject subject = new Subject(rs.getInt("id"),
                        rs.getString("name")
                );

                return subject;
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
                        rs.getInt("subjectid")
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
