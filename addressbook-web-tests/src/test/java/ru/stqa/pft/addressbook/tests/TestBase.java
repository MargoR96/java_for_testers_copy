package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import ru.stqa.pft.addressbook.appmanager.ApplicationManager;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

public class TestBase {
  Logger logger = LoggerFactory.getLogger(TestBase.class);

  protected static final ApplicationManager app = new ApplicationManager(System.getProperty("browser",BrowserType.FIREFOX));

  @BeforeSuite(alwaysRun = true)
  public void setUp() throws Exception {
    app.init();
  }


  @AfterSuite(alwaysRun = true)
  public void tearDown() throws Exception {
    app.stop();


  }


  @BeforeMethod
  public void logTestStart (Method m,Object[] p){
    logger.info("Start" + m.getName()+ Arrays.asList(p));
  }
  @AfterMethod (alwaysRun = true)
  public void logTestStop (Method m){
    logger.info("Stop" + m.getName());
  }
  public void verifyInGroupListInUI() {
    if (Boolean.getBoolean("verifyUI")){
      Groups dbGroups = app.db().groups();
      Groups UIGroups = app.group().all();
      assertThat(UIGroups, equalTo(dbGroups.stream()
              .map((g) -> new GroupData().withId(g.getId()).withName(g.getName()))
              .collect(Collectors.toSet())));
    }


  }

  public void verifyInContactListInUI() {
    if (Boolean.getBoolean("verifyUI")){
      Contacts dbContacts = app.db().contacts();
      Contacts UIContacts = app.contact().all();
      assertThat(UIContacts, equalTo(dbContacts.stream()
              .map((g) -> new ContactData().withId(g.getId()).withLastname(g.getLastName()).withFirstname(g.getFirstname()))
              .collect(Collectors.toSet())));
    }

  }

}
