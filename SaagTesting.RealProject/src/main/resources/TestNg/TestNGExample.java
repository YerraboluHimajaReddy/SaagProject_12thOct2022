package TestNg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestNGExample {

	@Test
	public void verify() {

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.facebook.com/");
		
		driver.close();
	}
}
