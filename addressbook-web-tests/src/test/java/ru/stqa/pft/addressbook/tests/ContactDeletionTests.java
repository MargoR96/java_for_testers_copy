package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class ContactDeletionTests extends TestBase {


  @Test
  public void testContactDeletion(){
    app.getNavigationHelper().goToHome();
    app.getGroupHelper().selectContact();
    app.getGroupHelper().deleteSelectedContacts();
    app.getNavigationHelper().goToHome();
  }


}
