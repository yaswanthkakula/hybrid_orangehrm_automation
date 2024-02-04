package com.hrm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrm.qa.testbase.Testbase;


public class Loginpage extends Testbase{
	@FindBy(xpath="//input[@name='username']")
	WebElement username;
	@FindBy(xpath="//input[@name='password']")
	WebElement password;
	@FindBy(xpath="//div[@class='oxd-form-actions orangehrm-login-action']/child::button")
	WebElement loginbt;
	@FindBy(xpath="//div[@class='orangehrm-login-branding']")
	WebElement hrmlogo;
	
	public Loginpage() {
		PageFactory.initElements(driver, this);
	}
	
	public String validatehrmtitle() {
		return driver.getTitle();
		
	}
	
	public boolean validatehrmlogo() {
	return hrmlogo.isDisplayed();
	}
	
	public Dashboardpage login(String un,String pd) {
		username.sendKeys(un);
		password.sendKeys(pd);
		loginbt.click();
		return new Dashboardpage();
	}

}
