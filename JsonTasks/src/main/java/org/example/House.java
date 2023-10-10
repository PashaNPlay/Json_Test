package org.example;

import java.util.ArrayList;
import java.util.List;

public class House {
    public List<Animal> animals = new ArrayList<>();

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        animals.forEach(animal -> stringBuilder.append(animal.toString()).append("\n"));
        return stringBuilder.toString();
    }
}
