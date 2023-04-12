package com.crm.testscript;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class CreateLead {
	static {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}
	@Test
	public static void open() throws IOException {
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		FileInputStream fis=new FileInputStream("./data/commondata.property");
		Properties p=new Properties();
		p.load(fis);
		String url=p.getProperty("url");
		driver.get(url);
		String un=p.getProperty("username");
		driver.findElement(By.id("userName")).sendKeys(un);
		String pwd=p.getProperty("password");
		driver.findElement(By.id("passWord")).sendKeys(pwd);
		driver.findElement(By.xpath("//input[@title='Sign In']")).click();
		driver.findElement(By.partialLinkText("Leads")).click();
		driver.findElement(By.xpath("//input[@value='New Lead']")).click();
		WebElement fnlistbox = driver.findElement(By.name("property(saltName)"));
		Select s=new Select(fnlistbox);
		s.selectByValue("Mr.");
		driver.findElement(By.name("property(First Name)")).sendKeys("Rohit");
		driver.findElement(By.name("property(Company)")).sendKeys("xyz");
		driver.findElement(By.name("property(Last Name)")).sendKeys("Sharma");
		driver.findElement(By.xpath("(//input[@type='submit'])[2]")).click();
		driver.findElement(By.partialLinkText("Leads")).click();
		

	}
}
