package com.hrm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrm.qa.testbase.Testbase;

public class Nationalitiespage extends Testbase{
	
	

	@FindBy(xpath="//button[normalize-space()='Add']")
	WebElement addNationality;
	@FindBy(xpath="//label[text()='Name']/following::div/input")
	WebElement addinput;
	@FindBy(xpath="//form/div/child::button[@type='submit']")
	WebElement submit;
	@FindBy(xpath="//h6[normalize-space()='Nationalities']")
	WebElement nationalityTitle;
	
public Nationalitiespage(){
		
		PageFactory.initElements(driver, this);
	}
	
public String validatenationalitytitle() {
	return nationalityTitle.getText();
	
}
public void addnationality(String nationalityTxt) {
	addNationality.click();
	addinput.sendKeys(nationalityTxt);
	submit.click();
}

	
}
