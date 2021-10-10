package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactModificationTests extends TestBase{

  @BeforeMethod
  public void ensurePreconditions (){
    if (app.db().contacts().size() ==0){
      app.contact().contactPage();;
      app.contact().create(new ContactData().withFirstname("test").withLastname("1"),false);
    }
  }

  @Test
  public void testContactModification (){

    Contacts before = app.db().contacts();
    ContactData modifiedContact  = before.iterator().next();
    ContactData contact  = new ContactData()
            .withId(modifiedContact.getId()).withFirstname("test").withLastname("1");
    app.contact().contactPage();
    app.contact().modify(contact);
    assertThat(app.contact().count(),equalTo(before.size() ));
    Contacts after = app.db().contacts();
    assertThat(after,equalTo(before.without(modifiedContact).withAdded(contact)));
    verifyInContactListInUI();
  }




}
