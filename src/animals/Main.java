package animals;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        List<Animal> animals = new ArrayList<>();
        File example = new File("src\\animals\\example.txt");
        try (BufferedReader bf = new BufferedReader(new FileReader(example))){
            String line = bf.readLine();
            while (!line.equals("Beast!")) {

                String animalType = line;
                String[] tokens = bf.readLine().split(" ");


                Animal animal = createAnimal(animalType, tokens);
                animals.add(animal);

                line = bf.readLine();
            }
        }catch (Exception ex){
                System.out.println("Invalid input!");
            }
        for (Animal animal : animals) {
            System.out.println(animal.toString());
        }
    }

    private static Animal createAnimal(String animalType, String[] tokens) {

        String name = tokens[0];
        int age = Integer.parseInt(tokens[1]);
        String gender = "";
        if (!animalType.equals("Kitten") && !animalType.equals("Tomcat")) {
            gender = tokens[2];
        }
            switch (animalType){
                case "Cat":
                    return new Cat(name,age,gender);
                case "Dog":
                     return new Dog(name,age,gender);
                case "Frog":
                    return new Frog(name,age,gender);
                case "Kitten":
                    return  new Kitten(name,age);
                case "Tomcat":
                    return  new Tomcat(name,age);
                default:
                    throw new IllegalArgumentException("Invalid input!");
            }
    }
}
