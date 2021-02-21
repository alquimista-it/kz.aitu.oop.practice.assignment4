package com.company.repositories;

import com.company.data.interfaces.IDB;
import com.company.entities.Train;
import com.company.entities.User;
import com.company.repositories.interfaces.ITrainRepo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TrainRepo implements ITrainRepo {
    private final IDB db;

    public TrainRepo(IDB db) {
        this.db = db;
    }

    @Override
    public boolean createTrain(Train train) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "INSERT INTO train(name,capacity) VALUES (?,?)";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, train.getName());
            st.setInt(2, train.getCapacity());


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
    public Train getTrain(int id) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id,name,capacity FROM train WHERE id=?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, id);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Train train = new Train(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("capacity")
                        );

                return train;
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
    public List<Train> getAllTrains() {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id,name,capacity FROM train";
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);
            List<Train> trains = new ArrayList<>();
            while (rs.next()) {
                Train train = new Train(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("capacity")
                        );

                trains.add(train);
            }

            return trains;
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
