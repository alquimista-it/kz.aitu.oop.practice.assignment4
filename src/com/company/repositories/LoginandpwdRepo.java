package com.company.repositories;

import com.company.data.interfaces.IDB;
import com.company.entities.Admin;
import com.company.entities.Loginandpwd;
import com.company.entities.Student;
import com.company.entities.Teacher;
import com.company.repositories.interfaces.ILoginandpwd;

import java.awt.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LoginandpwdRepo implements ILoginandpwd {
    private final IDB db;
    public LoginandpwdRepo(IDB db){this.db = db;};

    @Override
    public boolean CreateLoginAndPwd(Loginandpwd loginandpwd) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "INSERT INTO loginandpwd(login,pwd,usertype) VALUES (?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, loginandpwd.getLogin());
            st.setString(2,loginandpwd.getPwd());
            st.setInt(3,loginandpwd.getUserType());//1-admin 2-teacher 3-student

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
    public boolean CheckPwd(String login) {

        return false;
    }

    @Override
    public boolean UpdateLoginAndPwd(int id,String pwd,String login,int usertype) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "UPDATE loginandpwd SET login=?,pwd=?,usertype=? WHERE id=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, login);
            st.setString(2, pwd);
            st.setInt(3, usertype);
            st.setInt(4, id);


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



}
