package com.company.controllers;

import com.company.entities.Message;
import com.company.entities.Subject;
import com.company.entities.Teacher;
import com.company.repositories.interfaces.IStudentRepo;

import java.util.List;

public class MessageController {
    private final IStudentRepo repo;

    public MessageController(IStudentRepo repo) {
        this.repo = repo;
    }
    public String WriteMessage(Boolean direction, String teacher_login, String student_login, String message){
        Message message1 =new Message(direction,teacher_login,student_login,message);
        boolean created=repo.WriteMessage(message1);
        return (created ? "Message was written" : "Fail");
    }
    public  String ShowAllTeacherMessages(String student_login){
        List<Message> messageList=repo.ShowAllTeacherMessages(student_login);
        return (messageList == null ? "Not founded" : messageList.toString());
    }
    public String ShowAllStudentMessages(String teacher_login){
        List<Message> messageList=repo.ShowAllStudentMessages(teacher_login);
        return (messageList == null ? "Not founded" : messageList.toString());
    }

    public String ShowMessagesStudentWithTeacher(String student_login, String teacher_login){
        List<Message> messageList=repo.ShowMessagesStudentWithTeacher(student_login,teacher_login);
        return (messageList == null ? "Not founded" : messageList.toString());
    }
    public String ShowMessagesTeacherWithStudent(String student_login, String teacher_login){
        List<Message> messageList=repo.ShowMessagesStudentWithTeacher(student_login,teacher_login);
        return (messageList == null ? "Not founded" : messageList.toString());
    }

}
