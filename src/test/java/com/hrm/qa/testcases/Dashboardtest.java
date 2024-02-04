package com.hrm.qa.testcases;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hrm.qa.pages.Dashboardpage;
import com.hrm.qa.pages.Loginpage;
import com.hrm.qa.testbase.Testbase;

public class Dashboardtest extends Testbase {
	Loginpage loginpage;
	Dashboardpage dashboardpage;

	public Dashboardtest() {
		super();
	}

	@BeforeMethod
	public void Dashboardsetup() {
		initalization();
		loginpage = new Loginpage();
		dashboardpage = loginpage.login(pro.getProperty("username"), pro.getProperty("password"));

	}

	@Test(priority = 1)
	public void verifydashboardtitle() {
		boolean flag = dashboardpage.vadliateDashboardtitle();
		Assert.assertTrue(flag);
		((JavascriptExecutor) driver).executeScript("alert('vadliateDashboardtitle!')");
		driver.switchTo().alert().accept();
	}

	@Test(priority = 2)
	public void navadminpg() {
		dashboardpage.clickonadminpage();
		((JavascriptExecutor) driver).executeScript("alert('Adminpage entered!')");
		driver.switchTo().alert().accept();
	}

	@AfterMethod
	public void close() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}

}
