package com.company.repositories.interfaces;

import com.company.entities.Admin;
import com.company.entities.Loginandpwd;

public interface ILoginandpwd {
    boolean CreateLoginAndPwd(Loginandpwd loginandpwd);
    boolean CheckPwd(int id);
    Admin UpdateAdminById(int id);
}
