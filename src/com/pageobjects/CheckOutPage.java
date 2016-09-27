package com.pageobjects;

import java.util.List;

import javax.xml.bind.ParseConversionEvent;

import org.apache.xml.serializer.ToHTMLSAXHandler;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Factory;

public class CheckOutPage {
	private WebDriver driver; 
	@FindBy(className="step2")
	WebElement continueBtn;
	
	@FindBy(id="uniform-current_country")
	WebElement selectCountryDD;
	
	@FindBy(id="current_country")
	WebElement selectCurrentCountry;
	
	@FindBy(name="wpsc_submit_zipcode")
	WebElement CalculateBtn;
	
	@FindBy(id="wpsc_checkout_form_9")
	WebElement emailAddress;
	
	@FindBy(id="wpsc_checkout_form_2")
	WebElement fname;
	
	@FindBy(id="wpsc_checkout_form_3")
	WebElement lname;
	
	@FindBy(id="wpsc_checkout_form_4")
	WebElement address;
	
	@FindBy(id="wpsc_checkout_form_5")
	WebElement city;
	
	@FindBy(id="wpsc_checkout_form_6")
	WebElement state;
	
	@FindBy(id="uniform-wpsc_checkout_form_7")
	WebElement regionSelectCountryDD;
	
	@FindBy(id="wpsc_checkout_form_7")
	WebElement reqionSelectCountry;
	
	@FindBy(id="wpsc_checkout_form_18")
	WebElement phone;
	
	@FindBy(css=".make_purchase.wpsc_buy_button")
	WebElement purchaseBtn;
	
	@FindBy(css=".total_price.total_shipping span")
	List<WebElement> TotalShipping;
	
	@FindBy(css="#checkout_total span")
	WebElement totalPrice;
	
	@FindBy(className="count")
	WebElement countofcartItems;
	
	@FindBy(className="checkout_cart")
	WebElement cartTable;



	public CheckOutPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public CheckOutPage ClickContinue(){
		continueBtn.click();
		return this;
	}
	
	public CheckOutPage ClickOnSelectCountryDD(){
		 WebElement ele = (new WebDriverWait(driver,10)).until(ExpectedConditions.visibilityOf(selectCountryDD));
		 ele.click();
		 return this;
	}
	
	public CheckOutPage SelectCountry(String country)
	{
		Select dropdown=new Select(selectCurrentCountry);
		dropdown.selectByVisibleText(country);
		return this;
	}
	
	public CheckOutPage ClickCalculateBtn()
	{
		CalculateBtn.click();
		return this;
	}
	
	public CheckOutPage AddEmailAddress(String email){
		emailAddress.sendKeys(email);
		return this;
	}
	
	public CheckOutPage EnterFirstName(String firstName){
		fname.sendKeys(firstName);
		return this;
	}
	
	public CheckOutPage AddLastName(String lastName){
		lname.sendKeys(lastName);
		return this;
	}	
	
	public CheckOutPage AddAddress(String addr){
		address.sendKeys(addr);
		return this;
	}
	
	public CheckOutPage AddCity(String cityname){
		city.sendKeys(cityname);
		return this;
	}
	
	public CheckOutPage AddState(String statename){
		state.sendKeys(statename);
		return this;
	}
	
	public CheckOutPage SelectRegionSelectCountryDD(String country){
		regionSelectCountryDD.click();
		Select dropdown=new Select(reqionSelectCountry);
		dropdown.deselectByVisibleText(country);
		return this;
	}
	
	public CheckOutPage AddPhone(String phnumber){
		phone.sendKeys(phnumber);
		return this;
	}
	
	public BillingPage ClickOnPurchaseBtn(){
		purchaseBtn.click();
		return new BillingPage(driver);
		
	}
	
	public Float getTotalShippingPrice(){
		String Tshipping=TotalShipping.get(1).getText();
		System.out.println(Tshipping);
		String total=Tshipping.split("\\$")[1];
		return Float.parseFloat(total);
	}
	
	public float getTotalPrice(){
		String Tprice=totalPrice.getText();
		System.out.println(Tprice);
		String total=Tprice.split("\\$")[1];
		return Float.parseFloat(total);
	}
	
	public int getcartitemcount(){
		System.out.println(countofcartItems.getText());
		return Integer.parseInt(countofcartItems.getText());
	}
	
	public CheckOutPage RemoveItemsFromCart(int index){
	     List<WebElement> rows = cartTable.findElements(By.className("wpsc_product_remove"));
	     System.out.println(rows.size());
	     rows.get(index).findElement(By.name("submit")).submit();
	     return this;
	}
	 

}
