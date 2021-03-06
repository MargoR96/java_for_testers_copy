package ru.stqa.pft.appManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {
  private final Properties properties;
  private WebDriver wd;
  private String browser;
  private RegistrationHelper registrationHelper;

  public ApplicationManager(String browser) {
    this.browser = browser;
    properties = new Properties();
  }

  public void init() throws IOException {
    String target = System.getProperty("target", "local");
    //System.out.println(new File(".").getAbsolutePath());
    properties.load(new FileReader(new File(String.format("src/resources/%s.properties", target))));
  }

  public void stop() {
    if (wd != null) {
      wd.quit();
    }
  }



  public String getProperty(String key) {
    return properties.getProperty(key);
  }

  public HttpSession newHttpSessions() {
    return new HttpSession(this);
  }

  public RegistrationHelper registration() {
    if (registrationHelper == null){
      registrationHelper =  new RegistrationHelper(this);
    }
  return registrationHelper;
  }

  public WebDriver getDriver() {
    if (wd == null) {
      if (browser.equals(BrowserType.FIREFOX)){
        wd = new FirefoxDriver();
      } else if (browser.equals(BrowserType.CHROME)){
        wd = new ChromeDriver();
      } else if (browser.equals(BrowserType.IE)){
        wd = new InternetExplorerDriver();
      }
      wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
      wd.get(properties.getProperty("web.baseURL"));
    }
    return wd;
  }
}

