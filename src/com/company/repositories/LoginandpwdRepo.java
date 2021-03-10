package com.company.repositories;

import com.company.data.interfaces.IDB;
import com.company.entities.Admin;
import com.company.entities.Loginandpwd;
import com.company.entities.Student;
import com.company.entities.Teacher;
import com.company.repositories.interfaces.ILoginandpwd;

public class LoginandpwdRepo implements ILoginandpwd {
    private final IDB db;
    public LoginandpwdRepo(IDB db){this.db = db;};

    @Override
    public boolean CreateLoginAndPwd(Loginandpwd loginandpwd) {
        return false;
    }

    @Override
    public boolean CheckPwd(int id) {
        return false;
    }

    @Override
    public Admin UpdateAdminLoginAndPwd(int id) {
        return null;
    }

    @Override
    public Teacher UpdateTeacherLoginAndPwd(int id) {
        return null;
    }

    @Override
    public Student UpdateStudentLoginAndPwd(int id) {
        return null;
    }


}
