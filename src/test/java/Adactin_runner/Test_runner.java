package Adactin_runner;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Adactin_main.Base_class;
import Com.helper.File_Reader_Manager;
import PgeManager.Confirn_Page;
import PgeManager.Hotel_page;
import PgeManager.Login_page;
import PgeManager.Pyament_page;
import extentReport.ExtentManager;
import listerner.ListenerClass;

@Listeners(ListenerClass.class)
public class Test_runner extends Base_class {

	public static WebDriver driver;
	String sheetname = "task";

	@BeforeSuite
	public void BeforeSuite() {
		ExtentManager.setExtent();
	}

	@AfterSuite
	public void AfterSuite() {
		ExtentManager.endReport();
	}

	@BeforeClass
	public void set_up() throws Throwable {
		String browser = File_Reader_Manager.getInstanceFRM().getInstanceCR().getBrowser();
		driver = getBrowser(browser);
		
		String url = File_Reader_Manager.getInstanceFRM().getInstanceCR().geturl();
		geturl(url);

		driver.manage().window().maximize();
	}

	@Test(priority = 1)
	public void loginpage() throws IOException, InterruptedException {
		Login_page lp = new Login_page(driver);

		lp.loginpage();
		inputvalueElement(lp.getUsname(), getData(sheetname, 1, 0));
		inputvalueElement(lp.getPwd(), getData(sheetname, 1, 1));
		clickonElement(lp.getSbutton());
		sleep(5000);

	}

	@Test(priority = 2)
	public void Homepage() throws InterruptedException {
		Hotel_page hp = new Hotel_page(driver);
		hp.homepage();
		dropdown("value", hp.getLocation(), "New York");
		sleep(5000);
		dropdown("text", hp.getHotels(), "Hotel Creek");
		sleep(3000);
		dropdown("text", hp.getRoom(), "Deluxe");
		sleep(3000);
		dropdown("index", hp.getRno(), "1");
		hp.getCheckin().clear();
		inputvalueElement(hp.getCheckin(), "22/09/2022");
		hp.getCheckout().clear();
		inputvalueElement(hp.getCheckout(), "30/09/2022");
		dropdown("index", hp.getAdt(), "2");
		dropdown("index", hp.getChd(), "1");
		clickonElement(hp.getSub());
		sleep(5000);
	}

	@Test(priority = 3)
	public void confirmpage() throws InterruptedException {
		Confirn_Page cp = new Confirn_Page(driver);
		cp.confirmpage();
		clickonElement(cp.getRadio());
		clickonElement(cp.getCont());
		sleep(5000);
	}

	@Test(priority = 4)
	public void paymentpage() {
		Pyament_page pp = new Pyament_page(driver);
		pp.paymentpage();
		String Actual = pp.getName().getText();
		Assert.assertEquals(Actual, "the value");
		inputvalueElement(pp.getFname(), "steve");
		inputvalueElement(pp.getLname(), "harington");
		inputvalueElement(pp.getAddress(), "california birmingam street 267676");
		inputvalueElement(pp.getCcnum(), "4431 0541 7918 2678");

		inputvalueElement(pp.getCctype(), "Amex");
		dropdown("index", pp.getMon(), "11");
		dropdown("value", pp.getExpyr(), "2022");
		inputvalueElement(pp.getCvv(), "2552");
		clickonElement(pp.getBook());
		implicitwait(5, TimeUnit.SECONDS);

	}

	@AfterClass
	public void tear_Down() {

		driver.close();
	}
}
