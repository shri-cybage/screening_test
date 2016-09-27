package com.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {
	private WebDriver driver;
	
	@FindBy(id="log")
	WebElement uname;
	
	@FindBy(id="pwd")
	WebElement pword;
	
	@FindBy(id="login")
	WebElement loginbtn;
	
	@FindBy(partialLinkText="Your Details")
	WebElement mydetails;
	
	@FindBy(id="wpsc_checkout_form_5")
	WebElement citydetails;
	
	@FindBy(partialLinkText="Log out")
	WebElement logoutbtn;
	
	@FindBy(name="submit")
	WebElement saveprofilebtn;
	

	public MyAccountPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public MyAccountPage clickYourDetails(){
		mydetails.click();
		return this;	
	}
	
	public MyAccountPage addUserName(String username) {
		uname.sendKeys(username);
		return this;	
	}
	
	public MyAccountPage addPassWord(String pwd) {
		pword.sendKeys(pwd);
		return this;
	}
	
	public MyAccountPage clickLogin() {
		loginbtn.click();
		return this;
		
	}
	
	public MyAccountPage UpdateCity(String newCity){
		citydetails.clear();
		citydetails.sendKeys(newCity);
		return this;
	}
	
	public String getCity(){
		System.out.println(citydetails.getAttribute("value"));
		return citydetails.getAttribute("value");
			
	}
	
	public LoginPage clickLogout(){
		logoutbtn.click();
		return new LoginPage(driver);
	}
	
	public MyAccountPage clickSaveProfile(){
		saveprofilebtn.click();
		return this;
		
	}
	
	

}
