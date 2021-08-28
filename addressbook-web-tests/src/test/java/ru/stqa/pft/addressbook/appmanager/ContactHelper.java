package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;


import java.util.HashSet;
import java.util.List;
import java.util.Set;


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

  public void selectContact(int index) {
    wd.findElements(By.xpath("//img[@alt='Edit']") ).get( index ).click();
  }
  public void selectContactById(int id) {

    wd.findElement(By.cssSelector("input[value=" + id + "]") ).click();
  }

  public void submitData2() {

    click(By.xpath("//div[@id='content']/form/input[21]"));

    ;
  }


  public void returmToContactPage() {
    click(By.linkText("add next"));

  }

  public void fillContactData(ContactData contactData,boolean creation) {
    type(By.name("firstname"),contactData.getFirstname());
    type(By.name("lastname"),contactData.getLastName());
//    type(By.name("home"),contactData.getHome());
//    type(By.name("email"),contactData.getMail());
//    type(By.name("notes"),contactData.getNotes());
    if (creation) {
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }
//    if(isElementPresent(By.name("new_group"))) {
//      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
//    }

  }

  public void contactPage() {
    if (isElementPresent(By.id("maintable"))) {
      return;
    }
    click(By.linkText("home"));
  }

  public void submitModificationContact() {
    click(By.name("update"));
  }

  public void submitDeletionContact() {
    wd.switchTo().alert().accept();
    wd.findElement(By.cssSelector("div.msgbox"));
  }

  public boolean isThereAContact() {
    return isElementPresent(By.name("selected[]"));
  }

  public void create(ContactData contact, boolean b) {
    initContactPage();
    fillContactData(contact,b);
    submitData();
    contactPage();
  }
  public void modify( ContactData contact) {
    selectContactById(contact.getId());
    fillContactData(contact,false);
    submitModificationContact();
    contactPage();
  }

  public void delete(ContactData contact) {
    selectContactById(contact.getId());
    deleteSelectedContacts();
    submitDeletionContact();
    contactPage();
  }

  private void initContactPage() {
    click(By.linkText("add new"));
  }

  public int getContactCount() {
    return wd.findElements(By.name("selected[]")).size();
  }

  public Contacts all() {
    Contacts contacts= new Contacts();
    //List<WebElement> elements = wd.findElements(By.cssSelector("td.center>input"));
    List<WebElement> rows = wd.findElements(By.name("entry"));
    for (WebElement row : rows){
      //String id = element.findElement(By.cssSelector("input")).getAttribute("value");
      List<WebElement> cells = row.findElements(By.tagName("td"));
      int id = Integer.parseInt(cells.get(0).findElement(By.tagName("input")).getAttribute("value"));
      String firstname = cells.get(2).getText();
      String lastname = cells.get(1).getText();
      // name = element.getText();
      contacts.add(new ContactData().withId(id).withFirstname(firstname).withLastname(lastname).withGroup("test2"));
    }
    return contacts;
  }


}
