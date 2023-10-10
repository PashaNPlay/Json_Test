package org.example;

public class Dog extends Animal {
    public int age;
    public String owner;

    @Override
    public String toString() {
        return "Dog{" +
                "age=" + age +
                ", owner='" + owner + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
