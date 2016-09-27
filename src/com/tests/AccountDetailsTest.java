package com.tests;

import org.testng.annotations.Test;

import com.base.BaseSetup;
import com.pageobjects.BasePage;
import com.pageobjects.LoginPage;
import com.pageobjects.MyAccountPage;
import com.pageobjects.MyProfilePage;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;

public class AccountDetailsTest extends BaseSetup {
  private WebDriver driver;	
  @Test(enabled=false)
  public void VerifyAccountDetailsSaved() throws InterruptedException {
	  System.out.println("======== Account Details Saved on Login ========");
	  String newCity="Mumbai";
	  BasePage basepage=new BasePage(driver);
	  MyAccountPage accountpage= basepage.clickOnAccount();
	  
	  // Login process
	  accountpage.addUserName("shrik");
	  accountpage.addPassWord("cybage@123");
	  accountpage.clickLogin();
	  Thread.sleep(5000);
	  accountpage.clickYourDetails();
	  accountpage.UpdateCity(newCity);
	  accountpage.clickSaveProfile();
	  //Logout and On Login Page
	  LoginPage loginpage=accountpage.clickLogout();
	  System.out.println("Passed");
	  Thread.sleep(5000);
	  // Login again to land on profile page
	  MyProfilePage myprofilepage= loginpage.DoLogin("shrik", "cybage@123");
	  basepage=myprofilepage.ClickHome();
	  // Login again
      accountpage= basepage.clickOnAccount();
	  accountpage.clickYourDetails();
	  String expectedCity=accountpage.getCity();
	  System.out.println(expectedCity+" "+newCity);
	  Assert.assertEquals(newCity, expectedCity);
	  
  }
  @BeforeClass
  public void beforeClass() {
	  driver= getDriver();
  }

}
