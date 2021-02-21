package com.company.repositories;

import com.company.data.interfaces.IDB;
import com.company.entities.Locomotive;
import com.company.entities.Train;
import com.company.repositories.interfaces.ILokoRepo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LokoRepo implements ILokoRepo {
    private final IDB db;

    public LokoRepo(IDB db) {
        this.db = db;
    }

    @Override
    public boolean createLocomotive(Locomotive locomotive) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "INSERT INTO locomotives(name,train_id) VALUES (?,?)";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, locomotive.getName());
            st.setInt(2, locomotive.getTrain_id());


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
    public Locomotive getLocomotive(int id) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id,name,train_id FROM locomotives WHERE id=?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, id);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Locomotive locomotive = new Locomotive(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("train_id")
                );

                return locomotive;
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

    //SELECT a.id, a.name, a.num, b.date, b.roll
    //FROM a
    //INNER JOIN b ON a.id=b.id;
    @Override
    public Locomotive getTrainbyLocomotive(int id) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT locomotives.id,locomotives.name,train.train_id,train.name,train.capacity FROM locomotives " +
                    "INNER JOIN train ON locomotives.train_id=train.id";

            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, id);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Locomotive locomotive = new Locomotive(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("train_id")
                );

                return locomotive;
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
    public List<Locomotive> getAllLocomotives() {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id,name,train_id FROM locomotives";
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);
            List<Locomotive> locomotives = new ArrayList<>();
            while (rs.next()) {
                Locomotive locomotive = new Locomotive(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("train_id")
                );

                locomotives.add(locomotive);
            }

            return locomotives;
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
