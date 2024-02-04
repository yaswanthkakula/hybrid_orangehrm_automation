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
import com.hrm.qa.pages.job_jobtitlepage;
import com.hrm.qa.testbase.Testbase;
import com.hrm.qa.utilies.ExcelApiTest4;

public class job_jobtitletest extends Testbase {

	Loginpage loginpage;
	Dashboardpage homepage;
	Admin_Usermanagementpage Adminpage;
	job_jobtitlepage jobpage;

	 Map<String, HashMap<String, String>> Datatable = new HashMap<String, HashMap<String, String>>();
	
	 
	 public job_jobtitletest() {
		super();
	}

	@BeforeMethod
	public void jobtitletestsetup() {
		initalization();
		loginpage = new Loginpage();
		homepage = loginpage.login(pro.getProperty("username"), pro.getProperty("password"));
		Adminpage = homepage.clickonadminpage();
		jobpage = Adminpage.navjobpage();
		((JavascriptExecutor) driver).executeScript("alert('navigated to job page!')");
		driver.switchTo().alert().accept();
	}

	@Test(priority = 1)
	public void jobtitlevalidation() {
		String title = jobpage.jobTitlepgverify();
		Assert.assertEquals(title, "Add Job Title", "title not matched");
		((JavascriptExecutor) driver).executeScript("alert('jobtitlevalidation!')");
		driver.switchTo().alert().accept();
	}

	@Test(priority=2)
	public void addjobtitle() throws Exception {
		ExcelApiTest4 eat = new ExcelApiTest4();

		Datatable = eat.getDataTable(
				"D:\\selenium pratice\\Selenium Automation for open source Orange HRM Website\\src\\main\\java\\com\\hrm\\qa\\testdata\\testdt.xlsx",
				"Sheet1");
		String jobtitle = Datatable.get("TC02").get("jobTitle");
		String jobDesc = Datatable.get("TC02").get("jobDesc");
		String jobNote = Datatable.get("TC02").get("jobNote");
		((JavascriptExecutor) driver).executeScript("alert('addjobtitle!')");
		driver.switchTo().alert().accept();
		jobpage.addjobtitle(jobtitle, jobDesc, jobNote);

	}

	@AfterMethod
	public void teardown() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}

}
