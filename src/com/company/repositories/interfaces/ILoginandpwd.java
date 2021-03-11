package com.company.repositories.interfaces;

import com.company.entities.Admin;
import com.company.entities.Loginandpwd;
import com.company.entities.Student;
import com.company.entities.Teacher;

public interface ILoginandpwd {
    boolean CreateLoginAndPwd(Loginandpwd loginandpwd);
    boolean CheckPwd(int id); //check pwd буду ее призывать при проверке паролей
    boolean UpdateLoginAndPwd(int id,String pwd,String login);

}
