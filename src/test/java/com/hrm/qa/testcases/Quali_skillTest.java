package com.hrm.qa.testcases;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hrm.qa.pages.Admin_Usermanagementpage;
import com.hrm.qa.pages.Dashboardpage;
import com.hrm.qa.pages.Loginpage;
import com.hrm.qa.pages.Qualification_skillspage;
import com.hrm.qa.testbase.Testbase;
import com.hrm.qa.utilies.ExcelApiTest4;

public class Quali_skillTest extends Testbase {

	Loginpage loginpage;
	Dashboardpage homepage;
	Admin_Usermanagementpage admin;
	Qualification_skillspage skills;
	Map<String, HashMap<String, String>> Datatable = new HashMap<String, HashMap<String, String>>();

	public Quali_skillTest() {
		super();
	}

	@BeforeMethod
	public void skillsetup() {
		initalization();
		loginpage = new Loginpage();
		homepage = loginpage.login(pro.getProperty("username"), pro.getProperty("password"));
		admin = homepage.clickonadminpage();
		skills = admin.navskillpage();
	}

	@Test(priority = 1)
	public void validateskillpage() {
		boolean flag = skills.validateskilltitle();
		Assert.assertTrue(flag);
		((JavascriptExecutor) driver).executeScript("alert('validateskillpage!')");
		driver.switchTo().alert().accept();
		
	}

	@Test(priority = 2)
	public void addskills() throws Exception {
		((JavascriptExecutor) driver).executeScript("alert('addskills!')");
		driver.switchTo().alert().accept();
		ExcelApiTest4 eat = new ExcelApiTest4();

		Datatable = eat.getDataTable(
				"D:\\selenium pratice\\Selenium Automation for open source Orange HRM Website\\src\\main\\java\\com\\hrm\\qa\\testdata\\testdt.xlsx",
				"Sheet1");
		String skillname = Datatable.get("TC03").get("skillName");
		String skilldesc = Datatable.get("TC03").get("skillDesc");
		skills.addingskill(skillname, skilldesc);

	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
