package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

public class ContactDeletionTests extends TestBase {


  @Test
  public void testContactDeletion(){
    app.getNavigationHelper().goToHome();

    if (!app.getContactHelper().isThereAContact()){
      app.getContactHelper().createContact(new ContactData("test","1","1", "test@mail.ru", "22","test2"),true);
    }
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().selectContact(before.size()-1);
    app.getContactHelper().deleteSelectedContacts();
    app.getContactHelper().submitDeletionContact();
    app.getNavigationHelper().goToHome();
    List<ContactData> after = app.getContactHelper().getContactList();
    //Assert.assertEquals(after,before.size() - 1);
    before.remove(before.size()-1);
    Assert.assertEquals(before,after);
  }


}
