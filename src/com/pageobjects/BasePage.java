package com.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class BasePage {
	
	protected WebDriver driver;
	
	@FindBy(id="menu-item-33")
	WebElement productCategory;
	
	@FindBy(id="menu-item-37")
	WebElement iphoneOption;
	
	@FindBy(className="account_icon")
	WebElement myAccountLink;
		
	public BasePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	// To select iphone option from product category
	public IphonePage SelectIphoneCategory(){
		/*Actions act=new Actions(driver);
		act.moveToElement(productCategory).perform();
		act.moveToElement(iphoneOption).click();
		act.perform();
		*/
		driver.navigate().to("http://store.demoqa.com/products-page/product-category/iphones/");
		return new IphonePage(driver);
	}
	
	// To select My account 
	public MyAccountPage clickOnAccount(){
		myAccountLink.click();
		return new MyAccountPage(driver);
	}
	
	
	

}
