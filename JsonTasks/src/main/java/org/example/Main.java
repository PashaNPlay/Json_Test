package org.example;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static final Path JSON_FILE_PATH =
            Paths.get("D:\\JavaProgects\\JsonTasks\\src\\main\\resources\\JsonFile.json");

    public static void main(String[] args) {
        Cat cat = new Cat();
        cat.name = "Murka";
        cat.age = 2;

        Dog dog = new Dog();
        dog.name = "Robot";
        dog.age = 4;
        dog.owner = "William";

        House house = new House();
        house.animals.add(cat);
        house.animals.add(dog);
        System.out.println(house);

        JsonHouseSerializer serializer = new JsonHouseSerializer(JSON_FILE_PATH);
        serializer.serialize(house);
        House deserializeHouse = serializer.deserialize();
        System.out.println(deserializeHouse);
    }
}