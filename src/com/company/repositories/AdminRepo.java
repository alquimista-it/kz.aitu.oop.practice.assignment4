package com.company.repositories;

import com.company.data.interfaces.IDB;
import com.company.repositories.interfaces.IAdminRepo;

public class AdminRepo implements IAdminRepo {
    private final IDB db;
    public AdminRepo(IDB db){this.db = db;};
}
