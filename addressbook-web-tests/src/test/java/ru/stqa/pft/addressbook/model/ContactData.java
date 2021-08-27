package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public class ContactData {
  private final String lastname;
  private String group;
  private String firstname;
  private int id;

  @Override
  public String toString() {
    return "ContactData{" +
            "lastname='" + lastname + '\'' +
            ", firstname='" + firstname + '\'' +
            ", id='" + id + '\'' +
            '}';
  }

  public int getId() {
    return id;
  }



  public ContactData(int id, String firstname, String lastname,  String group) {
    this.id = id;
    this.lastname = lastname;
    this.firstname = firstname;
    this.group = group;
  }

  public ContactData(String firstname, String lastname,  String group) {
    this.id = 0;
    this.lastname = lastname;
    this.firstname = firstname;
    this.group = group;
  }



//  public String getHome() {
//    return home;
//  }
//
//  public String getMail() {
//    return mail;
//  }
//
//  public String getNotes() {
//    return notes;
//  }

  public String getLastName() {
    return lastname;
  }


  public String getGroup() {
    return group;
  }


  public String getFirstname() {
    return firstname;
  }
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ContactData that = (ContactData) o;
    return id == that.id && Objects.equals(lastname, that.lastname) && Objects.equals(firstname, that.firstname);
  }

  @Override
  public int hashCode() {
    return Objects.hash(lastname, firstname, id);
  }

  public void setId(int id) {
    this.id = id;
  }
}
