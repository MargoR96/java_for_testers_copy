package ru.stqa.pft.tests;

import org.testng.annotations.Test;

import static ru.stqa.pft.tests.TestBase.app;

public class RegistrationTest {
  @Test
  public void testRegistration (){
    app.registration().start("user","user");
  }
}
