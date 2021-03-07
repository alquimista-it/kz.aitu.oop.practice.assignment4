package com.company.repositories;

import com.company.data.interfaces.IDB;
import com.company.entities.Linker;
import com.company.repositories.interfaces.ILinkerRepo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LinkerRepo implements ILinkerRepo {
    private final IDB db;
    public LinkerRepo(IDB db){this.db = db;};//link with database

    @Override
    public boolean createLinker(Linker linker) {
        Connection con = null;//object
        try {//checking for troubles
            con = db.getConnection();
            String sql = "INSERT INTO linker(necklace_id,stone_id) VALUES (?,?)"; //insert data to database
            PreparedStatement st = con.prepareStatement(sql);
            //input
            st.setInt(1, linker.getNecklace_id());
            st.setInt(2, linker.getStone_id());



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
