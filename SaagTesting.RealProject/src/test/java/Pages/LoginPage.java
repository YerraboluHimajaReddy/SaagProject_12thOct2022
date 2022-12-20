package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {

		this.driver = driver;
	}

	// 1st way

	private By username_textBox = By.xpath("//input[@name='username']");

	private By password_textBox = By.xpath("//input[@name='password']");

	public By login_button = By.xpath("//button[@type='submit']");

	private By forgortPassword_Link = By.xpath("//p[text()='Forgot your password? ']");

	public void enterUsername() {

		driver.findElement(username_textBox).sendKeys("Admin");
	}

	public void enterPassword(String password) {

		driver.findElement(password_textBox).sendKeys(password);
	}

	public void clickLogin() {

		driver.findElement(login_button).click();
	}

	public void clickForgortPassword() {

		driver.findElement(forgortPassword_Link).click();
	}

}
