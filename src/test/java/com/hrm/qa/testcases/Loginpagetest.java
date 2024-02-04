package com.hrm.qa.testcases;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hrm.qa.pages.Dashboardpage;
import com.hrm.qa.pages.Loginpage;
import com.hrm.qa.testbase.Testbase;

public class Loginpagetest extends Testbase {
	Loginpage loginpage;
	Dashboardpage dashboardpage;

	public Loginpagetest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		initalization();
		loginpage = new Loginpage();

	}

	@Test(priority = 1)
	public void LoginTitleTest() {
		String title = loginpage.validatehrmtitle();
		Assert.assertEquals(title, "OrangeHRM", "title not matched");
		((JavascriptExecutor) driver).executeScript("alert('LoginTitleTest!')");
		driver.switchTo().alert().accept();
	}

	@Test(priority=2)
	public void hrmlogoTest() {
		boolean flag = loginpage.validatehrmlogo();
		Assert.assertTrue(flag);
		((JavascriptExecutor) driver).executeScript("alert('hrmlogoTest!')");
		driver.switchTo().alert().accept();
	}

	@Test(priority=3)
	public void loginTest() throws InterruptedException {

		dashboardpage = loginpage.login(pro.getProperty("username"), pro.getProperty("password"));
		Thread.sleep(3000);
		((JavascriptExecutor) driver).executeScript("alert('homepage entered!')");
		driver.switchTo().alert().accept();
	}

	@AfterMethod
	public void quite() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}

}
