package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;


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
    click(By.name("selected[]"));
  }
  public void submitData2() {

    click(By.xpath("//div[@id='content']/form/input[21]"));

    ;
  }


  public void returmToContactPage() {
    click(By.linkText("add next"));

  }

  public void fillContactData(ContactData contactData,boolean creation) {
    type(By.name("lastname"),contactData.getLastName());
    type(By.name("home"),contactData.getHome());
    type(By.name("email"),contactData.getMail());
    type(By.name("notes"),contactData.getNotes());
    if (creation) {
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }
//    if(isElementPresent(By.name("new_group"))) {
//      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
//    }

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
