package com.company;

import com.company.data.PostgresDB;
import com.company.data.interfaces.IDB;
import com.company.repositories.*;
import com.company.repositories.interfaces.*;

public class Main {

    public static void main(String[] args) {
        IDB db = new PostgresDB(); //connection with db
        //create connection
        INecklaceRepo repo = new NecklaceRepo(db);
        IStoneRepo repo1 = new StoneRepo(db);
        ILinkerRepo repo2=new LinkerRepo(db);
        //create application
        MyApplication app = new MyApplication(repo,repo1,repo2);
        app.start();
    }
}