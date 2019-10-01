package ru.job4j.calculator;

/**
 * Calculator - класс для элементарных арифмитических вычислений.
 *
 * @author Aleksei Artiukhov.
 */

public class Calculator {
    /**
     * add - сложение двух чисел.
     *
     * @param first  - первое число.
     * @param second - второе число.
     */
    public static void add(double first, double second) {
        double result = first + second;
        System.out.println(first + "+" + second + " = " + result);
    }

    /**
     * div - деление двух чисел.
     *
     * @param first  - делимое.
     * @param second - делитель.
     */
    public static void div(double first, double second) {
        double result = first / second;
        System.out.println(first + "/" + second + " = " + result);
    }

    /**
     * multiply - умножение двух чисел.
     *
     * @param first  - первое число.
     * @param second - второе число.
     */
    public static void multiply(double first, double second) {
        double result = first * second;
        System.out.println(first + "*" + second + " = " + result);
    }

    /**
     * subtrack - вычитание второго числа из первого.
     *
     * @param first  - уменьшаемое.
     * @param second - вычитаемое.
     */
    public static void subtrack(double first, double second) {
        double result = first - second;
        System.out.println(first + "-" + second + " = " + result);
    }

    /**
     * Метод main.
     *
     * @param args args.
     */

    public static void main(String[] args) {
        add(1, 1);
        div(4, 2);
        multiply(2, 1);
        subtrack(10, 5);
    }
}