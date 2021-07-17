package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SessionHelper extends HelperBase{

  private WebDriver wd;

  public SessionHelper(WebDriver wd) {
    super(wd);
  }
  public void login(String password, String username) {
    type (By.name("user"),username);
    type(By.name("pass"),password);
    click(By.id("LoginForm"));
  }
}
