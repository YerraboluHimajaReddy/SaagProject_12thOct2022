package Tests;

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

import Tests.DriverExtensions;

public class TestNGExample_InvocationCount extends DriverExtensions {

	@BeforeSuite
	public void launchURL() {

		System.out.println("I am in BeforeSuite");

		launchBrowser("edge");

		driver.get("https://www.facebook.com/");

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

	@Test(invocationCount = 10)
	public void enterUsername() {

		//driver.findElement(By.xpath("//input[@name='email']")).clear();
		
		System.out.println("i am in enterUsername method");

		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("Admin");
	}

	@Test(dependsOnMethods = "enterUsername")
	public void enterPassword() {

		System.out.println("i am in enterPassword method");

		driver.findElement(By.xpath("//input[@name='pass']")).sendKeys("admin123");
	}

	@AfterSuite
	public void closeBrowser() {

		System.out.println("I am in AfterSuite method");

		driver.close();
	}
}
