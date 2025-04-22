package StepDefinitions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

public class DriverSetup {
	public static WebDriver driver;
	public static WebDriver getDriver(String browser) {
		if(browser.equals("chrome")) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--start-maximized");
			options.addArguments("--disable-notifications");
			driver = new ChromeDriver(options);
		}
		else if(browser.equals("edge")) {
			driver = new EdgeDriver();
		}
		else {
			driver=null;
		}
		return driver;
	}
}
