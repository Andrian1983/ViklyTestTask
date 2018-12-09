package environment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class EnvironmentManager {

	public static void initWebDriver() {
		System.setProperty("webdriver.chrome.driver", "./lib/chromedriver.exe");
		WebDriver webDriver = new ChromeDriver();
		RunEnvironment.setWebDriver(webDriver);
		webDriver.manage().window().maximize();
		webDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

	}

	public static void shutDownDriver() {
		RunEnvironment.getWebDriver().quit();
	}

}
