package StepDefinitions;

import java.time.Duration;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.*;
import io.cucumber.java.After;
import io.cucumber.java.Before;


public class GoogleLogin {
	
	private WebDriver driver;
    private WebDriverWait wait;
    private String originalWindow;
    WebElement errorMessage;
    
    @Given("the user navigates to the Zigwheels login options")
    public void the_user_navigates_to_the_Zigwheels_login_options() {
    	driver = DriverSetup.getDriver("chrome");
    	driver.manage().window().maximize();
		driver.get("https://zigwheels.com");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement loginButton = driver.findElement(By.id("des_lIcon"));
        loginButton.click();
    }
    
    @Given("the user selects the {string} option")
	public void click_on_login_and_click_on_google(String option) {
    	if(option.equals("Sign in with Google")) {
    		wait.until(ExpectedConditions.presenceOfElementLocated(By.className("googleSignIn"))).click();

            originalWindow = driver.getWindowHandle();
            wait.until(ExpectedConditions.numberOfWindowsToBe(2));
            Set<String> windowHandles = driver.getWindowHandles();
            for (String handle : windowHandles) {
                if (!handle.equals(originalWindow)) {
                    driver.switchTo().window(handle);
                    break;
                }
            }
    	}
	}
	
    @When("the user enters an invalid email format")
	public void the_user_enters_an_invalid_email_format(){
		String email = "email-@em";
        enterEmail(email);
        errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@jsname='B34EJ' and @class='dEOOab RxsGPe']//div[@class='Ekjuhf Jj6Lae']")));
	}
    
    @When("the user enters a non-existent Google Account email")
    public void the_user_enters_a_non_existent_Google_Account_email(){
    	String email = "aggvinayganta@gmail.com";
		enterEmail(email);
		errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@jsname='B34EJ' and @class='dEOOab RxsGPe']//div[@class='Ekjuhf Jj6Lae']")));
    }
    
    @When("the user enters a valid Google Account email")
    public void the_user_enters_a_valid_Google_Account_email() {
		String email = "aggvinayganta10@gmail.com";
		enterEmail(email);
		errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='dMNVAe' and contains(text(), 'This browser or app may not be secure')]")));
    }
    
    @Then("the user should observe a {string} warning message")
    public void the_user_should_observe_a_warning_message(String expectedMessage1) {
        String actualMessage = errorMessage.getText();
        Assert.assertTrue(actualMessage.equals(expectedMessage1) || actualMessage.equals("This browser or app may not be secure."));
        driver.close();
		driver.quit();
    }
    
//	@After
//	public void tearDown() {
//		driver.close();
//		driver.quit();
//	}

	private void enterEmail(String email) {
        WebElement emailField = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("identifierId")));
        emailField.clear();
        emailField.sendKeys(email);
        WebElement nextButton = driver.findElement(By.id("identifierNext"));
        nextButton.click();
    }
}
