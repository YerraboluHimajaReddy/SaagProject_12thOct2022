package Listeners;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import Pages.LoginPage;

public class LoginTest extends Example {
	
	public WebDriver driver;
	
	LoginPage lp;
	
	@BeforeSuite
	public void launchURL() {
		
		System.out.println("I am in BeforeSuite");
		
	    driver = new ChromeDriver();
	    
	    lp=new LoginPage(driver);

	    beforeNavigateTo("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login", driver);
	    
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

	    afterNavigateTo("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login", driver);

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
	public void enter_Username() {
		
		System.out.println("i am in enterUsername method");
		
		lp.enterUsername();
	}
	
	@Test(priority = 2)
	public void enter_password() {
		
		System.out.println("i am in enterPassword method");
		
		lp.enterPassword("admin123");
	}
	
	@Test(priority = 3)
	public void clickLogin() {
		
		System.out.println("i am in clickLogin method");
		
		WebElement WebElement=driver.findElement(By.xpath("//button[@type='submit']"));
		
		beforeClickOn(WebElement,driver);
		
		lp.clickLogin();
		
		afterClickOn(WebElement, driver);

	}
	
	@AfterSuite
	public void closeBrowser() {
		
		System.out.println("I am in AfterSuite method");
				
		driver.close();
	}
}
