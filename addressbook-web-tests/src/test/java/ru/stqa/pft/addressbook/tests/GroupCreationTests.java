package ru.stqa.pft.addressbook.tests;


import com.thoughtworks.xstream.XStream;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

public class GroupCreationTests extends TestBase{

  @DataProvider
  public Iterator<Object[]> validGroups() throws IOException {
    //List<Object[]> list = new ArrayList<Object[]>();
    //list.add(new Object[]{ new GroupData().withName("test1").withHeader("header1").withFooter("footer 1")});
    //list.add(new Object[]{ new GroupData().withName("test2").withHeader("header2").withFooter("footer 2")});
    //list.add(new Object[]{ new GroupData().withName("test3").withHeader("header3").withFooter("footer 3")});
    BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resourses/groups.xml")));
    //String line = reader.readLine();
    String xml ="";
    String line = reader.readLine();
    while (line != null){
      //String[] split = line.split(";");
      //list.add(new Object[]{new GroupData().withName(split[0]).withHeader(split[1]).withFooter(split[2])});
      xml += line;
      line = reader.readLine();
    }
    XStream xstream = new XStream();
    xstream.processAnnotations(GroupData.class);
    List<GroupData> groups = (List<GroupData>)xstream.fromXML(xml);
    return groups.stream().map((g) -> new Object[]{g}).collect(Collectors.toList()).iterator();
    //return list.iterator();
  }

  @Test (dataProvider = "validGroups")
  public void testGroupCreation(GroupData group)  {
      app.goTo().groupPage();
      Groups before = app.group().all();
      app.group().create(group);
      assertThat(app.group().count(),equalTo(before.size() + 1));
      Groups after = app.group().all();
      assertThat(after, equalTo(
              before.withAdded(group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
    }


  @Test (enabled = false)
  public void testBadGroupCreation()  {
    app.goTo().groupPage();
    Groups before = app.group().all();
    GroupData group = new GroupData().withName("test2'");
    app.group().create(group);
    assertThat(app.group().count(),equalTo(before.size()));
    Groups after = app.group().all();
    assertThat(after, equalTo(before));
  }



}
