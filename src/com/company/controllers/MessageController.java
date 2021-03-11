package com.company.controllers;

import com.company.repositories.interfaces.IStudentRepo;

public class MessageController {
    private final IStudentRepo repo;

    public MessageController(IStudentRepo repo) {
        this.repo = repo;
    }
    public String WriteMessage(String direction, String teacher_login, String student_login, String message)

}
