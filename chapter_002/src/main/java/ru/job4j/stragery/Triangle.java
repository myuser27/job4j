package ru.job4j.stragery;

public class Triangle implements Shape {
    @Override
    public String draw() {
        StringBuilder tri = new StringBuilder();
        tri.append("   +\n");
        tri.append("  + +\n");
        tri.append(" +   +\n");
        tri.append("+++++++\n");
        return tri.toString();
    }
}
