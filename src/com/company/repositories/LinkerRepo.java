package com.company.repositories;

import com.company.data.interfaces.IDB;
import com.company.entities.Linker;
import com.company.repositories.interfaces.ILinker;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LinkerRepo implements ILinker {
    private final IDB db;
    public LinkerRepo(IDB db){this.db = db;};

    @Override
    public boolean createlinker(Linker linker) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "INSERT INTO linker(company_id,worker_id) VALUES (?,?)";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, linker.getCompany_id());
            st.setInt(2, linker.getWorker_id());



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

    //    String sql = "INSERT INTO linker(company_id,worker_id) VALUES (?,?)";
}
