package PgeManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Hotel_page {
	public WebDriver driver;

	public Hotel_page(WebDriver driver2) {
		this.driver = driver2;
		PageFactory.initElements(driver, this);

	}

	public WebElement getLocation() {
		return location;
	}

	public WebElement getHotels() {
		return hotels;
	}

	public WebElement getRoom() {
		return room;
	}

	public WebElement getRno() {
		return rno;
	}

	public WebElement getCheckin() {
		return checkin;
	}

	public WebElement getCheckout() {
		return checkout;
	}

	public WebElement getAdt() {
		return adt;
	}

	public WebElement getChd() {
		return chd;
	}

	public WebElement getSub() {
		return sub;
	}

	@FindBy(xpath = "//select[@name='location']")
	private WebElement location;

	@FindBy(xpath = "//select[@name='hotels']")
	private WebElement hotels;

	@FindBy(xpath = "//select[@name='room_type']")
	private WebElement room;

	@FindBy(xpath = "//Select[@name='room_nos']")
	private WebElement rno;

	@FindBy(id = "datepick_in")
	private WebElement checkin;

	@FindBy(id = "datepick_out")
	private WebElement checkout;

	@FindBy(id = "adult_room")
	private WebElement adt;

	@FindBy(name = "child_room")
	private WebElement chd;

	@FindBy(id = "Submit")
	private WebElement sub;

	public void homepage() {

	}
}
