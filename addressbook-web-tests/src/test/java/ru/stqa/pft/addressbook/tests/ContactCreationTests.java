package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;


import java.util.HashSet;
import java.util.List;

public class ContactCreationTests extends TestBase {

  @Test(enabled = false)
  public void testContactCreation() throws Exception {
    app.goTo().goToHome();
    List<ContactData> before = app.contact().list();
    ContactData contact = new ContactData("test","1", "test2");
    app.contact().create(contact,true);
    app.goTo().goToHome();
    List<ContactData> after = app.contact().list();
    Assert.assertEquals(after.size(),before.size() + 1);


    contact.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
    before.add(contact);
    Assert.assertEquals(new HashSet<Object>(before),new HashSet<Object>(after));
  }
  }





