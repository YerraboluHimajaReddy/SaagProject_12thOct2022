package Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DriverExtensions {

	public WebDriver driver;

	public void launchBrowser(String browserName) {

		if (browserName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();

		} else if (browserName.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();

		}
		else if (browserName.equalsIgnoreCase("safari")) {
			driver = new SafariDriver();
		}
	}
	
	public void launchUrl() {
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}
}
