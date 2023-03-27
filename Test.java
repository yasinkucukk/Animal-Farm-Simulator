// 150120062 - Yasin Kucuk
/* This program is a simulation of an animal farm. 
The user can add, remove, search, sort, and print the animals in the farm. */

import java.util.*;

public class Test {

    public static void main(String[] args) {
        System.out.println("Welcome to the Animal Farm simulation program!");
        
        // Get the capacity of the animal farm from the user
        System.out.print("Please enter the capacity of the animal farm: ");
        Scanner input = new Scanner(System.in);
        int capacity = input.nextInt();
        
        // Create an animal farm with the given capacity
        AnimalFarm animalFarm = new AnimalFarm(capacity);
        
        // Create a menu for the user
        int choice = -1;
        while (choice != 0) {
            System.out.println("0 - Exit the program");
            System.out.println("1 - Add animal");
            System.out.println("2 - Remove animal");
            System.out.println("3 - Search animal");
            System.out.println("4 - Sort animals");
            System.out.println("5 - Calculate the next year's population estimate");
            System.out.println("6 - Print all animal's movements");
            System.out.println("7 - Print all animal's eating habits");
            System.out.println("8 - Print report");
            System.out.print("Please enter your choice: ");
            choice = input.nextInt();
            switch (choice) {
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    System.out.println("Please choose the type of the animal: ");
                    System.out.println("1 - Chicken");
                    System.out.println("2 - Donkey");
                    System.out.println("3 - Horse");
                    System.out.println("4 - Pig");
                    System.out.println("5 - Raven");
                    System.out.println("6 - Sheep");
                    System.out.print("Please enter your choice: ");
                    int animalType = input.nextInt();
                    System.out.print("Please enter the name of the animal: ");
                    String name = input.next();
                    System.out.print("Please enter the age of the animal: ");
                    int age = input.nextInt();
                    Animal animal = null;
                    switch (animalType) {
                        case 1:
                            animal = new Chicken(name, age);
                            break;
                        case 2:
                            animal = new Donkey(name, age);
                            break;
                        case 3:
                            animal = new Horse(name, age);
                            break;
                        case 4:
                            animal = new Pig(name, age);
                            break;
                        case 5:
                            animal = new Raven(name, age);
                            break;
                        case 6:
                            animal = new Sheep(name, age);
                            break;
                        default:
                            System.out.println("Invalid choice!");
                            break;
                    }

                    try {
                        animalFarm.addAnimal(animal);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 2:
                    System.out.print("Please enter the name of the animal: ");
                    name = input.next();
                    animalFarm.removeAnimal(name);
                    break;

                case 3:
                    System.out.println("1 - Search based on name");
                    System.out.println("2 - Search based on age");
                    System.out.print("Please enter your choice: ");
                    int searchType = input.nextInt();
                    switch (searchType) {
                        case 1:
                            System.out.print("Please enter the name of the animal: ");
                            name = input.next();
                            animalFarm.searchBasedOnName(name);
                            break;
                        case 2:
                            System.out.print("Please enter the age of the animal: ");
                            age = input.nextInt();
                            animalFarm.searchBasedOnAge(age);
                            break;
                        default:
                            System.out.println("Invalid choice!");
                            break;
                    }
                    break;

                case 4:
                    System.out.println("1 - Sort based on name");
                    System.out.println("2 - Sort based on leg number");
                    System.out.println("3 - Sort based on age");
                    System.out.println("4 - Sort based on addition date");
                    System.out.print("Please enter your choice: ");
                    int sortType = input.nextInt();
                    switch (sortType) {
                        case 1:
                            animalFarm.sortAlphabetically();
                            break;
                        case 2:
                            animalFarm.sortBasedOnLegNumber();
                            break;
                        case 3:
                            animalFarm.sortBasedOnAge();
                            break;
                        case 4:
                            animalFarm.printAllAnimals();
                            break;
                        default:
                            System.out.println("Invalid choice!");
                            break;
                    }
                    break;

                case 5:
                    System.out.println(animalFarm.nextYearPopulationForecast());
                    break;

                case 6:
                    animalFarm.animalMovements();
                    break;
                case 7:
                    animalFarm.eatingHabits();
                    break;

                case 8:
                    System.out.print("Please enter the name of the file: ");
                    String fileName = input.next();
                    animalFarm.printReport(fileName);
                    break;

                default:
                    System.out.println("Invalid choice!");
                    break;

            }

        }
        // Close the scanner
        input.close();
    }

}