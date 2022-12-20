package TestNgAttributes;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import TestNg.DriverExtensions;

public class TestNGExample_Description extends DriverExtensions{
		
	@BeforeSuite
	public void launchURL() {
		
		System.out.println("I am in BeforeSuite");
		
	    launchBrowser("edge");

	    launchUrl();

	}
	
	@BeforeClass
	public void maximizeBrowser() {
		
		System.out.println("I am in BeforeClass");

		driver.manage().window().maximize();
	}

	@BeforeMethod
	public void waitBeforeMethod() {
		
		System.out.println("I am in BeforeMethod");

		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

	}
	
	@AfterMethod
	public void waitAfterMethod() {
		
		System.out.println("I am in AfterMethod");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

	}
	
	@Test(priority = 1, description = "This method is used to enter username in the login name")
	public void enterUsername() {
		
		System.out.println("i am in enterUsername method");
		
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
	}
	
	@Test(priority = 2, description = "This method is used to enter username in the Password name")
	public void enterPassword() {
		
		System.out.println("i am in enterPassword method");
		
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
	}
	
	@Test(priority = 3, description = "This method is used to click on login button")
	public void clickLogin() {
		
		System.out.println("i am in clickLogin method");
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}
	
	@AfterSuite
	public void closeBrowser() {
		
		System.out.println("I am in AfterSuite method");
				
		driver.close();
	}
}
