package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactPostMailTest extends TestBase{

  @BeforeMethod
  public void ensurePreconditions (){
    app.contact().contactPage();

    if (app.contact().all().size() ==0) {
      app.contact().create(new ContactData().withFirstname("test").withLastname("1").withGroup("test2"),false);
    }
  }
  @Test
  public void testContactsAddress () {
    app.goTo().goToHome();
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
    assertThat(contact.getAddress(), equalTo(merge(contactInfoFromEditForm)));
  }
  private String merge(ContactData contact) {
    return Arrays.asList(contact.getAddress())
            .stream().filter((s) -> !s.equals("")).map(ContactPhoneTest::cleaned)
            .collect(Collectors.joining("\n"));
  }
  public static String cleaned (String address){
    return address.replaceAll("\\s","").replaceAll("[-()]","");
  }
}
