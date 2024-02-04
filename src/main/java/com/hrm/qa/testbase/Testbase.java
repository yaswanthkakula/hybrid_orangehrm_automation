package com.hrm.qa.testbase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Testbase {
	public static WebDriver driver;
	public static Properties pro;
	FileInputStream fio;

	public Testbase() {
		try {
			pro = new Properties();
			String projectPath = "D:\\selenium pratice\\Selenium Automation for open source Orange HRM Website";
			String configFilePath = projectPath + "\\src\\main\\java\\com\\hrm\\qa\\config\\config.properties";
			fio = new FileInputStream(configFilePath);
			pro.load(fio);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void initalization() {
		String browsername = pro.getProperty("browser");
		String url = pro.getProperty("url");
		if (browsername.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
			 ChromeOptions options = new ChromeOptions();
			 options.setHeadless(false);
			 WebDriver driver = new ChromeDriver(options);
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

}
