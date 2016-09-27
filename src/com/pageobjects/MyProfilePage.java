package com.pageobjects;


import java.util.List;

import javax.management.loading.PrivateClassLoader;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyProfilePage {
	private WebDriver driver;
	
	public MyProfilePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="wp-admin-bar-site-name")
	WebElement homelink;
	
	public BasePage ClickHome(){
		homelink.click();
		return new BasePage(driver);
	}
	

}
