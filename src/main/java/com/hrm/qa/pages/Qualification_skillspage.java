package com.hrm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrm.qa.testbase.Testbase;

public class Qualification_skillspage extends Testbase{
	@FindBy(xpath="//button[normalize-space()='Add']")
	WebElement addskills;
	@FindBy(xpath="//div//label[text()='Name']/following::input")
	WebElement Skillname;
	@FindBy(xpath="//div//label[text()='Description']/following::textarea")
	WebElement Skilldes;
	@FindBy(xpath="//div//button[@type='submit']")
	WebElement submit;
	@FindBy(xpath="//h6[text()='Skills']")
	WebElement skilltitlecheck;
	
	
	public boolean validateskilltitle() {
		
		return skilltitlecheck.isDisplayed();
		
	}
	public Qualification_skillspage() {
		PageFactory.initElements(driver, this);
	}
	
	public void addingskill(String Skillna,String Skilldesc) {
		addskills.click();
		Skillname.sendKeys(Skillna);
		Skilldes.sendKeys(Skilldesc);
		
	}
	

}
