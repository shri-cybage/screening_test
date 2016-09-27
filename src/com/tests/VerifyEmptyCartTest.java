package com.tests;

import org.testng.annotations.Test;

import com.base.BaseSetup;
import com.pageobjects.BasePage;
import com.pageobjects.CheckOutPage;
import com.pageobjects.IphonePage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;

public class VerifyEmptyCartTest extends BaseSetup {
  private WebDriver driver;
  @Test(enabled=false)
  public void VerifyEmptyCartMessage() 
  {
	  //Go to Base Page
	  BasePage basepage=new BasePage(driver);
	  // Select iphone category
	  IphonePage iphonepage=basepage.SelectIphoneCategory();
	  // Select iphone 4s 
	  iphonepage.selectAppleiPhone4s();
	  // Click to checkout 
	  CheckOutPage checkoutpage=iphonepage.clickCheckout();
	  int totalitems=checkoutpage.getcartitemcount();
	  for(int i=0;i<totalitems;i++){
	  checkoutpage.RemoveItemsFromCart(i);
	  }
	  totalitems=checkoutpage.getcartitemcount();
	  Assert.assertEquals(totalitems, 0);
	  
	  
	  
  }
  @BeforeClass
  public void beforeClass() {
	  driver= getDriver();
  }

}
