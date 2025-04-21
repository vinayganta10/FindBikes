package StepDefinitions;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class GoogleLogin {
	public static void main(String[] args) throws InterruptedException{
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		options.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://zigwheels.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement element = driver.findElement(By.id("des_lIcon"));
		element.click();
		WebElement google = driver.findElement(By.xpath("//div[@data-track-label='Popup_Login/Register_with_Google']"));
		google.click();
		Set<String> set = driver.getWindowHandles();
		//for(String s:set) System.out.println(s);
		Iterator it = set.iterator();
		String main = (String)it.next();
		driver.switchTo().window((String)it.next());
		driver.findElement(By.xpath("//input[@id=\"identifierId\"]")).sendKeys("aggvinayganta10@gmail.com");
		driver.findElement(By.xpath("//span[contains(.,'Next')]")).click();
		Thread.sleep(2000);
		System.out.println(driver.findElement(By.xpath("//div[@class='dMNVAe'][2]")).getText());
//		driver.close();
//		driver.quit();
	}
}
