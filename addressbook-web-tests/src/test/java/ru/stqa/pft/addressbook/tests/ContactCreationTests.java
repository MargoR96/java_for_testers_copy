package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() throws Exception {

    app.getNavigationHelper().goToContactPage();
    app.getGroupHelper().fillContactData(new ContactData("test", "test", "1", "test@mail.ru", "22"));
    app.getGroupHelper().submitData();
    app.getGroupHelper().returmToContactPage();
  }




}
