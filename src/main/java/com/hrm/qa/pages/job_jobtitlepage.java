package com.hrm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrm.qa.testbase.Testbase;

public class job_jobtitlepage extends Testbase{

	@FindBy(xpath="//h6[normalize-space()='Job Titles']/following-sibling::div/button")
	WebElement addjob;
	
	@FindBy(xpath="//h6[normalize-space()='Add Job Title']")
	WebElement jobtitleverfy;
	@FindBy(xpath="(//div/descendant::input)[2]")
	WebElement jobTitle;
	

	@FindBy(xpath="//form/descendant::div/child::textarea[@placeholder='Type description here']")
	WebElement jobDescr;
	

	@FindBy(xpath="//div/descendant::input[@type='file']")
	WebElement jobspecifi;
	
	@FindBy(xpath="//form/descendant::div/child::textarea[@//form/descendant::div/child::textarea[@placeholder='Add note']")
	WebElement jobnote;
	
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement svbt;
	
	public job_jobtitlepage() {
		PageFactory.initElements(driver, this);
	}
	
	public String jobTitlepgverify() {
		addjob.click();
		return jobtitleverfy.getText();		
	}
	public void addjobtitle(String addtitle,String adddesc,String addnote) {
		addjob.click();
		jobTitle.sendKeys(addtitle);
		jobDescr.sendKeys(adddesc);
		jobnote.sendKeys(addnote);
		svbt.click();
	}
	
	
}
