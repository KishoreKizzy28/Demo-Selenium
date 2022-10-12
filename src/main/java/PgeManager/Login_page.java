package PgeManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_page {
	public WebDriver driver;

	@FindBy(id = "username")
	private WebElement usname;

	public Login_page(WebDriver driver2) {
		this.driver = driver2;
		PageFactory.initElements(driver, this);
	}

	public WebElement getUsname() {
		return usname;
	}

	public WebElement getPwd() {
		return pwd;
	}

	public WebElement getSbutton() {
		return sbutton;
	}

	@FindBy(id = "password")
	private WebElement pwd;

	@FindBy(xpath = "//input[@type='Submit']")
	private WebElement sbutton;

	public void loginpage() {
		// TODO Auto-generated method stub

	}

}
