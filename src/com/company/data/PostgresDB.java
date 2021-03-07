package com.company.data;

import com.company.data.interfaces.IDB;

import java.sql.*;

public class PostgresDB implements IDB {
    @Override
    public Connection getConnection() throws SQLException, ClassNotFoundException {
        String connectionUrl = "jdbc:postgresql://localhost:5432/assigment5"; //connection with database
        try { //checking for troubles
            // Here we load the driver’s class file into memory at the runtime
            Class.forName("org.postgresql.Driver"); //driver

            // Establish the connection
            Connection con = DriverManager.getConnection(connectionUrl, "postgres", "love"); //login and password of database

            return con;
        } catch (Exception e) {
            System.out.println(e);
            throw e;
        }

    }
}