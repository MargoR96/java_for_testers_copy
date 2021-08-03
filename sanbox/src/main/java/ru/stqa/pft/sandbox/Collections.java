package ru.stqa.pft.sandbox;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Collections {
  public static void main (String[] args){
    String[] langs = {"java","for", "testers","!"};
    List<String> languages = new ArrayList<String>();
    List<String> languages2 = Arrays.asList("java","for", "testers","!");
    languages.add("Java");
    languages.add("C#");
    languages.add("Python");
    languages.add("JS");
    for (String l : langs){
      System.out.print(l);
    }
  }
}
