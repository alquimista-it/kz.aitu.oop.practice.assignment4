package com.company;

import com.company.controllers.*;
import com.company.entities.Message;
import com.company.repositories.interfaces.*;
import java.util.Scanner;


public class MyApplication {
    private final AdminController controller1;
    private final MessageController controller2;
    private final Scanner scanner;

    public MyApplication(IAdminRepo adminRepo, IStudentRepo studentRepo, ILoginandpwd loginandpwd) {
        controller1 = new AdminController(adminRepo, loginandpwd,studentRepo);
        controller2 = new MessageController(studentRepo);
        scanner = new Scanner(System.in);
    }
    public void start(){
        while (true) {
            System.out.println(); //console interface
            System.out.println("Welcome to Course management system");
            System.out.println("Select option:");
            System.out.println("1. Administrator module ");
            System.out.println("2. Students module");
            System.out.println("3. Instructor module");
            System.out.println("0. Exit");
            System.out.println();
            try { //function
                System.out.print("Enter option (1-3): ");
                int option = scanner.nextInt();
                if (option == 1) {
                    adminInterface();
                } else if (option == 2) {
                    teacherInterface();
                } else if (option == 3) {
                    studentInterface();
                }else {
                    break;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                scanner.next(); // to ignore incorrect input
            }
            System.out.println("**********************************");
        }
    }

    public void adminInterface(){
        while (true) {
            System.out.println(); //console interface
            System.out.println("Welcome to Admin module");
            System.out.println("Select option:");
            System.out.println("1. Create admin ");
            System.out.println("2. DeleteAdminByLogin");
            System.out.println("3. UpdateAdminByLogin ");
            System.out.println("4. GetAllAdmins");
            System.out.println("5. GetAdminById ");
            System.out.println("6. CreateTeacher");
            System.out.println("7. DeleteTeacherByLogin ");
            System.out.println("8. UpdateTeacherByLogin");
            System.out.println("9. GetAllTeachers ");
            System.out.println("10. GetTeacherById");
            System.out.println("11. CreateStudent ");
            System.out.println("12. DeleteStudentByLogin");
            System.out.println("13. UpdateStudentByLogin ");
            System.out.println("14. GetAllStudents");
            System.out.println("15. GetStudentById");
            System.out.println("16. CreateSubject ");
            System.out.println("17. DeleteSubjectById");
            System.out.println("18. UpdateSubjectById");
            System.out.println("19. GetAllSubjects");
            System.out.println("20. GetSubjectById");
            System.out.println("21. AddTeacherToSubject");
            System.out.println("22. GetAllTeachersBySubjectId");
            System.out.println("23. CreateLoginAndPwd ");
            System.out.println("24. UpdateLoginAndPwd");
            System.out.println("0. •Exit");
            System.out.println();
            try { //function
                System.out.print("Enter option (1-3): ");
                int option = scanner.nextInt();
                if (option == 1) {
                   CreateAdmin();
                } else if (option == 2) {
                    DeleteAdminByLogin();
                } else if (option == 3) {
                    UpdateAdminByLogin();
                }else if (option == 4) {
                   GetAllAdmins();
                }else if (option == 5) {
                    GetAdminByLogin();
                }else if (option == 6) {
                    studentInterface();
                }else if (option == 8) {
                    studentInterface();
                }else if (option == 9) {
                    studentInterface();
                }else if (option == 10) {
                    studentInterface();
                }else if (option == 11) {
                    studentInterface();
                }else if (option == 12) {
                    studentInterface();
                }else if (option == 13) {
                    studentInterface();
                }else if (option == 14) {
                    studentInterface();
                }else if (option == 15) {
                    studentInterface();
                }else if (option == 16) {
                    studentInterface();
                }else if (option == 17) {
                    studentInterface();
                }else if (option == 18) {
                    studentInterface();
                }else if (option == 19) {
                    studentInterface();
                }else if (option == 20) {
                    studentInterface();
                }else if (option == 21) {
                    studentInterface();
                }else if (option == 22) {
                    studentInterface();
                }else if (option == 23) {
                    studentInterface();
                }else if (option == 24) {
                    studentInterface();
                }else if (option == 0) {
                    start();
                }else {
                    break;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                scanner.next(); // to ignore incorrect input
            }
            System.out.println("**********************************");
        }
    }
    public void teacherInterface(){
        while (true) {
            System.out.println(); //console interface
            System.out.println("Welcome to Course management system");
            System.out.println("Select option:");
            System.out.println("1. Administrator module ");
            System.out.println("2. •\tStudents module");
            System.out.println("3. •\tInstructor module");
            System.out.println();
            try { //function
                System.out.print("Enter option (1-3): ");
                int option = scanner.nextInt();
                if (option == 1) {
                    adminInterface();
                } else if (option == 2) {
                    teacherInterface();
                } else if (option == 3) {
                    studentInterface();
                }else {
                    break;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                scanner.next(); // to ignore incorrect input
            }
            System.out.println("**********************************");
        }
    }
    public void studentInterface(){
        while (true) {
            System.out.println(); //console interface
            System.out.println("Welcome to Course management system");
            System.out.println("Select option:");
            System.out.println("1. Administrator module ");
            System.out.println("2. Students module");
            System.out.println("3. Instructor module");
            System.out.println();
            try { //function
                System.out.print("Enter option (1-3): ");
                int option = scanner.nextInt();
                if (option == 1) {
                    adminInterface();
                } else if (option == 2) {
                    teacherInterface();
                } else if (option == 3) {
                    studentInterface();
                }else {
                    break;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                scanner.next(); // to ignore incorrect input
            }
            System.out.println("**********************************");
        }
    }






   // ---------------------------------------
    //s admin
    public void CreateAdmin() {
        System.out.println("Please, enter login!");
        String login = scanner.next();
        System.out.println("Please, enter first name!");
        String fname = scanner.next();
        System.out.println("Please, enter last name!");
        String lname = scanner.next();
        System.out.println("Please, enter phone number!");
        int phone = scanner.nextInt();
        System.out.println("Please, enter email address!");
        String email = scanner.next();
        String response = controller1.CreateAdmin(login,fname,lname,phone,email);
        System.out.println(response);
    }
    public void DeleteAdminByLogin() {
        System.out.println("Please, enter login of admin!");
        String login = scanner.next();
        String response = controller1.DeleteAdminByLogin(login);
        System.out.println(response);
    }
    public void UpdateAdminByLogin() {
        System.out.println("Please, enter login!");
        String login = scanner.next();
        System.out.println("Please, enter first name!");
        String fname = scanner.next();
        System.out.println("Please, enter last name!");
        String lname = scanner.next();
        System.out.println("Please, enter phone number!");
        int phone = scanner.nextInt();
        System.out.println("Please, enter email address!");
        String email = scanner.next();
        String response = controller1.UpdateAdminByLogin(login,fname,lname,phone,email);
        System.out.println(response);
    }
    public void GetAllAdmins(){
        String response = controller1.GetAllAdmins();
        System.out.println(response);
    }
    public void GetAdminByLogin(){
        System.out.println("Please, enter id of admin!");
        String login= scanner.next();
        String response = controller1.GetAdminByLogin(login);
        System.out.println(response);
    }
    //f admin

    //s teacher
    public void CreateTeacher() {
        System.out.println("Please, enter login!");
        String login = scanner.next();
        System.out.println("Please, enter first name!");
        String fname = scanner.next();
        System.out.println("Please, enter last name!");
        String lname = scanner.next();
        System.out.println("Please, enter your age!");
        int age = scanner.nextInt();
        System.out.println("Please, enter your gender!");
        boolean gender = scanner.nextBoolean();
        System.out.println("Please, enter phone number!");
        int phone = scanner.nextInt();
        System.out.println("Please, enter email address!");
        String email = scanner.next();
        System.out.println("Please, enter ID of subject!");
        int subjectId = scanner.nextInt();
        String response = controller1.CreateTeacher(login,fname,lname,age,gender,phone,email,subjectId);
        System.out.println(response);
    }
    public void DeleteTeacherByLogin() {
        System.out.println("Please, enter login of teacher!");
        String login = scanner.next();
        String response = controller1.DeleteTeacherByLogin(login);
        System.out.println(response);
    }
    public void UpdateTeacherByLogin() {
        System.out.println("Please, enter login!");
        String login = scanner.next();
        System.out.println("Please, enter first name!");
        String fname = scanner.next();
        System.out.println("Please, enter last name!");
        String lname = scanner.next();
        System.out.println("Please, enter your age!");
        int age = scanner.nextInt();
        System.out.println("Please, enter your gender!");
        boolean gender = scanner.nextBoolean();
        System.out.println("Please, enter phone number!");
        int phone = scanner.nextInt();
        System.out.println("Please, enter email address!");
        String email = scanner.next();
        System.out.println("Please, enter ID of subject!");
        int subjectId = scanner.nextInt();
        String response = controller1.UpdateTeacherByLogin(login,fname,lname,age,gender,phone,email,subjectId);
        System.out.println(response);
    }
    public void GetAllTeachers(){
        String response = controller1.GetAllTeachers();
        System.out.println(response);
    }
    public void GetTeacherByLogin(){
        System.out.println("Please, enter ID of teacher!");
        String login= scanner.next();
        String response = controller1.GetTeacherByLogin(login);
        System.out.println(response);
    }
    //f teacher

    //s student
    public void CreateStudent() {
        System.out.println("Please, enter login!");
        String login = scanner.next();
        System.out.println("Please, enter first name!");
        String fname = scanner.next();
        System.out.println("Please, enter last name!");
        String lname = scanner.next();
        System.out.println("Please, enter your age!");
        int age = scanner.nextInt();
        System.out.println("Please, enter your gender!");
        boolean gender = scanner.nextBoolean();
        System.out.println("Please, enter phone number!");
        int phone = scanner.nextInt();
        System.out.println("Please, enter email address!");
        String email = scanner.next();
        String response = controller1.CreateStudent(login,fname,lname,age,gender,phone,email);
        System.out.println(response);
    }
    public void DeleteStudentByLogin() {
        System.out.println("Please, enter login of teacher!");
        String login = scanner.next();
        String response = controller1.DeleteStudentByLogin(login);
        System.out.println(response);
    }
    public void UpdateStudentByLogin() {
        System.out.println("Please, enter login!");
        String login = scanner.next();
        System.out.println("Please, enter first name!");
        String fname = scanner.next();
        System.out.println("Please, enter last name!");
        String lname = scanner.next();
        System.out.println("Please, enter your age!");
        int age = scanner.nextInt();
        System.out.println("Please, enter your gender!");
        boolean gender = scanner.nextBoolean();
        System.out.println("Please, enter phone number!");
        int phone = scanner.nextInt();
        System.out.println("Please, enter email address!");
        String email = scanner.next();
        String response = controller1.UpdateStudentByLogin(login,fname,lname,age,gender,phone,email);
        System.out.println(response);
    }
    public void GetAllStudents(){
        String response = controller1.GetAllStudents();
        System.out.println(response);
    }
    public void GetStudentByLogin(){
        System.out.println("Please, enter ID of teacher!");
        String login= scanner.next();
        String response = controller1.GetStudentByLogin(login);
        System.out.println(response);
    }
    //f student

    //s subject
    public void CreateSubject() {
        System.out.println("Please, enter name of a subject!");
        String name = scanner.next();

        String response = controller1.CreateSubject(name);
        System.out.println(response);
    }
    public void DeleteSubjectById() {
        System.out.println("Please, enter id of subject!");
        int id = scanner.nextInt();
        String response = controller1.DeleteSubjectById(id);
        System.out.println(response);
    }
    public void UpdateSubjectById() {
        System.out.println("Please, enter id of a subject!");
        int id = scanner.nextInt();
        System.out.println("Please, enter name of a subject!");
        String name = scanner.next();
        String response = controller1.UpdateSubjectById(id, name);
        System.out.println(response);
    }
    public void GetAllSubjects(){
        String response = controller1.GetAllSubjects();
        System.out.println(response);
    }
    public void GetSubjectsById(){
        System.out.println("Please, enter ID of teacher!");
        int id= scanner.nextInt();
        String response = controller1.GetSubjectById(id);
        System.out.println(response);
    }
    //f subject
    public void AddTeacherToSubject(){
        System.out.println("Please, enter teacher_id!");
        int teacher_id = scanner.nextInt();
        System.out.println("Please, enter Subject_id");
        int subject_id = scanner.nextInt();
        String response = controller1.AddTeacherToSubject(teacher_id,subject_id);
        System.out.println(response);
    }
    public void GetAllTeachersBySubjectId(){
        System.out.println("Please, enter subject id for showing all teachers with this subject");
        int id= scanner.nextInt();
        String response = controller1.GetAllTeachersBySubjectId(id);
        System.out.println(response);
    }


    public void CreateLoginAndPwd(){
        System.out.println("Please, enter login");
        String login= scanner.next();
        System.out.println("Please, enter pwd");
        String pwd = scanner.next();
        System.out.println("Please, enter type of user. Enter 1-3. 1-admin,2-teacher,3-student");
        int usertype= scanner.nextInt();
        String response = controller1.CreateLoginAndPwd(login,pwd,usertype);
        System.out.println(response);
    }
    public void UpdateLoginAndPwd(){
        System.out.println("Please, id which you want update");
        int id = scanner.nextInt();
        System.out.println("Please, enter login user!");
        String login = scanner.next();
        System.out.println("Please, enter pwd user!");
        String pwd = scanner.next();
        System.out.println("Please, enter type of user. Enter 1-3. 1-admin,2-teacher,3-student");
        int usertype = scanner.nextInt();
        String response = controller1.UpdateLoginAndPwd(id,login,pwd,usertype);
        System.out.println(response);
    }
    public void JoinToNewTeacher(){
        System.out.println("Please, enter teacher_id ");
        int teacher_id= scanner.nextInt();
        System.out.println("Please, enter student_id which was entered to teacher");
        int student_id = scanner.nextInt();
        String response = controller1.JoinToNewTeacher(teacher_id,student_id);
        System.out.println(response);
    }
    public void ExitFromTeacher(){
        System.out.println("Please, enter teacher_id");
        int teacher_id= scanner.nextInt();
        System.out.println("Please, enter student_id which you wand delete");
        int student_id = scanner.nextInt();
        String response = controller1.ExitFromTeacher(teacher_id,student_id);
        System.out.println(response);
    }
    //message
    public void WriteMessage(){
        System.out.println("Please, enter teacher_id");
        boolean direction= scanner.nextBoolean();
        System.out.println("Please, enter student_id which you wand delete");
        String teacher_login= scanner.next();
        System.out.println("Please, enter teacher_id");
        String student_login= scanner.next();
        System.out.println("Please, enter student_id which you wand delete");
        String message = scanner.next();
        String response = controller2.WriteMessage(direction,teacher_login,student_login,message);
        System.out.println(response);
    }
    public void ShowAllTeacherMessages(){
        System.out.println("Please, enter teacher_id");
        String student_login= scanner.next();
        String response = controller2.ShowAllTeacherMessages(student_login);
        System.out.println(response);
    }
    public void ShowAllStudentMessages(){
        System.out.println("Please, enter teacher_id");
        String teacher_login= scanner.next();
        String response = controller2.ShowAllStudentMessages(teacher_login);
        System.out.println(response);
    }
    public void ShowMessagesStudentWithTeacher(){
        System.out.println("Please, enter teacher_id");
        String teacher_login= scanner.next();
        System.out.println("Please, enter teacher_id");
        String student_login= scanner.next();
        String response = controller2.ShowMessagesStudentWithTeacher(student_login,teacher_login);
        System.out.println(response);
    }
    public void ShowMessagesTeacherWithStudent(){
        System.out.println("Please, enter teacher_id");
        String teacher_login= scanner.next();
        System.out.println("Please, enter teacher_id");
        String student_login= scanner.next();
        String response = controller2.ShowMessagesTeacherWithStudent(student_login,teacher_login);
        System.out.println(response);
    }
}