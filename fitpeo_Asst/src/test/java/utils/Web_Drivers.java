package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Web_Drivers {
	
	public static WebDriver getDriver() {
		return new FirefoxDriver();
	}

}
