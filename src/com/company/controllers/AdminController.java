package com.company.controllers;

import com.company.entities.Admin;
import com.company.repositories.interfaces.IAdminRepo;
import com.company.repositories.interfaces.ILoginandpwd;

import java.util.List;

public class AdminController {
    private final IAdminRepo repo;
    private final ILoginandpwd repo1;
    private final ILoginandpwd repo2;

    public AdminController(IAdminRepo repo, ILoginandpwd repo1, ILoginandpwd repo2) {
        this.repo = repo;
        this.repo1 = repo1;
        this.repo2 = repo2;
    }
    public String CreateAdmin(String login, String fname, String lname, int phone, String email){
        Admin admin=new Admin(login,fname,lname,phone,email);
        boolean created=repo.CreateAdmin(admin);
        return (created ? "Admin created" : "Fail");
    }
    public String DeleteAdminByLogin(String login){
        boolean deleted=repo.DeleteAdminByLogin(login);
        return (deleted ? "Admin deleted" : "Fail");
    }
    public String UpdateAdminByLogin(String login,String fname,String lname,int phone,String email){
        boolean updated=repo.UpdateAdminByLogin(login,fname,lname,phone,email);
        return (updated ? "Admin updated" : "Fail");
    }
    public String GetAllAdmins(){
        List<Admin> adminList=repo.GetAllAdmins();
        return  adminList.toString();
    }
    public String GetAdminByLogin(String login){
        Admin admin=repo.GetAdminById(login);
        return (admin == null ? "Not founded" : admin.toString());
    }

}
