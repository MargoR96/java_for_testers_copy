package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;


import java.util.HashSet;

import java.util.Set;

public class ContactCreationTests extends TestBase {

  @Test(enabled = false)
  public void testContactCreation() throws Exception {
    app.goTo().goToHome();
    Set<ContactData> before = app.contact().all();
    ContactData contact = new ContactData().withFirstname("test").withLastname("1").withGroup("test2");
    app.contact().create(contact,true);
    app.goTo().goToHome();
    Set<ContactData> after = app.contact().all();
    Assert.assertEquals(after.size(),before.size() + 1);

    contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt());
    before.add(contact);
    Assert.assertEquals(new HashSet<Object>(before),new HashSet<Object>(after));
  }
  }





