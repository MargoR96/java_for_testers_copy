package ru.stqa.pft.addressbook.model;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.File;
import java.util.Objects;

@XStreamAlias("contact")
@Entity
@Table(name="addressbook")
public class ContactData {
  @Expose
  @Type(type = "text")
  private String lastname;
  @Transient
  private String group;
  @Expose
  @Type(type = "text")
  private String firstname;
  @Column(name = "home")
  private String homePhone;
  @Column(name = "mobile")
  private String mobilePhone;
  @Column(name = "work")
  private String workPhone;
  @Expose
  @Type(type = "text")
  private String address;
  @Expose
  @Type(type = "text")
  private String email1;
  @Expose
  @Type(type = "text")
  private String email2;
  @Expose
  @Type(type = "text")
  private String email3;
  @Expose
  @Column(name = "photo")
  @Type(type = "text")
  private String photo;


  @Expose
  @Transient
  private String allEmails;

  @Expose
  @Transient
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

  public String getAllEmails() {
    return allEmails;
  }



  public String getAddress() {
    return address;
  }

  public String getEmail2() {
    return email2;
  }

  public String getEmail3() {
    return email3;
  }

  public String getEmail1() {
    return email1;
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

  public ContactData withAllEmails(String allEmails) {
    this.allEmails = allEmails;
    return this;
  }

  public ContactData withAddress(String address) {
    this.address = address;
    return this;
  }

  public void setLastname(String lastname) {
    this.lastname = lastname;
  }

  public ContactData withEmail1(String email1) {
    this.email1 = email1;
    return this;
  }


  public ContactData withEmail2(String email2) {
    this.email2 = email2;
    return this;
  }

  public ContactData withEmail3(String email3) {
    this.email3 = email3;
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
    return id == that.id && Objects.equals(lastname, that.lastname) && Objects.equals(group, that.group) && Objects.equals(firstname, that.firstname) && Objects.equals(homePhone, that.homePhone) && Objects.equals(mobilePhone, that.mobilePhone) && Objects.equals(workPhone, that.workPhone) && Objects.equals(address, that.address) && Objects.equals(email1, that.email1) && Objects.equals(email2, that.email2) && Objects.equals(email3, that.email3) && Objects.equals(photo, that.photo) && Objects.equals(allPhones, that.allPhones);
  }

  @Override
  public int hashCode() {
    return Objects.hash(lastname, group, firstname, homePhone, mobilePhone, workPhone, address, email1, email2, email3, photo, allPhones, id);
  }

}
