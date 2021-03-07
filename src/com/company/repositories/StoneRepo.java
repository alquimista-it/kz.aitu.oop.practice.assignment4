package com.company.repositories;

import com.company.data.interfaces.IDB;
import com.company.entities.Stone;
import com.company.repositories.interfaces.IStoneRepo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StoneRepo implements IStoneRepo {
    private final IDB db;
    public StoneRepo(IDB db) {
        this.db = db;
    } //link with database

    @Override
    public boolean createStone(Stone stone) {
        Connection con = null;//object
        try {//checking for troubles
            con = db.getConnection();
            String sql = "INSERT INTO stone(name,weight,cost) VALUES (?,?,?)"; //insert data to database
            PreparedStatement st = con.prepareStatement(sql);
            //input
            st.setString(1, stone.getName());
            st.setDouble(2, stone.getWeight());
            st.setInt(3, stone.getCost());


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
    public Stone getStoneById(int id) {
        Connection con = null;
        try {//checking for troubles
            con = db.getConnection();
            String sql = "SELECT  id,name,weight,cost FROM stone WHERE id=?";//select data from database
            PreparedStatement st = con.prepareStatement(sql);
            //input
            st.setInt(1, id);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                //output
                Stone stone = new Stone(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("weight"),
                        rs.getInt("cost")

                );

                return stone;
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
    public List<Stone> getAllStones() {
        Connection con = null;
        try {//checking for troubles
            con = db.getConnection();
            String sql = "SELECT id,name,weight,cost FROM stone"; //select data from database
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);
            List<Stone> stoneList = new ArrayList<>();
            while (rs.next()) {
                //output
                Stone stone = new Stone(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("weight"),
                        rs.getInt("cost")

                );

                stoneList.add(stone);
            }

            return stoneList;
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
