package com.company;

import com.company.controllers.LocomotiveController;
import com.company.controllers.TrainController;
import com.company.controllers.UserController;
import com.company.repositories.interfaces.ILokoRepo;
import com.company.repositories.interfaces.ITrainRepo;
import com.company.repositories.interfaces.IUserRepository;

import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class MyApplication {
    private final LocomotiveController controller1;
    private final TrainController controller2;
    private final Scanner scanner;

    public MyApplication(ILokoRepo lokoRepo, ITrainRepo trainRepo) {
        controller1 = new LocomotiveController(lokoRepo,trainRepo);
        controller2 = new TrainController(trainRepo);
        scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            System.out.println();
            System.out.println("Welcome to My Application");
            System.out.println("Select option:");
            System.out.println("1. Get all locomotives");
            System.out.println("2. Get locomotive by id");
            System.out.println("3. Create locomotive");
            System.out.println("4. Get all train id");
            System.out.println("5. Get train id");
            System.out.println("6. Create train");
            System.out.println("7. Select all trains of locomotive");
            System.out.println("0. Exit");
            System.out.println();
            try {
                System.out.print("Enter option (1-7): ");
                int option = scanner.nextInt();
                if (option == 1) {
                    getAllLocomotivesMenu();
                } else if (option == 2) {
                    getLocomotiveByIdMenu();
                } else if (option == 3) {
                    createLocomotiveMenu();
                }else if (option == 4) {
                    getAllTrainsMenu();
                }else if (option == 5) {
                    getTrainByIdMenu();
                }else if (option == 6) {
                    createTrainMenu();
                }
                else if (option == 7) {
                    getAllTrainsOfLocomotiveMenu();
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

    public void getAllLocomotivesMenu() {
        String response = controller1.getAllLocomotive();
        System.out.println(response);
    }

    public void getLocomotiveByIdMenu() {
        System.out.println("Please enter id");

        int id = scanner.nextInt();
        String response = controller1.getLocomotive(id);
        System.out.println(response);
    }

    public void getAllTrainsOfLocomotiveMenu() {
        System.out.println("Please enter id of needing locomotive");

        int id = scanner.nextInt();
        String response = controller1.getTrainbyLocomotive(id);
        System.out.println(response);
    }

    public void createLocomotiveMenu() {

        System.out.println("Please enter locomotive name");
        String name = scanner.next();
        System.out.println("Please enter train id");
        String trainid = scanner.next();
        int train_id=Integer.parseInt(trainid);

        String response = controller1.createLocomotive(name, train_id);
        System.out.println(response);
    }


    public void getAllTrainsMenu() {
        String response = controller2.getAllTrains();
        System.out.println(response);
    }

    public void getTrainByIdMenu() {
        System.out.println("Please enter id");

        int id = scanner.nextInt();
        String response = controller2.getTrain(id);
        System.out.println(response);
    }

    public void createTrainMenu() {

        System.out.println("Please enter train name");
        String name = scanner.next();
        System.out.println("Please enter train capacity");
        String capacity1 = scanner.next();
        int capacity=Integer.parseInt(capacity1);

        String response = controller2.createTrain(name, capacity);
        System.out.println(response);
    }


}