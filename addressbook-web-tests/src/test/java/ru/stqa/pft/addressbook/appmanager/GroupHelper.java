package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupHelper extends HelperBase {

  public GroupHelper(WebDriver wd) {
    super(wd);
  }

  public void initGroupCreation() {
    click(By.name("new"));
  }

  public void returnToGroupPage() {
    click(By.linkText("group page"));
  }

  public void submitData() {
    click(By.name("submit"));
  }

  public void fillGroupData(GroupData groupData) {
    type(By.name("group_name"), groupData.getName());
    type(By.name("group_header"), groupData.getHeader());
    type(By.name("group_footer"), groupData.getFooter());
  }

  public void deleteSelectedGroups() {
    click(By.name("delete"));
  }


  public void selectGroup() {
    click(By.name("selected[]"));
  }
  public void deleteSelectedContacts() {
    click(By.xpath("//input[@value='Delete']"));
  }

  public void selectContact() {
    click(By.id("3"));

  }
  public void submitData2() {

    click(By.xpath("//div[@id='content']/form/input[21]"));

    ;
  }


  public void returmToContactPage() {
    click(By.linkText("add next"));

  }

  public void fillContactData(ContactData contactData) {
    type(By.name("lastname"),contactData.getFirstname());
    type(By.name("home"),contactData.getHome());
    type(By.name("email"),contactData.getMail());
    type(By.name("notes"),contactData.getNotes());
  }



}
