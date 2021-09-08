package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.sql.*;

public class DbConnectionTest {
  @Test
  public void testDbConnection (){
    Connection conn = null;
    try {
      conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/addressbook?user=root&password=");
      Statement st = conn.createStatement();
      ResultSet resultSetGroups = st.executeQuery("select group_id,group_name,group_header,group_footer from group_list");
      Groups groups = new Groups();
      while (resultSetGroups.next()){
        groups.add(new GroupData()
                .withId(resultSetGroups.getInt("group_id")).withName(resultSetGroups.getString("group_name"))
                .withHeader(resultSetGroups.getString("group_header")).withFooter(resultSetGroups.getString("group_footer")));
      }

      resultSetGroups.close();
      st.close();
      conn.close();
      System.out.println(groups);


    } catch (SQLException ex) {
      // handle any errors
      System.out.println("SQLException: " + ex.getMessage());
      System.out.println("SQLState: " + ex.getSQLState());
      System.out.println("VendorError: " + ex.getErrorCode());
    }

  }
  @Test
  public void testDbConnectionContacts (){
    Connection conn = null;
    try {
    conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/addressbook?user=root&password=");
    Statement st = conn.createStatement();
    ResultSet resultSetContacts = st.executeQuery("select id ,firstname,lastname,address,email from addressbook");
    Contacts contacts = new Contacts();
    while (resultSetContacts.next()){
      contacts.add(new ContactData()
              .withId(resultSetContacts.getInt("id")).withLastname(resultSetContacts.getString("lastname"))
              .withFirstname(resultSetContacts.getString("firstname")).withAddress(resultSetContacts.getString("address"))
              .withEmail(resultSetContacts.getString("email")));
    }
    resultSetContacts.close();
    st.close();
    conn.close();
    System.out.println(contacts);
  } catch (SQLException ex) {
    // handle any errors
    System.out.println("SQLException: " + ex.getMessage());
    System.out.println("SQLState: " + ex.getSQLState());
    System.out.println("VendorError: " + ex.getErrorCode());
  }
  }
}
