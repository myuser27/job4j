package ru.job4j.io;

import java.util.Scanner;

public class Matches {
    public static void main(String[] args) {
        int count = 11;
        int player = 1;
        Scanner input = new Scanner(System.in);
        int select;
        while (count > 0) {
            System.out.print("Осталось " + count + " спичек. Игрок" + player
                    + ", сколько забираете (от 1 до 3)? ");
            select = Integer.valueOf(input.nextLine());
            count -= select;
            if (count == 0) {
                break;
            }
            if (player == 1) {
                player = 2;
            } else {
                player = 1;
            }
        }
        if (player == 1) {
            System.out.println("Победил игрок 1");
        } else {
            System.out.println("Победил игрок 2");
        }
    }
}
