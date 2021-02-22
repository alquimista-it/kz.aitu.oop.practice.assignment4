package com.company;

import com.company.controllers.*;
import com.company.repositories.LinkerRepo;
import com.company.repositories.interfaces.*;

import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class MyApplication {
    private final CompanyController controller1;
    private final WorkerCompany controller2;
    private final LinkerController controller3;
    private final Scanner scanner;

    public MyApplication(ICompanyRepo companyRepo, IWorkerRepo workerRepo,ILinker linkerRepo) {
        controller1 = new CompanyController(companyRepo,workerRepo);
        controller2 = new WorkerCompany(workerRepo);
        controller3 = new LinkerController(linkerRepo);
        scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            System.out.println();
            System.out.println("Welcome to My Application");
            System.out.println("Select option:");
            System.out.println("1. Get all projects");
            System.out.println("2. Get project by id");
            System.out.println("3. Create project");
            System.out.println("4. Get all workers");
            System.out.println("5. Get worker by id");
            System.out.println("6. Create worker");
            System.out.println("7. Include worker to project");
            System.out.println("8. Select all workers of selected projected");
            System.out.println("0. Exit");
            System.out.println();
            try {
                System.out.print("Enter option (1-8): ");
                int option = scanner.nextInt();
                if (option == 1) {
                    getAllCompanyMenu();
                } else if (option == 2) {
                    getCompanyByIdMenu();
                } else if (option == 3) {
                    createCompanyMenu();
                }else if (option == 4) {
                    getAllWorkerMenu();
                }else if (option == 5) {
                    getWorkerByIdMenu();
                }else if (option == 6) {
                    createWorkerMenu();
                }else if (option == 7) {
                    plusWorkerForCompany();
                }

                else if (option == 8) {
                    getAllWorkersOfCompanyMenu();
                }else {

                    break;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                scanner.next(); // to ignore incorrect input
            }

            System.out.println("*************************");

        }
    }
    public void plusWorkerForCompany(){
        System.out.println("Please enter company_id");

        int id1 = scanner.nextInt();
        System.out.println("Please enter worker_id");

        int id2 = scanner.nextInt();
        String response = controller3.plusWorkerToCompany(id1,id2);
        System.out.println(response);
    }


    public void getAllCompanyMenu() {
        String response = controller1.getAllCompanies();
        System.out.println(response);
    }

    public void getCompanyByIdMenu() {
        System.out.println("Please enter id");

        int id = scanner.nextInt();
        String response = controller1.getCompany(id);
        System.out.println(response);
    }

    public void getAllWorkersOfCompanyMenu() {
        System.out.println("Please enter id of needing company's workers");

        int id = scanner.nextInt();
        String response = controller1.getWorkerbyCompany(id);
        System.out.println(response);
    }

    public void createCompanyMenu() {

        System.out.println("Please enter project name");
        String name = scanner.next();
        int cost=0;
//        System.out.println("Please enter train id");
//        String trainid = scanner.next();
//        int train_id=Integer.parseInt(trainid);

        String response = controller1.createCompany(name,cost);
        System.out.println(response);
    }


    public void getAllWorkerMenu() {
        String response = controller2.getAllWorkers();
        System.out.println(response);
    }

    public void getWorkerByIdMenu() {
        System.out.println("Please enter id");

        int id = scanner.nextInt();
        String response = controller2.getWorker(id);
        System.out.println(response);
    }

    public void createWorkerMenu() {

        System.out.println("Please enter worker's fname");
        String fname = scanner.next();
        System.out.println("Please enter worker's lname");
        String lname = scanner.next();
        System.out.println("Please enter worker's speciality");
        String speciality = scanner.next();
        System.out.println("Please enter worker's salary");
        int cost = scanner.nextInt();
//        int cost1=Integer.parseInt(cost);
        System.out.println("Please enter worker's phone number");
        String phone = scanner.next();
//        int phone1=Integer.parseInt(phone);

        String response = controller2.createWorker(lname,fname,speciality,cost,phone);
        System.out.println(response);
    }


}