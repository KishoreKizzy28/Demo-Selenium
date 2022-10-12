package PgeManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Pyament_page {
	public WebDriver driver;

	@FindBy(xpath = "//input[@name='first_name']")
	private WebElement fname;
	@FindBy(xpath = "//td[text()='Book A Hotel ']")
	private WebElement text;

	public WebElement getName() {
		return text;
	}

	public Pyament_page(WebDriver driver2) {
		this.driver = driver2;
		PageFactory.initElements(driver, this);
	}

	public WebElement getFname() {
		return fname;
	}

	public WebElement getLname() {
		return lname1;
	}

	public WebElement getAddress() {
		return address;
	}

	public WebElement getCcnum() {
		return ccnum;
	}

	public WebElement getCctype() {
		return cctype;
	}

	public WebElement getMon() {
		return mon;
	}

	public WebElement getExpyr() {
		return expyr;
	}

	public WebElement getCvv() {
		return cvv;
	}

	public WebElement getBook() {
		return Book;
	}

	@FindBy(xpath = "//input[@name='first_name']")
	private WebElement fname1;

	@FindBy(xpath = "//input[@name='last_name']")
	private WebElement lname1;

	public WebElement getLname1() {
		return lname1;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getFname1() {
		return fname1;
	}

	@FindBy(xpath = "//textarea[@name='address']")
	private WebElement address;

	@FindBy(id = "cc_num")
	private WebElement ccnum;

	@FindBy(id = "cc_type")
	private WebElement cctype;

	@FindBy(id = "cc_exp_month")
	private WebElement mon;

	@FindBy(name = "cc_exp_year")
	private WebElement expyr;

	@FindBy(xpath = "//input[@maxlength='4']")
	private WebElement cvv;

	@FindBy(name = "book_now")
	private WebElement Book;

	public void paymentpage() {
		// TODO Auto-generated method stub

	}

}
