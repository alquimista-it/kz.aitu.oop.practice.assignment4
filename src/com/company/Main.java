package com.company;

import com.company.data.PostgresDB;
import com.company.data.interfaces.IDB;
import com.company.repositories.*;
import com.company.repositories.interfaces.*;

public class Main {

    public static void main(String[] args) {
        IDB db = new PostgresDB(); //connection with db
        //create connection
        IAdminRepo repo = new AdminRepo(db);
        IStudentRepo repo1=new StudentRepo(db);
        ILoginandpwd repo2=new LoginandpwdRepo(db);
        //create application
        MyApplication app = new MyApplication(repo,repo1,repo2);
        app.start();
    }
}