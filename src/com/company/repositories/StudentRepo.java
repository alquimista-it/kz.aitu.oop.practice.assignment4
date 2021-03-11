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


            String sql =  "SELECT medicament.id,medicament.name,medicament.cost,medicament.description FROM medicament join bind ON bind.med_id=medicament.id WHERE bind.order_id=?;" ;
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, student_login);
            ResultSet rs = st.executeQuery();
            List<Message> messageArrayList = new ArrayList<>();
            while (rs.next()) {
                Message message = new Message(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("cost"),
                        rs.getString("description")
                );

                medicamentList.add(medicament);
            }

            return medicamentList;
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
