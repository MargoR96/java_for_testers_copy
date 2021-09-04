package ru.stqa.pft.addressbook.model;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

import java.io.File;
import java.util.Objects;

@XStreamAlias("contact")

public class ContactData {
  @Expose
  private String lastname;
  private String group;
  @Expose
  private String firstname;
  private String homePhone;
  private String mobilePhone;
  private String workPhone;
  @Expose
  private String address;
  @Expose
  private String email;
  @Expose
  private String photo;

  @Expose
  private String allPhones;

  @XStreamOmitField
  private int id = Integer.MAX_VALUE;

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

  public String getHomePhone() {
    return homePhone;
  }

  public String getMobilePhone() {
    return mobilePhone;
  }

  public String getWorkPhone() {
    return workPhone;
  }

  public String getAllPhones() {
    return allPhones;
  }
  public String getAddress() {
    return address;
  }

  public String getEmail() {
    return email;
  }
  public File getPhoto() {
    return new File(photo);
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
  public ContactData withAllPhones(String allPhones) {
    this.allPhones = allPhones;
    return this;
  }

  public ContactData withAddress(String address) {
    this.address = address;
    return this;
  }



  public ContactData withEmail(String email) {
    this.email = email;
    return this;
  }

  public ContactData withPhoto(File photo) {
    this.photo = photo.getPath();
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
