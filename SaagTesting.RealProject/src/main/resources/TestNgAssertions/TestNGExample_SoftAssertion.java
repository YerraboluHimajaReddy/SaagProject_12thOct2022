package TestNgAssertions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import TestNg.DriverExtensions;

public class TestNGExample_SoftAssertion extends DriverExtensions {

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

	@Test
	public void verifyTitle() {

		SoftAssert ass=new SoftAssert();
		
		String expectedTitle = "Charmila";

		String actualTitle = driver.getTitle();

		ass.assertEquals(actualTitle, expectedTitle , " Both are not same ");

		System.out.println("====================================");
	}

	@Test(dependsOnMethods = "verifyTitle")
	public void enterUsername() {

		System.out.println("i am in enterUsername method");

		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
	}

	@Test(dependsOnMethods = "enterUsername")
	public void enterPassword() {

		System.out.println("i am in enterPassword method");

		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
	}

	@Test(dependsOnMethods = "enterPassword")
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
