package StepDefinitions;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;

import POI.DataWriter;
import io.cucumber.java.en.*;

import java.time.Duration;
import java.util.List;

public class UsedCars{
    private WebDriver driver;
    
    @Given("user navigates to home page")
    public void user_navigates_to_home_page() {
    	driver=DriverSetup.getDriver("chrome");
    	driver.get("https://zigwheels.com");
    }
    
    @And("user navigates to used cars page")
    public void user_navigates_to_used_cars_page() {
        driver.findElement(By.cssSelector("span.c-p.icon-down-arrow")).click();
        driver.findElement(By.cssSelector("a[data-track-label='nav-used-car']")).click();
        Assert.assertTrue(driver.getCurrentUrl().contains("used-car"), "Failed to select used cars.");
    }

    @When("user selects chennai location")
    public void user_selects_chennai_location() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement chennaiLink = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@title='Chennai']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", chennaiLink);
        
        Assert.assertTrue(driver.getCurrentUrl().contains("used-car/Chennai"), "Failed to select used cars.");
    }

    @Then("all the car models should be displayed")
    public void all_the_car_models_should_be_displayed() throws Exception{
        List<WebElement> checkboxes = driver.findElements(By.cssSelector("input.carmmCheck"));
        Assert.assertFalse(checkboxes.isEmpty(), "No popular models found.");
        String[][] data = new String[checkboxes.size()][2];
        int i=0;
        for (WebElement checkbox : checkboxes) {
            System.out.println("Model: " + checkbox.getDomAttribute("car_name"));
            data[i][0]="Model "+(i+1);
            data[i][1]=checkbox.getDomAttribute("car_name");
            i++;
        }
        DataWriter.write("C:\\Users\\2389116\\eclipse-workspace\\NewBikes\\output\\cars.xlsx",data);
        driver.quit();
    }
}

