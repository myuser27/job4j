package ru.job4j.condition;

import static java.lang.Math.sqrt;

public class Triangle {
    private Point a;
    private Point b;
    private Point c;

    public Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double period(double ab, double ac, double bc) {
        if (this.exist(ab, ac, bc)) {
            return (ab + ac + bc)/2;
        }
        return -1;
    }

    public double area() {
        double ab = a.distance(b);
        double ac = a.distance(c);
        double bc = b.distance(c);
        double p = period(ab, ac, bc);
        if (this.exist(ab, ac, bc)) {
            return sqrt(p*(p-ab)*(p-ac)*(p-bc));
        }
        return -1;
    }

    private boolean exist(double ab, double ac, double bc) {
        if((ab+ac) > bc && (ab+bc) > ac && (ac+bc) > ab) {
            return true;
        }
        return false;
    }
}
