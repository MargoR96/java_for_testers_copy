package ru.stqa.pft.addressbook.generator;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.thoughtworks.xstream.XStream;
import ru.stqa.pft.addressbook.model.ContactData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class ContactDataGenerator {

  @Parameter(names = "-c", description = "Groups count")
  public int count;

  @Parameter(names = "-f", description = "File")
  public String file;

  @Parameter(names = "-d", description = "Data Format")
  public String format;

  public static void main (String [] args) throws IOException {
    ContactDataGenerator generator = new ContactDataGenerator();
    JCommander jCommander = new JCommander(generator);
    try {
      jCommander.parse(args);
    } catch (ParameterException e){
      jCommander.usage();
      return;
    }
    generator.run();


  }

  private void run() throws IOException {
    List<ContactData> contacts = generateContacts(count);
    if (format.equals("csv")){
      saveAsCSV(contacts,new File(file));
    } else if (format.equals("xml")) {
      saveAsXML(contacts,new File(file));
    } else if (format.equals("json")) {
      saveAsJson(contacts,new File(file));
    } else {
      System.out.println("Unrecognized format" + format);
    }
  }

  private void saveAsJson(List<ContactData> contacts, File file) throws IOException {
    Gson gson = new GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation().create();
    String json = gson.toJson(contacts);
    try (Writer writer = new FileWriter(file)){
      writer.write(json);
    }
  }

  private void saveAsXML(List<ContactData> contacts, File file) throws IOException {
    XStream xstream = new XStream();
    xstream.processAnnotations(ContactData.class);
    String xml = xstream.toXML(contacts);
    try (Writer writer = new FileWriter(file)){
      writer.write(xml);
    }
  }

  private void saveAsCSV(List<ContactData> contacts, File file) throws IOException {
    System.out.println(new File(".").getAbsolutePath());
    Writer writer = new FileWriter(file);
    for (ContactData contact:contacts){
      writer.write(String.format("%s;%s;%s;%s\n", contact.getFirstname(),contact.getLastName(),contact.getGroups(),contact.getAddress()));
    }
    writer.close();
  }

  private List<ContactData> generateContacts(int count) {
    List<ContactData> contacts = new ArrayList<ContactData>();
    File photo = new File("src/test/resourses/photo.png");
    for (int i = 0; i < count; i++){
      contacts.add(new ContactData()
              .withFirstname(String.format("test1", i))
              .withLastname(String.format("test2", i))
              .withAddress(String.format("test4", i))
              .withPhoto(photo));
    }
    return contacts;
  }
}
