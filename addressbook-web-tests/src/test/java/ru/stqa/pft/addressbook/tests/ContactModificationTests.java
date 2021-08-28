package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactModificationTests extends TestBase{
  @Test (enabled = false)
  public void testContactModification (){
    app.getNavigationHelper().goToHome();

    if (!app.getContactHelper().isThereAContact()){
      app.getContactHelper().createContact(new ContactData("test","1","test2"),false);
    }
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().selectContact(before.size()-1);
    //app.getContactHelper().initModificationContact();
    ContactData contact  = new ContactData("test","1","test2");
    app.getContactHelper().fillContactData(contact,false);
    app.getContactHelper().submitModificationContact();
    app.getContactHelper().goToContactPage();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(),before.size());
    before.remove(before.size()-1);
    Comparator<? super ContactData> byId = (Comparator<ContactData>) (o1, o2) -> Integer.compare(o1.getId(), o2.getId());
    before.add(contact);
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before,after);
  }
}
