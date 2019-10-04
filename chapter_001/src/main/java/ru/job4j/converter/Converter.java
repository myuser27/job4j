package ru.job4j.converter;

public class Converter {
    public static int rubleToEuro(int value) {
        return value / 70;
    }
    public static int rubleToDollar(int value) {
        return value / 60;
    }
    public static int euroToRuble(int value) {
        return value * 70;
    }
    public static int dollarToRuble(int value) {
        return value * 60;
    }

    public static void main(String[] args) {
        int euro = rubleToEuro(140);
        int dollar = rubleToDollar(180);
        int rub1 = euroToRuble(40);
        int rub2 = dollarToRuble(40);
        System.out.println("140 rubles are " + euro + " euro.");
        System.out.println("180 rubles are " + dollar + " dollars.");
        System.out.println("40 euro are " + rub1 + " rubles.");
        System.out.println("40 dollars are " + rub2 + " rubles.");
        int in = 140;
        int expected = 2;
        int out = rubleToEuro(in);
        boolean passed = expected == out;
        System.out.println("140 rubles are " + expected + ". Test result : " + passed);
        in = 180;
        expected = 3;
        out = rubleToDollar(in);
        passed = expected == out;
        System.out.println("180 rubles are " + expected + ". Test result : " + passed);
        in = 40;
        expected = 2800;
        out = euroToRuble(in);
        passed = expected == out;
        System.out.println("40 euro are  " + expected + ". Test result : " + passed);
        in = 40;
        expected = 2400;
        out = dollarToRuble(in);
        passed = expected == out;
        System.out.println("40 dollars are  " + expected + ". Test result : " + passed);
    }
}
