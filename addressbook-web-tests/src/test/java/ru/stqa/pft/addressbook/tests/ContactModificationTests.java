package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Set;

public class ContactModificationTests extends TestBase{

  @BeforeMethod
  public void ensurePreconditions (){
    app.contact().contactPage();

    if (app.contact().all().size() ==0) {
      app.contact().create(new ContactData().withFirstname("test").withLastname("1").withGroup("test2"),false);
    }
  }

  @Test (enabled = false)
  public void testContactModification (){

    Set<ContactData> before = app.contact().all();
    ContactData modifiedContact  = before.iterator().next();
    ContactData contact  = new ContactData()
            .withId(modifiedContact.getId()).withFirstname("test").withLastname("1").withGroup("test2");
    app.contact().modify(contact);
    Set<ContactData> after = app.contact().all();
    Assert.assertEquals(after.size(),before.size());
    before.remove(modifiedContact);
    Assert.assertEquals(before,after);
  }


}
