package SeleniumIntro;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Selenium_EdgeBrowser {

	public static void main(String[] args) {
		
		
		WebDriver driver=new EdgeDriver(); // edge browser
		
		driver.get("https://www.facebook.com/");
		
	}

}
