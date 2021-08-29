package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public class ContactData {

  private String lastname;
  private String group;
  private String firstname;
  private String homePhone;
  private String mobilePhone;
  private String workPhone;



  private int id = Integer.MAX_VALUE;;

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

  public String getLastName() {
    return lastname;
  }


  public String getGroup() {
    return group;
  }


  public String getFirstname() {
    return firstname;
  }


  public int getId(int id) {
    return id;
  }



  public ContactData withId(int id) {
    this.id = id;
    return this;
  }

  public ContactData withLastname(String lastname) {
    this.lastname = lastname;
    return this;
  }


  public ContactData withGroup(String group) {
    this.group = group;
    return this;
  }

  public ContactData withFirstname(String firstname) {
    this.firstname = firstname;
    return this;
  }
  public ContactData withHomePhone(String homePhone) {
    this.homePhone = homePhone;
    return this;
  }

  public ContactData withMobilePhone(String mobilePhone) {
    this.mobilePhone = mobilePhone;
    return this;
  }

  public ContactData withWorkPhone(String workPhone) {
    this.workPhone = workPhone;
    return this;
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
}
