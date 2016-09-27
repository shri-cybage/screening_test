package com.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseSetup {
  private WebDriver driver;
  static String driverpath="D:\\Selenium Java Dependancies\\chromedriver_win32\\";
  
  
  public WebDriver getDriver(){
	  return driver;
  }
	

  private void setDriver(String browserType,String appURL) {
	  switch (browserType) {
	case "chrome":
		driver=initChromeDriver(appURL);
		break;
	case "firefox":
		driver=initFirefoxDriver(appURL);
		break;
	default:
		System.out.println("Browser"+ browserType +"is invalid");
	}
	  
  }
  
  private static WebDriver initChromeDriver(String appURL){
	  System.out.println("Launching Chrome broswer");
	  System.setProperty("webdriver.chrome.driver", driverpath+"chromedriver.exe");
	  WebDriver driver=new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.navigate().to(appURL);
	  return driver;
	  
  }
  
  
  private static WebDriver initFirefoxDriver(String appURL){
	  System.out.println("Launching Firefox broswer");
	  WebDriver driver=new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.navigate().to(appURL);
	  driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
	  driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
	  return driver;
	  
  }
  
  @Parameters({"browserType" , "appURL"})
  @BeforeClass
  public void initDriver(String browserType,String appURL) 
  {
	  try
	  {
		  setDriver(browserType, appURL);  
	  }
	  catch(Exception e)
	  {
		  System.out.println("Error"+e.getStackTrace()); 
	  }
	  
  }

  @AfterClass
  public void afterClass() {
	  driver.close();
  }

}
