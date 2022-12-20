package Methods;

import org.openqa.selenium.WebDriver;

import Pages.ForgotPassword;

public class ForgotPasswordMethods {
	
	WebDriver driver;

	public ForgotPasswordMethods(WebDriver driver) {

		this.driver = driver;
	}
	
	ForgotPassword fp=new ForgotPassword(driver);
	

	public void enterUsername() {

		driver.findElement(fp.username_textBox).sendKeys("Admin");
	}

	public void clickCancel() {

		driver.findElement(fp.cancel_button).click();
	}

	public void clickResetPassword() {

		driver.findElement(fp.resetPassword_button).click();
	}
}
