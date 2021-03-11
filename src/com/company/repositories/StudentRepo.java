package com.company.repositories;

import com.company.data.interfaces.IDB;
import com.company.entities.Message;
import com.company.entities.TeacherAndStudents;
import com.company.repositories.interfaces.IStudentRepo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentRepo implements IStudentRepo {
    private final IDB db;
    public StudentRepo(IDB db){this.db = db;};

    @Override
    public boolean JoinToNewTeacher(TeacherAndStudents teacherAndStudents) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "INSERT INTO teacherandsstudents(teacher_id,student_id) VALUES (?,?)";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, teacherAndStudents.getTeacherId());
            st.setInt(2,teacherAndStudents.getStudentId());

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
    public boolean ExitFromTeacher(TeacherAndStudents teacherAndStudents) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "DELETE FROM teacherandsstudents WHERE teacher_id= ? and student_id=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, teacherAndStudents.getTeacherId());
            st.setInt(2, teacherAndStudents.getStudentId());

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
    public boolean WriteMessage(Message message) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "INSERT INTO messages(direction,teacher_login,student_login,message) VALUES (?,?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);

            st.setBoolean(1, message.getDirection());
            st.setString(2,message.getTeacher_login());
            st.setString(1, message.getTeacher_login());
            st.setString(1, message.getStudent_login());
            st.setString(1, message.getText());


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
    public List<Message> ShowAllTeacherMessages(String student_login) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql =  "SELECT id,direction,teacher_login,student_login,message FROM message WHERE student_login=? and direction=false;" ;
            PreparedStatement st = con.prepareStatement(sql); //если фолс то смотрим все сообщения для ученика от учителей
            st.setString(1, student_login);

            ResultSet rs = st.executeQuery();
            List<Message> messageArrayList = new ArrayList<>();
            while (rs.next()) {
                Message message = new Message(rs.getInt("id"),
                        rs.getBoolean("direction"),
                        rs.getString("teacher_login"),
                        rs.getString("student_login"),
                        rs.getString("message")
                );

                messageArrayList.add(message);
            }

            return messageArrayList;
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
    public List<Message> ShowAllStudentMessages(String teacher_login) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql =  "SELECT id,teacher_login,student_login,message FROM message WHERE student_login=? and direction=true;" ;
            PreparedStatement st = con.prepareStatement(sql); // если тру то смотрим все сообщения для учителя от учеников
            st.setString(1, teacher_login);

            ResultSet rs = st.executeQuery();
            List<Message> messageArrayList = new ArrayList<>();
            while (rs.next()) {
                Message message = new Message(rs.getInt("id"),
                        rs.getBoolean("direction"),
                        rs.getString("teacher_login"),
                        rs.getString("student_login"),
                        rs.getString("message")
                );

                messageArrayList.add(message);
            }

            return messageArrayList;
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
    public List<Message> ShowMessagesStudentWithTeacher(String student_login, String teacher_login) {
        Connection con = null; //for student
        try {
            con = db.getConnection();
            String sql =  "SELECT id,teacher_login,student_login,message FROM message WHERE student_login=? and direction=false and teacher_login=?;" ;
            PreparedStatement st = con.prepareStatement(sql); //если фолс то смотрим все сообщения для ученика от учителей
            st.setString(1, student_login);
            st.setString(2, teacher_login);

            ResultSet rs = st.executeQuery();
            List<Message> messageArrayList = new ArrayList<>();
            while (rs.next()) {
                Message message = new Message(rs.getInt("id"),
                        rs.getBoolean("direction"),
                        rs.getString("teacher_login"),
                        rs.getString("student_login"),
                        rs.getString("message")
                );

                messageArrayList.add(message);
            }

            return messageArrayList;
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
    public List<Message> ShowMessagesTeacherWithStudent(String student_login, String teacher_login) {
        Connection con = null; //for teacher
        try {
            con = db.getConnection();
            String sql =  "SELECT id,teacher_login,student_login,message FROM message WHERE  teacher_login=? and direction=true and student_login=?;" ;
            PreparedStatement st = con.prepareStatement(sql); // если тру то смотрим все сообщения для учителя от учеников
            st.setString(1, teacher_login);
            st.setString(2, student_login);

            ResultSet rs = st.executeQuery();
            List<Message> messageArrayList = new ArrayList<>();
            while (rs.next()) {
                Message message = new Message(rs.getInt("id"),
                        rs.getBoolean("direction"),
                        rs.getString("teacher_login"),
                        rs.getString("student_login"),
                        rs.getString("message")
                );

                messageArrayList.add(message);
            }

            return messageArrayList;
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
