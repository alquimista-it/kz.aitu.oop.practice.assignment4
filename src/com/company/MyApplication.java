package com.company;

import com.company.controllers.*;
import com.company.repositories.interfaces.*;
import java.util.Scanner;


public class MyApplication {
    private final NecklaceController controller1;
    private final StoneController controller2;
    private final LinkerController controller3;
    private final Scanner scanner;

    public MyApplication(INecklaceRepo orderRepo, IStoneRepo medicamentRepo, ILinkerRepo bindRepo) {
        controller1 = new NecklaceController(orderRepo,medicamentRepo);
        controller2 = new StoneController(medicamentRepo);
        controller3 = new LinkerController(bindRepo);
        scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            System.out.println(); //console interface
            System.out.println("Welcome to Necklace Stones management System");
            System.out.println("Select option:");
            System.out.println("1. Get all necklaces");
            System.out.println("2. Get necklaces by id");
            System.out.println("3. Create necklaces");
            System.out.println("4. Get all stone");
            System.out.println("5. Get stone by id");
            System.out.println("6. Create stone");
            System.out.println("7. Enter stone to necklace");
            System.out.println("8. Select all stones of selected necklace");
            System.out.println("9. Update necklaces by id");
            System.out.println("0. Exit");
            System.out.println();
            try { //function
                System.out.print("Enter option (1-8): ");
                int option = scanner.nextInt();
                if (option == 1) {
                    getAllNeclaces();
                } else if (option == 2) {
                    getNeclace();
                } else if (option == 3) {
                    createNeclace();
                }else if (option == 4) {
                    getAllStones();
                }else if (option == 5) {
                    getStone();
                }else if (option == 6) {
                    createStone();
                }else if (option == 7) {
                    enterStoneToNecklace();
                }else if (option == 8) {
                    getStonesByNeclace();
                }else if (option == 9) {
                    UpdateNeclaceById();
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
    //describing functions
    private void UpdateNeclaceById() {
        System.out.println("Please, enter Necklace id which you want update!");
        Integer id = scanner.nextInt();
        String response = controller1.UpdateNeclaceById(id);
        System.out.println(response);
    }

    public void enterStoneToNecklace(){
        System.out.println("Please enter necklace_id!");
        int id1 = scanner.nextInt();
        System.out.println("Please enter stone_id!");
        int id2 = scanner.nextInt();
        String response = controller3.enterStoneToNecklace(id1,id2);
        System.out.println(response);
    }


    public void getAllNeclaces() {
        String response = controller1.getAllNeclaces();
        System.out.println(response);
    }

    public void getNeclace() {
        System.out.println("Now you should enter needing necklace's id.");
        int id = scanner.nextInt();
        String response = controller1.getNeclace(id);
        System.out.println(response);
    }

    public void getStonesByNeclace() {
        System.out.println("Please, enter id of needing necklace's stones!");
        int id = scanner.nextInt();
        String response = controller1.getStonesByNeclace(id);
        System.out.println(response);
    }

    public void createNeclace() {
        System.out.println("Please, enter perfect necklace name!");
        String name = scanner.next();
        int cost=0;
        int weight=0;
        String response = controller1.createNeclace(name,weight,cost);
        System.out.println(response);
    }


    public void getAllStones() {
        String response = controller2.getAllStones();
        System.out.println(response);
    }

    public void getStone() {
        System.out.println("Now you should enter needing stone's id.");
        int id = scanner.nextInt();
        String response = controller2.getStone(id);
        System.out.println(response);
    }

    public void createStone() {
        System.out.println("Please, enter stone name!");
        String name = scanner.next();
        System.out.println("Please, enter stone weight!");
        double weight = scanner.nextDouble();
        System.out.println("Please, enter stone cost!");
        int cost = scanner.nextInt();

        String response = controller2.createStone(name,weight,cost);
        System.out.println(response);
    }

}