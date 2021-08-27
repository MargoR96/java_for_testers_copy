package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.ArrayList;
import java.util.List;


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
    wd.findElements(By.name("selected[]")).get(index).click();
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

  public boolean isThereAContact() {
    return isElementPresent(By.name("selected[]"));
  }

  public void createContact(ContactData contact, boolean b) {
    initContactPage();
    fillContactData(contact,b);
    submitData();
    returmToContactPage();
  }

  private void initContactPage() {
    click(By.linkText("add new"));
  }

  public int getContactCount() {
    return wd.findElements(By.name("selected[]")).size();
  }

  public List<ContactData> getContactList() {
    List<ContactData> contacts= new ArrayList<ContactData>();
    //List<WebElement> elements = wd.findElements(By.cssSelector("td.center>input"));
    List<WebElement> rows = wd.findElements(By.name("entry"));
    for (WebElement row : rows){
      //String id = element.findElement(By.cssSelector("input")).getAttribute("value");
      List<WebElement> cells = row.findElements(By.tagName("td"));
      int id = Integer.parseInt(cells.get(0).findElement(By.tagName("input")).getAttribute("value"));
      String firstname = row.getText();
      String name = row.getText();
      // name = element.getText();
      ContactData contact = new ContactData(id,name,firstname,null,null,null,null);
      contacts.add(contact);
    }
    return contacts;
  }
}
