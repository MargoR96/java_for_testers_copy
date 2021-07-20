package ru.stqa.pft.addressbook.model;

public class ContactData {
  private final String lastname;
  private final String home;
  private final String mail;
  private final String notes;

  public ContactData(String firstname, String lastname, String home, String mail, String notes) {
    this.lastname = lastname;
    this.home = home;
    this.mail = mail;
    this.notes = notes;
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
}
