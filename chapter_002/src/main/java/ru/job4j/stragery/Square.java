package ru.job4j.stragery;

public class Square implements Shape {
    @Override
    public String draw() {
        StringBuilder sq = new StringBuilder();
        sq.append("++++\n");
        sq.append("+  +\n");
        sq.append("+  +\n");
        sq.append("++++\n");
        return sq.toString();
    }
}
