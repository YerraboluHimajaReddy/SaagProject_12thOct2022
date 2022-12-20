package SeleniumIntro;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium_ChromeBrowser {

	public static void main(String[] args) {
				
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.facebook.com/");
		
	}

}
