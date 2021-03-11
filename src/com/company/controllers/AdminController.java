package com.company.controllers;

import com.company.entities.*;
import com.company.repositories.interfaces.IAdminRepo;
import com.company.repositories.interfaces.ILoginandpwd;
import com.company.repositories.interfaces.IStudentRepo;

import java.util.List;

public class AdminController {
    private final IAdminRepo repo;
    private final ILoginandpwd repo1;
    private final IStudentRepo repo2;

    public AdminController(IAdminRepo repo, ILoginandpwd repo1, IStudentRepo repo2) {
        this.repo = repo;
        this.repo1 = repo1;
        this.repo2 = repo2;
    }
    // start admin
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
    //end admin

    //start teacher
    public String CreateTeacher(String login, String fname, String lname, int age, boolean gender, int phone, String email, String subjectId){
        Teacher teacher=new Teacher(login,fname,lname, age, gender, phone,email, subjectId);
        boolean created=repo.CreateTeacher(teacher);
        return (created ? "Teacher created" : "Fail");
    }
    public String DeleteTeacherByLogin(String login){
        boolean deleted=repo.DeleteTeacherByLogin(login);
        return (deleted ? "Teacher deleted" : "Fail");
    }
    public String UpdateTeacherByLogin(String login,String fname,String lname, int age, boolean gender, int phone,String email, String subjectId){
        boolean updated=repo.UpdateTeacherByLogin(login,fname,lname, age, gender, phone, email, subjectId);
        return (updated ? "Teacher updated" : "Fail");
    }
    public String GetAllTeachers(){
        List<Teacher> teacherList=repo.GetAllTeachers();
        return  teacherList.toString();
    }
    public String GetTeacherByLogin(String login){
        Teacher teacher=repo.GetTeacherById(login);
        return (teacher == null ? "Not founded" : teacher.toString());
    }
    //end teacher

    //start student
    public String CreateStudent(String login, String fname, String lname, int age, boolean gender, int phone, String email){
        Student student=new Student(login,fname,lname, age, gender, phone,email);
        boolean created=repo.CreateStudent(student);
        return (created ? "Student created" : "Fail");
    }
    public String DeleteStudentByLogin(String login){
        boolean deleted=repo.DeleteStudentByLogin(login);
        return (deleted ? "Student deleted" : "Fail");
    }
    public String UpdateStudentByLogin(String login,String fname,String lname, int age, boolean gender, int phone,String email){
        boolean updated=repo.UpdateStudentByLogin(login,fname,lname, age, gender, phone, email);
        return (updated ? "Student updated" : "Fail");
    }
    public String GetAllStudents(){
        List<Student> studentList=repo.GetAllStudents();
        return  studentList.toString();
    }
    public String GetStudentByLogin(String login){
        Student student=repo.GetStudentById(login);
        return (student == null ? "Not founded" : student.toString());
    }
    //end student

    //start subject
    public String CreateSubject(String name){
        Subject subject=new Subject(name);
        boolean created=repo.CreateSubject(subject);
        return (created ? "Subject created" : "Fail");
    }
    public String DeleteSubjectById(int id){
        boolean deleted=repo.DeleteSubjectById(id);
        return (deleted ? "Subject deleted" : "Fail");
    }
    public String UpdateSubjectById(int id, String name){
        boolean updated=repo.UpdateSubjectById(id, name);
        return (updated ? "Subject updated" : "Fail");
    }
    public String GetAllSubjects(){
        List<Subject> subjectList=repo.GetAllSubjects();
        return  subjectList.toString();
    }
    public String GetSubjectById(int id){
        Subject subject=repo.GetSubjectById(id);
        return (subject == null ? "Not founded" : subject.toString());
    }
    //end subject

    public String AddTeacherToSubject(int teacherId,int subjectId){
        SubjectAndTeacher subjectAndTeacher=new SubjectAndTeacher(teacherId,subjectId);
        boolean added=repo.AddTeacherToSubject(subjectAndTeacher);
        return (added ? "Teacher added to subject group." : "Fail");
    }
    public String GetAllTeachersBySubjectId(int subject_id){
        List<Teacher> teacherList=repo.GetAllTeachersBySubjectId(subject_id);
        return (teacherList == null ? "Not founded" : teacherList.toString());
    }

    //start loginAndPwd
    public String CreateLoginAndPwd(String login,String pwd,int userType){
        Loginandpwd loginandpwd=new Loginandpwd(login,pwd,userType);
        boolean created= repo1.CreateLoginAndPwd(loginandpwd);
        return (created ? "New User created" : "Fail");
    }
    public String CheckPwd(){
        return "";
    }
    public String UpdateLoginAndPwd(int id,String login,String pwd,int userType){
        boolean updated=repo1.UpdateLoginAndPwd(id,login,pwd,userType);
        return (updated ? "Subject updated" : "Fail");
    }
    //end loginAndPwd

    //start join student and exit
//    boolean JoinToNewTeacher(TeacherAndStudents teacherAndStudents); //создаем учеников для учител
    public String JoinToNewTeacher(int teacher_id,int student_id){
        TeacherAndStudents teacherAndStudents  =new TeacherAndStudents(teacher_id,student_id);
        boolean joined= repo2.JoinToNewTeacher(teacherAndStudents);
        return (joined ? "Student was join to New Teacher" : "Fail");
    }
//    boolean ExitFromTeacher(TeacherAndStudents teacherAndStudents); //выходим из учителя тип из класса
    public String ExitFromTeacher(int teacher_id,int student_id){
        TeacherAndStudents teacherAndStudents  =new TeacherAndStudents(teacher_id,student_id);
        boolean exited= repo2.ExitFromTeacher(teacherAndStudents);
        return (exited ? "Student was deleted from this Teacher class" : "Fail");
    }
    //end join student and exit


}
