package ru.stqa.pft.tests;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.lanwen.verbalregex.VerbalExpression;
import ru.stqa.pft.appManager.ApplicationManager;
import ru.stqa.pft.appManager.HelperBase;
import ru.stqa.pft.appManager.HttpSession;
import ru.stqa.pft.model.MailMessage;

import java.io.IOException;
import java.util.List;

import static org.testng.Assert.assertTrue;
import static ru.stqa.pft.tests.TestBase.app;

public class ChangePassword extends HelperBase {

  public ChangePassword(ApplicationManager app) {
    super(app);
  }

  @BeforeMethod
  public void startMailStartMailServer(){
    app.mail().start();
  }
  @Test
  public void testChangePassword () throws IOException {
    HttpSession session = app.newHttpSessions();
    assertTrue(session.login("administrator","root"));
    assertTrue(session.isLoggedinAs("administrator"));
    goToPageUsers();
  }

  private void goToPageUsers() throws IOException {
    wd.get("http://localhost/mantisbt-2.25.2/manage_overview_page.php");
    wd.get("http://localhost/mantisbt-2.25.2/manage_user_page.php");
    click(By.cssSelector("input[value='Сбросить пароль']"));
    String user = String.format(String.valueOf(By.name("username")));
    String email = String.format(String.valueOf(By.name("email")));
    String password = "password";
    app.registration().start(user, email);
    List<MailMessage> mailMessages = app.mail().waitForMail(2, 10000);
    String confirmationLink = findConfirmationLink(mailMessages, email);
    app.registration().finish(confirmationLink,password);
    assertTrue (app.newHttpSessions().login(user,password));
  }

  private String findConfirmationLink(List<MailMessage> mailMessages, String email) {
    MailMessage mailMessage = mailMessages.stream().filter((m) -> m.to.equals(email)).findFirst().get();
    VerbalExpression regex = VerbalExpression.regex().find("http://").nonSpace().oneOrMore().build();
    return regex.getText(mailMessage.text);
  }

  @AfterMethod(alwaysRun = true)
  public void stopMailStartMailServer(){
    app.mail().stop();
  }
}
