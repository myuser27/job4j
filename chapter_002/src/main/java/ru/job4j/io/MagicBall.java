package ru.job4j.io;

import java.util.Scanner;
import java.util.Random;

public class MagicBall {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Задайте Ваш вопрос: ");
        String question = input.nextLine();
        System.out.println();
        Random rnd = new Random();
        int answer = rnd.nextInt(3);
        switch (answer) {
            case 0:
                System.out.println("Да.");
                break;
            case 1:
                System.out.println("Нет.");
                break;
            default:
                System.out.println("Может быть.");
                break;
        }
    }
}
