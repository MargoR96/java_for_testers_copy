package ru.stqa.pft.addressbook;

public class ContactData {
  private final String firstname;
  private final String middlename;
  private final String lastname;
  private final String title;
  private final String company;
  private final String address;
  private final String mail;
  private final String adress2;
  private final String notes;

  public ContactData(String firstname, String middlename, String lastname, String title, String company, String address, String mail, String adress2, String notes) {
    this.firstname = firstname;
    this.middlename = middlename;
    this.lastname = lastname;
    this.title = title;
    this.company = company;
    this.address = address;
    this.mail = mail;
    this.adress2 = adress2;
    this.notes = notes;
  }

  public String getFirstname() {
    return firstname;
  }

  public String getMiddlename() {
    return middlename;
  }

  public String getLastname() {
    return lastname;
  }

  public String getTitle() {
    return title;
  }

  public String getCompany() {
    return company;
  }

  public String getAddress() {
    return address;
  }

  public String getMail() {
    return mail;
  }

  public String getAdress2() {
    return adress2;
  }

  public String getNotes() {
    return notes;
  }
}
