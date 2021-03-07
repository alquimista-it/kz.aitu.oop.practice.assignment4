package com.company.controllers;

import com.company.entities.Linker;

import com.company.repositories.interfaces.ILinkerRepo;


public class LinkerController {
    private final ILinkerRepo repo;

    public LinkerController(ILinkerRepo repo) {
        this.repo = repo;
    }
    public String enterStoneToNecklace(int order_id,int med_id) {
        Linker linker = new Linker( order_id, med_id);
        boolean created = repo.createLinker(linker); //do function
        return (created ? "Perfect stone was entered into necklace!" : "Not entered!");
    }
}
