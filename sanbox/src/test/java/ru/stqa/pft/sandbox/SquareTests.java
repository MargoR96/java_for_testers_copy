package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SquareTests {

  @Test
  public void testArea() {
    Point p1 = new Point(1,2);
    Point p2 = new Point(5,6);

    Assert.assertEquals(p2.distance(p1),5.656854249492381);


  }

}
