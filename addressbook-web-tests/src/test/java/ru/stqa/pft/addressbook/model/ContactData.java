package ru.stqa.pft.addressbook.model;

public class ContactData {
  private final String lastname;
  private final String home;
  private final String mail;
  private final String notes;
  private String group;

  public ContactData(String lastname, String home, String mail, String notes, String group) {
    this.lastname = lastname;
    this.home = home;
    this.mail = mail;
    this.notes = notes;
    this.group = group;
  }


  public String getLastname() {
    return lastname;
  }

  public String getHome() {
    return home;
  }

  public String getMail() {
    return mail;
  }

  public String getNotes() {
    return notes;
  }

  public String getLastName() {
    return lastname;
  }


  public String getGroup() {
    return group;
  }
}
