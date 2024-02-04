package com.hrm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrm.qa.testbase.Testbase;

public class Dashboardpage extends Testbase {

	@FindBy(xpath = "//h6[normalize-space()='Dashboard']")
	WebElement Dashboardtitle;
	@FindBy(linkText="Admin")
	WebElement Adminpagelink;
	
	public Dashboardpage() {
		PageFactory.initElements(driver, this);
	}
	public boolean vadliateDashboardtitle() {
		return Dashboardtitle.isDisplayed();

	}
	public Admin_Usermanagementpage clickonadminpage() {
		Adminpagelink.click();
		return new Admin_Usermanagementpage();
	}

	

	

//	@FindBy(xpath = "")
//	WebElement PIMlink;
//
//	@FindBy(xpath = "")
//	WebElement Leavelink;
//
//	@FindBy(xpath = "")
//	WebElement Timelink;
//
//	@FindBy(xpath = "")
//	WebElement Recruitmentlink;
//
//	@FindBy(xpath = "")
//	WebElement MyInfolink;
//
//	@FindBy(xpath = "")
//	WebElement Performancelink;
//
//	@FindBy(xpath = "")
//	WebElement Dashboardlink;
//
//	@FindBy(xpath = "")
//	WebElement Directorylink;
//
//	@FindBy(xpath = "")
//	WebElement Maintenancelink;
//
//	@FindBy(xpath = "")
//	WebElement Claimlink;
//
//	@FindBy(xpath = "")
//	WebElement Buzzlink;

}
