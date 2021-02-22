package com.company.repositories;

import com.company.data.interfaces.IDB;
import com.company.entities.Company;
import com.company.entities.Worker;
import com.company.repositories.interfaces.IWorkerRepo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class WorkerRepo implements IWorkerRepo {
    private final IDB db;
    public WorkerRepo(IDB db) {
        this.db = db;
    }


    @Override
    public boolean createWorker(Worker worker) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "INSERT INTO worker(fname,lname,speciality,cost,phone) VALUES (?,?,?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, worker.getFname());
            st.setString(2, worker.getLname());
            st.setString(3, worker.getSpeciality());
            st.setInt(4, worker.getCost());
            st.setString(5, worker.getPhone());

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
    public Worker getWorker(int id) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id,fname,lname,speciality,cost,phone FROM worker WHERE id=?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, id);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Worker worker = new Worker(rs.getInt("id"),
                        rs.getString("fname"),
                        rs.getString("lname"),
                        rs.getString("speciality"),
                        rs.getInt("cost"),
                        rs.getString("phone")
                );

                return worker;
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
    public List<Worker> getAllWorkers() {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id,fname,lname,speciality,cost,phone FROM worker";
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);
            List<Worker> workerList = new ArrayList<>();
            while (rs.next()) {
                Worker worker = new Worker(rs.getInt("id"),
                        rs.getString("lname"),
                        rs.getString("fname"),
                        rs.getString("speciality"),
                        rs.getInt("cost"),
                        rs.getString("phone")
                );

                workerList.add(worker);
            }

            return workerList;
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
