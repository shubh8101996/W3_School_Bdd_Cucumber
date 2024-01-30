package stepDef;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;
import io.cucumber.java.en.Then;

public class StefDefination {

	WebDriver driver;
	WebDriverWait wait;

	@Given("^I am on the login page$")
	public void iAmOnTheLoginPage() {

		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");

		driver = new ChromeDriver(options);

		driver.get("https://profile.w3schools.com/log-in?redirect_url=https%3A%2F%2Fmy-learning.w3schools.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

	}

	@When("^I enter valid username \"([^\"]*)\" and password \"([^\"]*)\"$")
	public void iEnterValidCredentials(String username, String password) {

		WebElement email = driver.findElement(By.id("modalusername"));
		email.sendKeys(username);

		WebElement pass = driver.findElement(By.id("current-password"));
		pass.sendKeys(password);
		System.out.println("entered valid username and password");

	}

	@When("^I enter invalid username \"([^\"]*)\" and password \"([^\"]*)\"$")
	public void iEnterInvalidCredentials(String username, String password) {

		WebElement email = driver.findElement(By.id("modalusername"));
		email.sendKeys(username);

		WebElement pass = driver.findElement(By.id("current-password"));
		pass.sendKeys(password);
		System.out.println("entered invalid username and password");

	}

	@When("^I leave the username and password fields empty$")
	public void iLeaveEmptyFields() {

		WebElement email = driver.findElement(By.id("modalusername"));
		email.sendKeys("");

		WebElement pass = driver.findElement(By.id("current-password"));
		pass.sendKeys("");
		System.out.println("empty username and password");

	}

	@When("^I click on the login button$")
	public void iClickLoginButton() {

		WebElement logbtn = driver.findElement(By.xpath("//span[text()='Log in']"));
		logbtn.click();
		System.out.println("click on login button");

	}

	@When("I click on the {string} link")
	public void i_click_on_the_link(String string) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement forgotpass = driver.findElement(By.xpath("//div[@class='LoginModal_forgot_pwd_wrapper__qttSX']//a"));
		wait.until(ExpectedConditions.visibilityOf(forgotpass));
		js.executeScript("arguments[0].click();", forgotpass);
//		forgotpass.click();
		System.out.println("clicked on link ");
	}

	@Then("^I should be redirected to my learning dashboard$")
	public void iShouldBeRedirectedToDashboard() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		Thread.sleep(10000);
		String actual = driver.getTitle();
		wait.until(ExpectedConditions.titleContains(actual));
		Assert.assertEquals("My learning | W3Schools", actual);
		System.out.println("dashbard page verify and display");
		driver.close();

	}

	@Then("^I should see an error message indicating invalid credentials$")
	public void iShouldSeeInvalidCredentialsError() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		WebElement errorMsg = driver.findElement(By.xpath("//div[text()='A user with this email does not exist']"));
		Assert.assertEquals("A user with this email does not exist", errorMsg.getText());
		System.out.println("error message displayed");
		driver.close();

	}

	@Then("^I should see an error message indicating required fields$")
	public void iShouldSeeRequiredFieldsError() {

		WebElement spanError = driver.findElement(By.xpath("//span[text()='Please enter an email']"));
		Assert.assertEquals("Please enter an email", spanError.getText());
		System.out.println("error message displayed for required fields");
		driver.close();

	}

	@Then("^I should be redirected to the password recovery page$")
	public void iShouldBeRedirectedToPasswordRecoveryPage() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement redirect = driver.findElement(By.xpath("//*[contains(text(),'Reset your password')]"));
		wait.until(ExpectedConditions.visibilityOf(redirect));
		Assert.assertEquals("Reset your password", redirect.getText());
		System.out.println("redirected to the password recovery page and verify");
		driver.close();

	}
	
	@When("I enter username {string} and password {string}")
	public void i_enter_username_and_password(String string, String string2) {
		
		WebElement email = driver.findElement(By.id("modalusername"));
		email.sendKeys(string);

		WebElement pass = driver.findElement(By.id("current-password"));
		pass.sendKeys(string2);
		System.out.println("entered invalid username and password");
	    
	}

}
