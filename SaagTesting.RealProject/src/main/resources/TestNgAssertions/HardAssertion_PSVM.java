package TestNgAssertions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class HardAssertion_PSVM {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\himaj\\Desktop\\12th OCTBatch_Softwares\\chromedriver_win32 (3)\\chromedriver.exe");

		WebDriver driver = new ChromeDriver(); // edge browser

		driver.manage().window().maximize();

		driver.get("https://testautomationpractice.blogspot.com/");

		driver.navigate().to("https://www.facebook.com/");
		
		String expectedTitle="Facebook – log in or sign up";
		
		String actualTitle= driver.getTitle();
		
		Assert.assertEquals(actualTitle, expectedTitle);

		driver.navigate().back();

		driver.navigate().forward();

		driver.close();

	}

}
