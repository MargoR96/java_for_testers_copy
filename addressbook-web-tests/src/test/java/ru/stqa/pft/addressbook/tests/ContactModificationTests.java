package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase{
  @Test
  public void testContactModification (){
    app.getNavigationHelper().goToHome();
    app.getContactHelper().selectContact();
    app.getContactHelper().initModificationContact();
    app.getContactHelper().fillContactData(new ContactData("test", "test", "1", "test@mail.ru", "22"));
    app.getContactHelper().submitModificationContact();
    app.getNavigationHelper().goToHome();
  }
}
