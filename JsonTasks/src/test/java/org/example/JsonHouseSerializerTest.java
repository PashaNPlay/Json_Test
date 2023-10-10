package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import static org.junit.Assert.*;
import org.junit.Test;

public class JsonHouseSerializerTest {
    @Test
    public void testSerializationDeserialization() {
        Cat cat = new Cat();
        cat.name = "Murka";
        cat.age = 2;

        Dog dog = new Dog();
        dog.name = "Tob";
        dog.age = 4;
        dog.owner = "Micael";

        House house = new House();
        house.animals.add(cat);
        house.animals.add(dog);

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            String jsonString = objectMapper.writeValueAsString(house);
            House deserializedHouse = objectMapper.readValue(jsonString, House.class);
            assertEquals(house.toString(), deserializedHouse.toString());
        } catch (JsonProcessingException e) {
            System.err.println("Json processing exception: \n" + e);
        }
    }
}