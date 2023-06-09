import java.io.*;
import java.util.*;

public class AnimalFarm {

    private ArrayList<Animal> animalList;
    private ArrayList<String> animalNames;
    private int CAPACITY;
    private static int numberOfAnimals = 0;

    public AnimalFarm(int capacity) {
        CAPACITY = capacity;
        animalList = new ArrayList<Animal>(CAPACITY);
        animalNames = new ArrayList<String>(CAPACITY);
    }

    public int getNumberOfAnimals() {
        return numberOfAnimals;
    }

    public int getCapacity() {
        return CAPACITY;
    }

    public boolean addAnimal(Animal animal) throws IllegalNameException {
        if (animalNames.contains(animal.getName())) {
            throw new IllegalNameException();
        }
        animalList.add(animal);
        animalNames.add(animal.getName());
        numberOfAnimals++;
        return true;
    }

    public boolean removeAnimal(String name) {

        for (int i = 0; i < animalList.size(); i++) {
            if (animalList.get(i).getName().equals(name)) {
                animalList.remove(i);
                animalNames.remove(i);
                numberOfAnimals--;
                return true;
            }
        }
        return false;

    }

    public void printAllAnimalGreetings() {
        for (Animal animal : animalList) {
            printOneAnimalGreetings(animal);
        }
    }

    public void printOneAnimalGreetings(Animal animal) {
        animal.sayGreetings();
    }

    public void printAllAnimalNames() {
        for (Animal animal : animalList) {
            printOneAnimalName(animal);
        }
    }

    public void printOneAnimalName(Animal animal) {
        System.out.println(animal.getName());
    }

    public void printAllAnimals() {
        for (Animal animal : animalList) {
            System.out.println("My name is " + animal.getName());
            System.out.println(animal.getName() + " is " + animal.getAge() + " years old.");
            System.out.println(animal.getName() + " has " + animal.getLegNumber() + " legs.");
        }
    }

    public int nextYearPopulationForecast() {

        int totalOffsprings = 0;
        for (Animal animal : animalList) {
            totalOffsprings += animal.getPregnancyPerYear() * animal.getNumberOfOffsprings();
        }
        return numberOfAnimals + totalOffsprings;
    }

    public void animalMovements() {
        for (Animal animal : animalList) {
            if (animal instanceof Bird) {
                System.out.print("My name is " + animal.getName() + " and ");
                ((Bird) animal).fly();
            } else if (animal instanceof Mammal) {
                System.out.print("My name is " + animal.getName() + " and ");
                ((Mammal) animal).walk();
            }
        }
    }

    public void eatingHabits() {
        for (Animal animal : animalList) {
            if (animal instanceof Bird) {
                System.out.print("My name is " + animal.getName() + " and ");
                ((Bird) animal).omnivore();
            } else if (animal instanceof Mammal) {
                System.out.print("My name is " + animal.getName() + " and ");
                ((Mammal) animal).herbivore();
            }
        }
    }

    public void sortAlphabetically() {
        ArrayList<Animal> sortedList = new ArrayList<Animal>(animalList);
        for (int i = 0; i < sortedList.size(); i++) {
            for (int j = i + 1; j < sortedList.size(); j++) {
                if (sortedList.get(i).getName().compareTo(sortedList.get(j).getName()) > 0) {
                    Animal temp = sortedList.get(i);
                    sortedList.set(i, sortedList.get(j));
                    sortedList.set(j, temp);
                }
            }
        }
        for (Animal animal : sortedList) {
            System.out.println("My name is " + animal.getName());
        }
    }

    public void sortBasedOnLegNumber() {
        ArrayList<Animal> sortedList = new ArrayList<Animal>(animalList);
        for (int i = 0; i < sortedList.size(); i++) {
            for (int j = i + 1; j < sortedList.size(); j++) {
                if (sortedList.get(i).getLegNumber() > sortedList.get(j).getLegNumber()) {
                    Animal temp = sortedList.get(i);
                    sortedList.set(i, sortedList.get(j));
                    sortedList.set(j, temp);
                }
            }
        }
        for (Animal animal : sortedList) {
            System.out.println(animal.getName() + " has " + animal.getLegNumber() + " legs.");
        }
    }

    public void sortBasedOnAge() {
        ArrayList<Animal> sortedList = new ArrayList<Animal>(animalList);
        for (int i = 0; i < sortedList.size(); i++) {
            for (int j = i + 1; j < sortedList.size(); j++) {
                if (sortedList.get(i).getAge() > sortedList.get(j).getAge()) {
                    Animal temp = sortedList.get(i);
                    sortedList.set(i, sortedList.get(j));
                    sortedList.set(j, temp);
                }
            }
        }
        for (Animal animal : sortedList) {
            System.out.println(animal.getName() + " is " + animal.getAge() + " years old.");
        }
    }

    public void searchBasedOnName(String name) {
        for (Animal animal : animalList) {
            if (animal.getName().equals(name)) {
                System.out.println(animal);
            }
        }
    }

    public void searchBasedOnAge(int age) {
        for (Animal animal : animalList) {
            if (animal.getAge() == age) {
                System.out.println(animal);
            }
        }
    }

    public void printReport(String fileName) {
        try {
            PrintWriter writer = new PrintWriter(fileName);
            writer.println("We have a total of " + animalList.size() + " animals in the farm.");
            int chickenCount = 0;
            int donkeyCount = 0;
            int horseCount = 0;
            int pigCount = 0;
            int ravenCount = 0;
            int sheepCount = 0;

            for (Animal animal : animalList) {
                if (animal instanceof Chicken) {
                    chickenCount++;
                } else if (animal instanceof Donkey) {
                    donkeyCount++;

                } else if (animal instanceof Horse) {
                    horseCount++;

                } else if (animal instanceof Pig) {
                    pigCount++;

                } else if (animal instanceof Raven) {
                    ravenCount++;

                } else if (animal instanceof Sheep) {
                    sheepCount++;

                }
            }
            if (chickenCount > 0) {
                writer.println("\t" + chickenCount + " of them are Chicken. Those are:");
                writer.println("\t\tName\t\tAge\t\tLeg Number");
                for (Animal animal : animalList) {
                    if (animal instanceof Chicken) {
                        writer.println(
                                "\t\t" + animal.getName() + "\t\t" + animal.getAge() + "\t\t" + animal.getLegNumber());
                    }
                }
            }
            if (donkeyCount > 0) {
                writer.println("\t" + donkeyCount + " of them are Donkey. Those are:");
                writer.println("\t\tName\t\tAge\t\tLeg Number");
                for (Animal animal : animalList) {
                    if (animal instanceof Donkey) {
                        writer.println(
                                "\t\t" + animal.getName() + "\t\t" + animal.getAge() + "\t\t" + animal.getLegNumber());
                    }
                }
            }
            if (horseCount > 0) {
                writer.println("\t" + horseCount + " of them are Horse. Those are:");
                writer.println("\t\tName\t\tAge\t\tLeg Number");
                for (Animal animal : animalList) {
                    if (animal instanceof Horse) {
                        writer.println(
                                "\t\t" + animal.getName() + "\t\t" + animal.getAge() + "\t\t" + animal.getLegNumber());
                    }
                }
            }
            if (pigCount > 0) {
                writer.println("\t" + pigCount + " of them are Pig. Those are:");
                writer.println("\t\tName\t\tAge\t\tLeg Number");
                for (Animal animal : animalList) {
                    if (animal instanceof Pig) {
                        writer.println(
                                "\t\t" + animal.getName() + "\t\t" + animal.getAge() + "\t\t" + animal.getLegNumber());
                    }
                }
            }
            if (ravenCount > 0) {
                writer.println("\t" + ravenCount + " of them are Raven. Those are:");
                writer.println("\t\tName\t\tAge\t\tLeg Number");
                for (Animal animal : animalList) {
                    if (animal instanceof Raven) {
                        writer.println(
                                "\t\t" + animal.getName() + "\t\t" + animal.getAge() + "\t\t" + animal.getLegNumber());
                    }
                }
            }
            if (sheepCount > 0) {
                writer.println("\t" + sheepCount + " of them are Sheep. Those are:");
                writer.println("\t\tName\t\tAge\t\tLeg Number");
                for (Animal animal : animalList) {
                    if (animal instanceof Sheep) {
                        writer.println(
                                "\t\t" + animal.getName() + "\t\t" + animal.getAge() + "\t\t" + animal.getLegNumber());
                    }
                }
            }
            writer.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
    }

}
