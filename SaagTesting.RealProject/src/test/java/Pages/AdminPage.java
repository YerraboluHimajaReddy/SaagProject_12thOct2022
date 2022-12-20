package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AdminPage {

	WebDriver driver;

	public AdminPage(WebDriver driver) {

		this.driver = driver;
	}

	@CacheLookup
	@FindBy(xpath ="//span[text()='User Management ']")
	public WebElement userManagemenet_Button;

	public void clickUserManagemenet() {

		userManagemenet_Button.click();
	}

}
