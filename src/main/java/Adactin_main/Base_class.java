package Adactin_main;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Base_class {
	public static WebDriver driver;

	public static WebDriver getBrowser(String type) {
		if (type.equalsIgnoreCase("chrome")) {

			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe");

			driver = new ChromeDriver();
		}

		else if (type.equalsIgnoreCase("firfox")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\Drivers\\geckodriver.exe");

			driver = new ChromeDriver();
		}
		driver.manage().window().maximize();
		return driver;

	}

	public static void Elementclic(WebElement elelemnt) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", elelemnt);
	}

	public static void clickonElement(WebElement element) {
		element.click();

	}

	public static void sleep(int milliseconds) throws InterruptedException {
		Thread.sleep(milliseconds);
	}

	public static void inputvalueElement(WebElement element, String value) {
		element.sendKeys(value);

	}

	public static void geturl(String url) {
		driver.get(url);
	}

	public static void back() {
		driver.navigate().back();

	}

	public static void dropdown(String type, WebElement element, String value) {
		Select s = new Select(element);
		if (type.equalsIgnoreCase("index")) {
			int index = Integer.parseInt(value);
			s.selectByIndex(index);
		} else if (type.equalsIgnoreCase("value")) {
			s.selectByValue(value);
		} else if (type.equalsIgnoreCase("text")) {
			s.selectByVisibleText(value);

		}
	}

	public static void implicitwait(int sec, TimeUnit type) {
		driver.manage().timeouts().implicitlyWait(sec, type);
	}

	public static String getData(String data, int rowno, int cellno) throws IOException {
		String res = null;
		File file = new File("C:\\Users\\VM452YE\\eclipse-workspace\\Selenium\\Excel reader\\login.xlsx");
		FileInputStream stream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(stream);
		org.apache.poi.ss.usermodel.Sheet sheet = workbook.getSheet(data);
		Row row = sheet.getRow(rowno);
		Cell cell = row.getCell(cellno);
		int type = cell.getCellType();
		if (type == 1) {
			res = cell.getStringCellValue();
			System.out.println(res);
		} else if (type == 0) {
			if (DateUtil.isCellDateFormatted(cell)) {
				Date dateCellValue = cell.getDateCellValue();
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
				res = dateFormat.format(dateCellValue);
				System.out.println(res);
			} else {
				double d = cell.getNumericCellValue();
				long l = (long) d;
				res = String.valueOf(l);
				System.out.println(res);
			}
		}
		return res;

	}

	public static String getCurrentTime() {
		String currentDate = new SimpleDateFormat("yyyy-MM-dd-hhmmss").format(new Date());
		return currentDate;
	}

	public static String screenShot(WebDriver driver, String filename) {

		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "\\ScreenShot\\" + filename + ".png";

		File finalDestination = new File(destination);
		try {
			FileUtils.copyFile(source, finalDestination);
		} catch (Exception e) {

			e.getMessage();
		}
		return destination;
	}

}
