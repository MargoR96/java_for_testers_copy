package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class GroupDeletionCase extends TestBase{

  @Test
  public void testGroupDeletionCase() throws Exception {
    app.getNavigationHelper().goToGroupPage();
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().deleteSelectedGroups();
    app.getGroupHelper().returnToGroupPage();
  }


}
