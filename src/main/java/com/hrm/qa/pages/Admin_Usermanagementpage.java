package com.hrm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrm.qa.testbase.Testbase;

public class Admin_Usermanagementpage extends Testbase {
	String status;
	String role;
	@FindBy(xpath = "//h6[normalize-space()='Admin']")
	WebElement Admintitle;
	
	
	@FindBy(xpath = "//button[normalize-space()='Add']")
	WebElement adduser;
	
	@FindBy(xpath="(//label[normalize-space()='User Role']/following::div[@tabindex='0'])[1]")
	WebElement userroleclick;
	@FindBy(xpath="//form/descendant::span[normalize-space()='Admin']")
	WebElement userroleselected;
	@FindBy(xpath="(//label[normalize-space()='User Role']/following::div[@tabindex='0'])[2]")

	WebElement statusclick;
	@FindBy(xpath="//form/descendant::span[normalize-space()='Enabled']")
	WebElement statusselected;
	
	@FindBy(xpath="(//label[text()='Employee Name']/following::input)[1]")
	WebElement Employeename;
	
	@FindBy(xpath="(//label[text()='Employee Name']/following::input)[2]")
	WebElement Username;
	@FindBy(xpath="(//label[text()='Employee Name']/following::input)[3]")
	WebElement pd;
	@FindBy(xpath="(//label[text()='Employee Name']/following::input)[4]")
	WebElement cpd;
	@FindBy(xpath="//button[@type='submit']")
	WebElement submit;
	
	//NAVIGATION XPATHS
	@FindBy(linkText="Nationalities")
	WebElement Nationalitypage;
	
	@FindBy(xpath="//li[normalize-space()='Organization']/following::li/span[normalize-space()='Qualifications']")
	WebElement qualification;
	
	@FindBy(xpath="//li[normalize-space()='Organization']/following::li/a[normalize-space()='Skills']")
	WebElement skillpage;
	
	@FindBy(xpath="//span[normalize-space()='Job']")
	WebElement jobpage;
	@FindBy(linkText="Job Titles")
	WebElement Jobtitlepage;
	
	public Admin_Usermanagementpage() {
		PageFactory.initElements(driver, this);
	}
	
	public String validationTitle() {
		return Admintitle.getText();
		
	}
	

	public void addstatus() {
		adduser.click();
	}
	
	public void addingdetails(String employeename,String username,String Pd,String Cpd) {		
		userroleclick.click();
		userroleselected.click();
		statusclick.click();
		statusselected.click();
		Employeename.sendKeys(employeename);
		Username.sendKeys(username);
		pd.sendKeys(Pd);
		cpd.sendKeys(Cpd);	
		submit.click();
	}
	public Nationalitiespage navnationality() {
		Nationalitypage.click();
		return new Nationalitiespage();		
		}
	
	public Qualification_skillspage navskillpage() {
		qualification.click();
		skillpage.click();
		return new Qualification_skillspage();
		
	}
	
	public job_jobtitlepage navjobpage() {
		jobpage.click();
		Jobtitlepage.click();
		return new job_jobtitlepage();
		
	}
	
	
}
