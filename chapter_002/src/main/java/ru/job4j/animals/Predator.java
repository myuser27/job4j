package ru.job4j.animals;

public class Predator extends Animal {
    public Predator(String name) {
        super(name);
        System.out.println("Load Predator");
    }

    public static void main(String[] args) {
        Predator pr = new Predator("Animal");
    }
}
