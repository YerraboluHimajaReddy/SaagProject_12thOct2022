package ExtentReports;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Pages.AdminPage;
import Pages.HomePage;
import Pages.LoginPage;

public class ExtentReportExample2 {

	public WebDriver driver;

	LoginPage lpm;

	HomePage hp;

	AdminPage ap;

	public static ExtentReports report;

	public static ExtentTest test;


	@BeforeSuite
	public void startTest() {

		report = new ExtentReports(System.getProperty("user.dir") + "\\Test.html");
		
		test = report.startTest("OrangeHRM");

	}

	@BeforeClass
	public void launchBrowser() {

		System.out.println("In before Suite");
		
		driver = new ChromeDriver();

		lpm = new LoginPage(driver);

		hp = PageFactory.initElements(driver, HomePage.class);

		ap = PageFactory.initElements(driver, AdminPage.class);

		driver.manage().window().maximize();

		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

		System.out.println(driver.getTitle());
	}

	@BeforeMethod
	public void getTitle() {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
	}

	@Test(priority = 0)
	public void loginToOrangeHRM() {

		lpm.enterUsername();
		
		lpm.enterPassword("admin123");
		
		lpm.clickLogin();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
		
		System.out.println(driver.getTitle());
		
		if(driver.getTitle().equalsIgnoreCase("OrangeHRM")) {	
			
			test.log(LogStatus.PASS, "Title is same");
			
		}else {
			
			test.log(LogStatus.FAIL, "Title is not same");

		}	

	}

	@Test(priority = 1)
	public void clickUserManagement() {
		
		hp.clickAdmin();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));

		ap.clickUserManagemenet();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));

	}

	@Test(priority = 2)
	public void clickLogout() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
		
		System.out.println(driver.getTitle());
		
		String expected="OrangeHRM";
		
		String actual=driver.getTitle();
		
		if(actual.equalsIgnoreCase(expected)) {	
			
			test.log(LogStatus.ERROR, "Title is same : " +actual);
			
		}else {
			
			test.log(LogStatus.FAIL, "Title is not same" + expected + " and " + actual);

		}
	}
	
	@AfterMethod
	public void getTitle1() {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
	}

	
	@AfterClass
	public void endTest() {
		
		report.endTest(test);
		
		report.flush();
	}

	@AfterSuite
	public void closeBrowser() {

		driver.quit();
	}

}
