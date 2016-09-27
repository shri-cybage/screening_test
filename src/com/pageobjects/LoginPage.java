package com.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	
	private WebDriver driver;
	@FindBy(id="user_login")
	WebElement username;
	
	@FindBy(id="user_pass")
	WebElement password;
	
	@FindBy(id="wp-submit")
	WebElement Loginbtn;

	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public MyProfilePage DoLogin(String uname,String pwd){
		username.sendKeys(uname);
		password.sendKeys(pwd);
		Loginbtn.click();
		return new MyProfilePage(driver);

	}

}
