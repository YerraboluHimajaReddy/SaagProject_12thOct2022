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
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import TestNg.DriverExtensions;

public class TestNGExample_DataProviderAnnotation extends DriverExtensions {

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
	
	@DataProvider(name="LoginData")
	public Object[][] facebookDetails(){
		
		Object[][] values=new Object[4][2];
		
		values[0][0]="Koteswarao@gmail.com";
		values[0][1]="Koteswarrao";
		
		values[1][0]="Pavan@gmail.com";
		values[1][1]="pavan";
		
		values[2][0]="sarika@gmail.com";
		values[2][1]="sarika";
		
		values[3][0]="charmila@gmail.com";
		values[3][1]="Charmila";
		
		return values;
	}

	@Test(dataProvider = "LoginData" )
	public void enterUsername(String username, String password) {		

		driver.findElement(By.xpath("//input[@name='email']")).clear();
		
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys(username);
		
		driver.findElement(By.xpath("//input[@name='pass']")).clear();
		
		driver.findElement(By.xpath("//input[@name='pass']")).sendKeys(password);
	}

	@AfterSuite
	public void closeBrowser() {

		System.out.println("I am in AfterSuite method");

		//driver.close();
	}
}
