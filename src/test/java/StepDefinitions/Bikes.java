package StepDefinitions;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.Before;
import io.cucumber.java.en.*;

public class Bikes{
	private WebDriver driver;
    private WebDriverWait wait;
    
    
    @Given("Click on new bikes option")
    public void click_on_bikes_option() {
    	driver = DriverSetup.getDriver("chrome");
    	driver.manage().window().maximize();
    	driver.get("https://zigwheels.com");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	WebElement bikes = driver.findElement(By.xpath("//div[@id=\"headerNewVNavWrap\"]//nav//ul//li[3]"));
		bikes.click();
    }
    
    @And("Click on advanced search option")
    public void click_on_advanced_search_option() throws InterruptedException{
    	WebElement manufacturers = driver.findElement(By.id("manufacturers"));
		WebElement adsearch = driver.findElement(By.xpath("//a[@title=\"Advanced Search\"]"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)",manufacturers);
		Thread.sleep(5000);
		adsearch.click();
    }
    
    @When("Set filters of model and price")
    public void set_filters_of_model_and_price() throws InterruptedException{
    	WebElement search = driver.findElement(By.id("make_suggest"));
		search.sendKeys("Honda");
		Thread.sleep(5000);
		List<WebElement> l = driver.findElements(By.xpath("//a[text()=\"Honda\"]"));
		l.get(1).click();
		Thread.sleep(3000);
		WebElement maxPrice = driver.findElement(By.id("maxPrice"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)",maxPrice);
		Select select = new Select(maxPrice);
		select.selectByVisibleText("4 Lakh");
		Thread.sleep(2000);
    }
    
    @Then("all the bikes should be displayed")
    public void all_the_bikes_should_displayed() throws InterruptedException{
    	List<WebElement> names = driver.findElements(By.xpath("//strong[@class=\"lnk-hvr block of-hid h-height\"]"));
    	JavascriptExecutor js = (JavascriptExecutor)driver;
		for(WebElement ele:names) {
			js.executeScript("arguments[0].scrollIntoView(true)",ele);
			System.out.println(ele.getText());
			Thread.sleep(3000);
		}
		driver.quit();
    }
}