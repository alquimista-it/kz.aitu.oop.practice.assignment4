package com.company.repositories;

import com.company.data.interfaces.IDB;
import com.company.entities.Company;
import com.company.entities.Linker;
import com.company.entities.Worker;
import com.company.repositories.interfaces.ICompanyRepo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CompanyRepo implements ICompanyRepo {
    private final IDB db;
    public CompanyRepo(IDB db) {
        this.db = db;
    }

    @Override
    public boolean createCompany(Company company){
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "INSERT INTO company(name) VALUES (?)";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, company.getName());



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
    public Company getCompany(int id){
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id,name,cost FROM company WHERE id=?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, id);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
               Company company = new Company(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("cost")
                );

                return company;
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
    public List<Worker> getWorkersByCompany(int id){
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT company.id,worker.id,worker.fname,worker.lname,worker.speciality,worker.cost,worker.phone FROM worker,company,linker WHERE worker.id=linker.worker_id and linker.worker_id=?;" +
                    "UPDATE company SET cost=(SELECT SUM (worker.cost) FROM worker,linker WHERE worker.id=linker.worker_id and linker.worker_id=?);";
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

    @Override
    public List<Company> getAllCompanies(){
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id,name,cost FROM company";
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);
            List<Company> companies = new ArrayList<>();
            while (rs.next()) {
                Company company = new Company(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("cost")
                );

                companies.add(company);
            }

            return companies;
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

