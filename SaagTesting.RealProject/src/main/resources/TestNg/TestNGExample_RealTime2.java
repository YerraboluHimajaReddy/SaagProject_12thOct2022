package TestNg;

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

public class TestNGExample_RealTime2 {
	
	public WebDriver driver;
	
	@BeforeSuite
	public void launchURL() {
		
		System.out.println("I am in BeforeSuite");
		
	    driver = new ChromeDriver();

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
	public void enterUsername() {
		
		System.out.println("i am in enterUsername method");
		
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
	}
	
	@Test(priority = 2)
	public void enterPassword() {
		
		System.out.println("i am in enterPassword method");
		
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
	}
	
	@Test(priority = 3)
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
