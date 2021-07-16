package ru.stqa.pft.sandbox;

public class FirstProgarm {
  public class Homework {
    public void main(String[] args) {
      hello("world");
      hello("user");

      Square s = new Square(5);
      System.out.println("Площадь равна " + s.area());

      Rectangle r = new Rectangle(4,6);
      System.out.println("Площадь прямоугольника" + r.area());
    }
    public void hello (String somebody){
      System.out.println("Hello, " + somebody);
    }

    }

    }
