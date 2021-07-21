package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

public class ContactHelper extends HelperBase {

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void submitData() {
    click(By.name("submit"));
  }

  public void deleteSelectedContacts() {
    click(By.xpath("//input[@value='Delete']"));
  }

  public void selectContact() {
    click(By.id("7"));
  }
  public void submitData2() {

    click(By.xpath("//div[@id='content']/form/input[21]"));

    ;
  }


  public void returmToContactPage() {
    click(By.linkText("add next"));

  }

  public void fillContactData(ContactData contactData) {
    type(By.name("lastname"),contactData.getLastName());
    type(By.name("home"),contactData.getHome());
    type(By.name("email"),contactData.getMail());
    type(By.name("notes"),contactData.getNotes());
  }


  public void initModificationContact() {
    click(By.xpath("//img[@alt='Edit']"));
  }

  public void submitModificationContact() {
    click(By.name("update"));
  }

  public void submitDeletionContact() {
    wd.switchTo().alert().accept();
  }
}
