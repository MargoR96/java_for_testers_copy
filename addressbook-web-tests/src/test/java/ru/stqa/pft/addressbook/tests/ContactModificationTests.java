package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase{
  @Test
  public void testContactModification (){
    app.getNavigationHelper().goToHome();
    int before = app.getContactHelper().getContactCount();
    if (!app.getContactHelper().isThereAContact()){
      app.getContactHelper().createContact(new ContactData("test", "1", "test@mail.ru", "22","test2"),true);
    }
    app.getContactHelper().selectContact();
    app.getContactHelper().initModificationContact();
    app.getContactHelper().fillContactData(new ContactData( "test", "1", "test@mail.ru", "22",null),false);
    app.getContactHelper().submitModificationContact();
    app.getNavigationHelper().goToHome();
    int after = app.getContactHelper().getContactCount();
    Assert.assertEquals(after,before);
  }
}
