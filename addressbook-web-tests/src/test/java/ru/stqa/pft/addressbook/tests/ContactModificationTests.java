package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactModificationTests extends TestBase{

  @BeforeMethod
  public void ensurePreconditions (){
    app.contact().contactPage();

    if (app.contact().list().size() ==0) {
      app.contact().create(new ContactData("test","1","test2"),false);
    }
  }

  @Test (enabled = false)
  public void testContactModification (){

    List<ContactData> before = app.contact().list();
    int index = before.size()-1;
    ContactData contact  = new ContactData(before.get(index).getId(),"test","1","test2");
    app.contact().modify(index, contact);
    List<ContactData> after = app.contact().list();
    Assert.assertEquals(after.size(),before.size());
    before.remove(index);
    Comparator<? super ContactData> byId = (Comparator<ContactData>) (o1, o2) -> Integer.compare(o1.getId(), o2.getId());
    before.add(contact);
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before,after);
  }


}
