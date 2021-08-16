package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public class ContactData {
  private final String lastname;
  private final String home;
  private final String mail;
  private final String notes;
  private String group;
  private String firstname;
  private final String id;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ContactData that = (ContactData) o;
    return Objects.equals(lastname, that.lastname) && Objects.equals(firstname, that.firstname) && Objects.equals(id, that.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(lastname, firstname, id);
  }

  @Override
  public String toString() {
    return "ContactData{" +
            "lastname='" + lastname + '\'' +
            ", firstname='" + firstname + '\'' +
            ", id='" + id + '\'' +
            '}';
  }

  public String getId() {
    return id;
  }


  public ContactData(String id,String firstname,String lastname, String home, String mail, String notes, String group) {
    this.id = id;
    this.lastname = lastname;
    this.firstname = firstname;
    this.home = home;
    this.mail = mail;
    this.notes = notes;
    this.group = group;
  }

  public ContactData(String firstname, String lastname, String home, String mail, String notes, String group) {
    this.id = null;
    this.lastname = lastname;
    this.firstname = firstname;
    this.home = home;
    this.mail = mail;
    this.notes = notes;
    this.group = group;
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


  public String getFirstname() {
    return firstname;
  }
}
