package Com.helper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Configuration_reader {
	public static Properties p;
	public Configuration_reader() throws IOException {
		
File  f = new File("C:\\Users\\VM452YE\\eclipse-workspace\\Selenium\\src\\test\\resources\\Config.properties");
		
		FileInputStream fis = new FileInputStream(f);
		
		 p = new Properties();
		
		p.load(fis);
	}
	
	public String geturl() throws Throwable {
		
		
		String url = p.getProperty("url");	
		
		return url;
		
		}
	public String getBrowser() {
		String browser = p.getProperty("browser");
		return browser;
	}

}
