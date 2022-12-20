package TestNgScreenshots;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import TestNg.DriverExtensions;

public class TestNGExample_Screenshot_StaticWay extends DriverExtensions {

	File screenshot;
	
	@BeforeSuite
	public void launchURL() throws IOException {

		System.out.println("I am in BeforeSuite");

		launchBrowser("edge");

		driver.get("https://www.facebook.com/");
		
		screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(screenshot, new File(
				"C:\\Users\\himaj\\eclipse-workspace\\12thOct2022\\SaagTesting.RealProject\\src\\test\\java\\ScreenshotImages\\launchChrome.png"));

	}

	@BeforeClass
	public void maximizeBrowser() throws IOException {

		System.out.println("I am in BeforeClass");

		driver.manage().window().maximize();
		
		FileUtils.copyFile(screenshot, new File(
				"C:\\Users\\himaj\\eclipse-workspace\\12thOct2022\\SaagTesting.RealProject\\src\\test\\java\\ScreenshotImages\\Maximize.png"));

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
	public void enterUsername() throws IOException {		

		driver.findElement(By.xpath("//input[@name='email']")).clear();
		
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("Saag");
		
		FileUtils.copyFile(screenshot, new File(
				"C:\\Users\\himaj\\eclipse-workspace\\12thOct2022\\SaagTesting.RealProject\\src\\test\\java\\ScreenshotImages\\Username.png"));

		
		driver.findElement(By.xpath("//input[@name='pass']")).clear();
		
		driver.findElement(By.xpath("//input[@name='pass']")).sendKeys("Testing");
		
		FileUtils.copyFile(screenshot, new File(
				"C:\\Users\\himaj\\eclipse-workspace\\12thOct2022\\SaagTesting.RealProject\\src\\test\\java\\ScreenshotImages\\Password.png"));

	}

	@AfterSuite
	public void closeBrowser() {

		System.out.println("I am in AfterSuite method");

		driver.close();
	}
}
