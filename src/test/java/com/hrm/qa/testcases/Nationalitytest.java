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
import com.hrm.qa.pages.Nationalitiespage;
import com.hrm.qa.testbase.Testbase;
import com.hrm.qa.utilies.ExcelApiTest4;

public class Nationalitytest extends Testbase{
	Loginpage loginpage;
	Admin_Usermanagementpage admin;
	Dashboardpage navpg;
	Nationalitiespage nationality;
	Map<String, HashMap<String, String>> Datatable = new HashMap<String, HashMap<String, String>>();

	public Nationalitytest() {
		super();
	}
	
	@BeforeMethod
	public void Nationalitysetup() {
		initalization();
		loginpage=new Loginpage();
		navpg=loginpage.login(pro.getProperty("username"), pro.getProperty("password"));
		admin=navpg.clickonadminpage();
		nationality=admin.navnationality();
		((JavascriptExecutor) driver).executeScript("alert('navigated to nationality page !')");
		driver.switchTo().alert().accept();
	}
	@Test(priority=1)
	public void nationalitytitlevalidtaion() {
		String title=nationality.validatenationalitytitle();
		Assert.assertEquals(title, "Nationalities","title not match");
		((JavascriptExecutor) driver).executeScript("alert('nationalitytitlevalidtaion!')");
		driver.switchTo().alert().accept();
	}
	
	
	
	@Test(priority = 2)
	public void addnationality() throws Exception {
		((JavascriptExecutor) driver).executeScript("alert('addnationality!')");
		driver.switchTo().alert().accept();
		ExcelApiTest4 eat = new ExcelApiTest4();
		
		Datatable=eat.getDataTable("D:\\selenium pratice\\Selenium Automation for open source Orange HRM Website\\src\\main\\java\\com\\hrm\\qa\\testdata\\testdt.xlsx", "Sheet1");
		String Nationalitytxt = Datatable.get("TC01").get("Nationality_txt");
		
		nationality.addnationality(Nationalitytxt);
		
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
		
	}
	

}
