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

import Methods.ForgotPasswordMethods;
import Pages.LoginPage;

public class ForgotPassword {
	
	public WebDriver driver;
	
	LoginPage lp;
	
	ForgotPasswordMethods fpm;
	
	@BeforeSuite
	public void launchURL() {
		
		System.out.println("I am in BeforeSuite");
		
	    driver = new ChromeDriver();
	    
	    lp=new LoginPage(driver);
	    
	    fpm=new ForgotPasswordMethods(driver);

		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

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
	
	@Test(priority = 1)
	public void clickForgotpassword() {
		
		System.out.println("i am in clickForgotpassword method");
		
		lp.clickForgortPassword();
	}
	
	@Test(priority = 2)
	public void enter_Username() {
		
		System.out.println("i am in enterUsername method");
		
		fpm.enterUsername();
	}
	
	@Test(priority = 3)
	public void clickCancel() {
		
		System.out.println("i am in clickForgotpassword method");
		
		fpm.clickCancel();
	}
	
	@AfterSuite
	public void closeBrowser() {
		
		System.out.println("I am in AfterSuite method");
				
		driver.close();
	}
}
