package ru.stqa.pft.appManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationHelper extends HelperBase {

  public RegistrationHelper(ApplicationManager app) {
    super(app);
  }

  public void start(String username, String email) {
    wd.get("http://localhost/mantisbt-2.25.2/signup_page.php");
    type(By.name("username"),username);
    wd.findElement(By.name("email")).sendKeys(email);
    click(By.cssSelector("input[class='Зарегистрироваться']"));
  }

  public void finish(String confirmationLink, String password) {
    wd.get(confirmationLink);
    type(By.name("password"),password);
    type(By.name("password_confirm"),password);
    click(By.cssSelector("input[value='Update_User']"));
  }
}
