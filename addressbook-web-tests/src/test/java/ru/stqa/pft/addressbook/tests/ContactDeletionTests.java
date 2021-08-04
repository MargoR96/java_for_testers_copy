package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactDeletionTests extends TestBase {


  @Test
  public void testContactDeletion(){
    app.getNavigationHelper().goToHome();
    int before = app.getContactHelper().getContactCount();
    if (!app.getContactHelper().isThereAContact()){
      app.getContactHelper().createContact(new ContactData("test", "1", "test@mail.ru", "22","test2"),true);
    }
    app.getContactHelper().selectContact(before-1);
    app.getContactHelper().deleteSelectedContacts();
    app.getContactHelper().submitDeletionContact();
    app.getNavigationHelper().goToHome();
    int after = app.getContactHelper().getContactCount();
    Assert.assertEquals(after,before - 1);

  }


}
