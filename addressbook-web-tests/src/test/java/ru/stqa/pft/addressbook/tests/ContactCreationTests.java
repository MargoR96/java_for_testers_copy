package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;


import java.util.HashSet;

import java.util.Set;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

public class ContactCreationTests extends TestBase {

  @Test(enabled = false)
  public void testContactCreation() throws Exception {
    app.goTo().goToHome();
    Contacts before = app.contact().all();
    ContactData contact = new ContactData().withFirstname("test").withLastname("1").withGroup("test2");
    app.contact().create(contact,true);
    app.goTo().goToHome();
    Contacts after = app.contact().all();
    assertThat(after.size(),equalTo(before.size() + 1));

    contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt());
    before.add(contact);
    assertThat(after, equalTo(before));
  }
  }





