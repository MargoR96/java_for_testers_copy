package ru.stqa.pft.sandbox;

import java.awt.*;

public class Homework {
    public static void main(String[] args) {
        Point p1 = new Point(1, 2);
        Point p2 = new Point(5, 9);
        System.out.println("Расстояние между точками =" + p2.distance(p1));
    }

    public static double distance(Point p1, Point p2) {
        return Math.sqrt(((p2.x - p1.x) * (p2.x - p1.x)) + ((p2.y - p1.y) * (p2.y - p1.y)));
    }
}

