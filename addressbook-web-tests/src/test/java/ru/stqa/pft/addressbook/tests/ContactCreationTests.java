package ru.stqa.pft.addressbook.tests;

import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;
import org.openqa.selenium.json.TypeToken;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;


import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

public class ContactCreationTests extends TestBase {

  @DataProvider
  public Iterator<Object[]> validContactsXML() throws IOException {
    //List<Object[]> list = new ArrayList<Object[]>();
    //list.add(new Object[]{new ContactData().withFirstname("firstname 1").withLastname("lastname 1").withGroup("test2").withPhoto(photo)});
    //list.add(new Object[]{new ContactData().withFirstname("firstname 2").withLastname("lastname 2").withGroup("test2").withPhoto(photo)});
    //list.add(new Object[]{new ContactData().withFirstname("firstname 3").withLastname("lastname 3").withGroup("test2").withPhoto(photo)});
    try ( BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.xml")));
    ) {
      String xml ="";
      String line = reader.readLine();
      while (line != null){
        //String[] split = line.split(";");
        //list.add(new Object[]{new ContactData().withFirstname(split[0]).withLastname(split[1])});
        xml += line;
        line = reader.readLine();
      }
      XStream xstream = new XStream();
      xstream.processAnnotations(ContactData.class);
      List<ContactData> contacts = (List<ContactData>)xstream.fromXML(xml);
      return contacts.stream().map((g) -> new Object[]{g}).collect(Collectors.toList()).iterator();
    }
    //return list.iterator();
  }
  @DataProvider
  public Iterator<Object[]> validContactsJson() throws IOException {
    //List<Object[]> list = new ArrayList<Object[]>();
    //list.add(new Object[]{new ContactData().withFirstname("firstname 1").withLastname("lastname 1").withGroup("test2").withPhoto(photo)});
    //list.add(new Object[]{new ContactData().withFirstname("firstname 2").withLastname("lastname 2").withGroup("test2").withPhoto(photo)});
    //list.add(new Object[]{new ContactData().withFirstname("firstname 3").withLastname("lastname 3").withGroup("test2").withPhoto(photo)});
    try (BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.json")));
    ) {
      String json ="";
      String line = reader.readLine();
      while (line != null){
        //String[] split = line.split(";");
        //list.add(new Object[]{new ContactData().withFirstname(split[0]).withLastname(split[1])});
        json += line;
        line = reader.readLine();
      }
      Gson gson = new Gson();
      List<ContactData> contacts = gson.fromJson(json,new TypeToken<List<ContactData>>(){}.getType());
      return contacts.stream().map((g) -> new Object[]{g}).collect(Collectors.toList()).iterator();
      //return list.iterator();
    }

  }
  @BeforeMethod
  public void ensurePreconditions (){
    if (app.db().groups().size() ==0){
      app.goTo().groupPage();
      app.group().create(new GroupData().withName("test2"));
    }
  }

  @Test (dataProvider = "validContactsJson")
  public void testContactCreation(ContactData contact) throws Exception {
      app.goTo().goToHome();
      Contacts before = app.db().contacts();
      File photo = new File("src/test/resources/photo.png");
      app.contact().create(contact,true);
      assertThat(app.contact().count(),equalTo(before.size() + 1));
      Contacts after = app.db().contacts();
      assertThat(after, equalTo(
              before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
    verifyInContactListInUI();
    }


  @Test(enabled = false)
  public void testBadContactCreation() throws Exception {
    Groups groups = app.db().groups();
    app.goTo().goToHome();
    Contacts before = app.contact().all();
    ContactData contact = new ContactData().withFirstname("test'").withLastname("1").inGroup(groups.iterator().next());
    app.contact().create(contact,true);
    app.goTo().goToHome();
    assertThat(app.contact().count(),equalTo(before.size()));
    Contacts after = app.contact().all();
    assertThat(after, equalTo(before));
    verifyInContactListInUI();
  }
//  @Test
//
//  public void testCurrentDir() {
//    File currentDir = new File(".");
//    currentDir.getAbsolutePath();
//    File photo = new File("src/test/resourses/photo.png");
//    System.out.println(photo.getAbsolutePath());
//    System.out.println(photo.exists());
//  }
  }





