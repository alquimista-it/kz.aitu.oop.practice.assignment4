package com.company.repositories;

import com.company.data.interfaces.IDB;
import com.company.entities.Necklace;
import com.company.entities.Stone;
import com.company.repositories.interfaces.INecklaceRepo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NecklaceRepo implements INecklaceRepo {
    private final IDB db;
    public NecklaceRepo(IDB db) {
        this.db = db;
    } //link with database

    @Override
    public boolean createNecklace(Necklace necklace) {
        Connection con = null;//object
        try {//checking for troubles
            con = db.getConnection();
            String sql = "INSERT INTO necklace(name) VALUES (?)"; //insert data to database
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, necklace.getName());

            boolean executed = st.execute();
            return executed;
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                assert con != null;
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public Necklace getNecklaceById(int id) {
        Connection con = null;
        try {//checking for troubles
            con = db.getConnection();
            String sql = "SELECT id,name,cost FROM necklace WHERE id=?"; //select data from database
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, id);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Necklace necklace = new Necklace(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("weight"),
                        rs.getInt("cost")
                );

                return necklace;
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
    public List<Stone> getStonesByOrder(int id) {
        Connection con = null;
        try {//checking for troubles
            con = db.getConnection();


            String sql =  "SELECT stone.id,stone.name,stone.weight,stone.cost FROM stone join linker ON linker.stone_id=stone.id WHERE linker.necklace_id=?;" ;//select data from database
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            List<Stone> stoneList = new ArrayList<>();
            while (rs.next()) {
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

    @Override
    public List<Necklace> getAllNecklaces() {
        Connection con = null;
        try {//checking for troubles
            con = db.getConnection();
            String sql = "SELECT id,name,weight,cost FROM necklace";//select data from database
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);
            List<Necklace> necklaces = new ArrayList<>();
            while (rs.next()) {
                Necklace necklace = new Necklace(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("weight"),
                        rs.getInt("cost")
                );

                necklaces.add(necklace);
            }

            return necklaces;
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
    public boolean UpdateNecklaceById(int id) {
        Connection con = null;
        try {//checking for troubles
            con = db.getConnection();
            //Update data
            String sql = "Update necklace set cost=(SELECT SUM (stone.cost) FROM stone join linker on linker.stone_id=stone.id WHERE  linker.necklace_id=?) from linker  WHERE  linker.necklace_id=? and necklace.id=?;";
            String sql1 = "Update necklace set weight=(SELECT SUM (stone.weight) FROM stone join linker on linker.stone_id=stone.id WHERE  linker.necklace_id=?) from linker  WHERE  linker.necklace_id=? and necklace.id=?;";
            //do statement
            PreparedStatement st = con.prepareStatement(sql);
            //input
            st.setInt(1, id);
            st.setInt(2, id);
            st.setInt(3, id);
            PreparedStatement st1 = con.prepareStatement(sql1);
            st1.setInt(1, id);
            st1.setInt(2, id);
            st1.setInt(3, id);

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
