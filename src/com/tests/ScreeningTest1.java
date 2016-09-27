package com.tests;

import org.testng.annotations.Test;

import com.base.BaseSetup;
import com.pageobjects.BasePage;
import com.pageobjects.CheckOutPage;
import com.pageobjects.IphonePage;

import org.junit.Ignore;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;

public class ScreeningTest1 extends BaseSetup {
  private WebDriver driver;
  	
  @Test
  public void VerifyIphoneOrderPrice() {
	  System.out.println("======== Iphone 4s Order ========");
	  BasePage basepage=new BasePage(driver);
	  //Submit an order for an Apple iPhone4s 16GB SIM-Free – Black 
	  IphonePage iphonepage=basepage.SelectIphoneCategory();
	  iphonepage.selectAppleiPhone4s();
	  Float iphonePrice=iphonepage.getAppleiPhone4sPrice();
	  
	  //Checkout Process
	  CheckOutPage checkoutpage=iphonepage.clickCheckout();
	  // On CheckOutPage
	  checkoutpage.ClickContinue();
	  checkoutpage.ClickOnSelectCountryDD();
	  checkoutpage.SelectCountry("India");
	  checkoutpage.ClickCalculateBtn();
	  
	  // Form filling
	  checkoutpage.AddEmailAddress("shrikantk@cybage.com");
	  checkoutpage.EnterFirstName("Shrikant");
	  checkoutpage.AddLastName("Kharabe");
	  checkoutpage.AddAddress("Pune Lane 1");
	  checkoutpage.AddCity("Pune");
	  checkoutpage.AddState("Maharastra");
	  checkoutpage.SelectRegionSelectCountryDD("India");
	  checkoutpage.AddPhone("9850407878");
	 // checkoutpage.ClickOnPurchaseBtn();
	  Float expectedTotal= iphonePrice+ checkoutpage.getTotalShippingPrice();
	  Float actualTotal=checkoutpage.getTotalPrice();
	  System.out.println(expectedTotal+"  "+ actualTotal);
	  Assert.assertEquals(expectedTotal, actualTotal);
  }
  
 
  @BeforeClass
  public void beforeClass() {
	  driver= getDriver();
	  
  }
}
