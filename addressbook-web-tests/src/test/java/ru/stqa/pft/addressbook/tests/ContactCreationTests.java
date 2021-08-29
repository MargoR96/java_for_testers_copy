package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;



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
    assertThat(app.contact().count(),equalTo(before.size() + 1));
    Contacts after = app.contact().all();
    assertThat(after, equalTo(
            before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
  }
  @Test(enabled = false)
  public void testBadContactCreation() throws Exception {
    app.goTo().goToHome();
    Contacts before = app.contact().all();
    ContactData contact = new ContactData().withFirstname("test'").withLastname("1").withGroup("test2");
    app.contact().create(contact,true);
    app.goTo().goToHome();
    assertThat(app.contact().count(),equalTo(before.size()));
    Contacts after = app.contact().all();
    assertThat(after, equalTo(before));
  }
  }





