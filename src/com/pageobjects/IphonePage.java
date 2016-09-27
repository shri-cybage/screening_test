package com.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IphonePage {

	private WebDriver driver;
	
	@FindBy(name="product_96")
	WebElement AppleiPhone4S; 
	
	@FindBy(css="span.currentprice.pricedisplay.product_price_96")
	WebElement priceIPhone4s;
	
	@FindBy(className="go_to_checkout")
	WebElement checkoutBtn;

	public IphonePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public IphonePage selectAppleiPhone4s(){
		AppleiPhone4S.submit();
		return this;
	}
	
	public Float getAppleiPhone4sPrice(){
		String price=priceIPhone4s.getText();
		String actual=price.split("\\$")[1];
		return Float.parseFloat(actual);
	}
	
	public CheckOutPage clickCheckout()
	{
		WebElement ele=new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(checkoutBtn));
		ele.click();
		return new CheckOutPage(driver);
		
	}

}
