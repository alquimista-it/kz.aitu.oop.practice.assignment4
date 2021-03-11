package com.company.repositories;

import com.company.data.interfaces.IDB;
import com.company.entities.Admin;
import com.company.entities.Loginandpwd;
import com.company.entities.Student;
import com.company.entities.Teacher;
import com.company.repositories.interfaces.ILoginandpwd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LoginandpwdRepo implements ILoginandpwd {
    private final IDB db;
    public LoginandpwdRepo(IDB db){this.db = db;};

    @Override
    public boolean CreateLoginAndPwd(Loginandpwd loginandpwd) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "INSERT INTO loginandpwd(login,pwd) VALUES (?,?)";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, loginandpwd.getLogin());
            st.setString(2,loginandpwd.getPwd());

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
    public boolean CheckPwd(int id) {
        return false;
    }

    @Override
    public boolean UpdateLoginAndPwd(int id,String pwd,String login) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "UPDATE loginandpwd SET login=?,pwd=? WHERE id=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, login);
            st.setString(2, pwd);
            st.setInt(3, id);


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
