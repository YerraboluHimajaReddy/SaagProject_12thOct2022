package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPassword {

	WebDriver driver;

	public ForgotPassword(WebDriver driver) {

		this.driver = driver;
	}

	// 2nd way

	public By username_textBox = By.xpath("//input[@name='username']");

	public By cancel_button = By.xpath("//button[@type='button']");

	public By resetPassword_button = By.xpath("//button[@type='submit']");

}
