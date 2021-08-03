package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() throws Exception {
    app.getNavigationHelper().goToHome();
    int before = app.getContactHelper().getContactCount();
    app.getContactHelper().createContact(new ContactData("test", "1", "test@mail.ru", "22","test2"),true);
    app.getNavigationHelper().goToHome();
    int after = app.getContactHelper().getContactCount();
    Assert.assertEquals(after,before + 1);
  }




}
