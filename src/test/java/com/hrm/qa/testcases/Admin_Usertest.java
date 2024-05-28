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
import com.hrm.qa.testbase.Testbase;
import com.hrm.qa.utilies.ExcelApiTest4;


public class Admin_Usertest extends Testbase{
	Loginpage loginpage;
	Dashboardpage dashboardpage;
	Admin_Usermanagementpage userpage;
	Map<String, HashMap<String, String>> Datatable = new HashMap<String, HashMap<String, String>>();

	
	public Admin_Usertest(){
		super();//testbase
	}

	@BeforeMethod
	public void usersetup() {
		initalization();
		loginpage=new Loginpage();
		dashboardpage=loginpage.login(pro.getProperty("username"), pro.getProperty("password"));
		userpage=dashboardpage.clickonadminpage();
	}
	@Test(priority = 1)
	public void validateAdmintitle() {
		String title=userpage.validationTitle();
		Assert.assertEquals(title, "Admin","not matched");
		((JavascriptExecutor) driver).executeScript("alert('Adminpage entered!')");
		driver.switchTo().alert().accept();
	}
	
	@Test(priority=2)
	
	public void adduserdata() throws Exception {
		ExcelApiTest4 eat = new ExcelApiTest4();

		Datatable = eat.getDataTable(
				"D:\\selenium pratice\\Selenium Automation for open source Orange HRM Website\\src\\main\\java\\com\\hrm\\qa\\testdata\\testdt.xlsx",
				"Sheet1");
		String employeName = Datatable.get("TC04").get("employeName");
		String username = Datatable.get("TC04").get("username");
		String password = Datatable.get("TC04").get("password");
		String Con_pass = Datatable.get("TC04").get("Con_pass");
		
		userpage.addstatus();
		userpage.addingdetails(employeName,  username,password,Con_pass);
	}
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	
}
