package ru.stqa.pft.addressbook.tests;

import com.thoughtworks.xstream.XStream;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;


import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

public class ContactCreationTests extends TestBase {

  @DataProvider
  public Iterator<Object[]> validContacts() throws IOException {
    //List<Object[]> list = new ArrayList<Object[]>();
    File photo = new File("src/test/resourses/photo.png");
    //list.add(new Object[]{new ContactData().withFirstname("firstname 1").withLastname("lastname 1").withGroup("test2").withPhoto(photo)});
    //list.add(new Object[]{new ContactData().withFirstname("firstname 2").withLastname("lastname 2").withGroup("test2").withPhoto(photo)});
    //list.add(new Object[]{new ContactData().withFirstname("firstname 3").withLastname("lastname 3").withGroup("test2").withPhoto(photo)});
    BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resourses/contacts.xml")));
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
    List<ContactData> groups = (List<ContactData>)xstream.fromXML(xml);
    return groups.stream().map((g) -> new Object[]{g}).collect(Collectors.toList()).iterator();
    //return list.iterator();
  }

  @Test (dataProvider = "validContacts")
  public void testContactCreation(ContactData contact) throws Exception {
      app.goTo().goToHome();
      Contacts before = app.contact().all();
      app.contact().create(contact,true);
      app.goTo().goToHome();
      assertThat(app.contact().count(),equalTo(before.size() + 1));
      Contacts after = app.contact().all();
      assertThat(after, equalTo(
              before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
    }

  @Test(enabled = false)
  public void testBadContactCreation() throws Exception {
    app.goTo().goToHome();
    Contacts before = app.contact().all();
    ContactData contact = new ContactData().withFirstname("test'").withLastname("1").withGroup("test2");
    app.contact().create(contact,true);
    app.goTo().goToHome();
    assertThat(app.contact().count(),equalTo(before.size()));
    Contacts after = app.contact().all();
    assertThat(after, equalTo(before));
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





