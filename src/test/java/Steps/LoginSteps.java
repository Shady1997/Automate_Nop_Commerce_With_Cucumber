package Steps;

import java.util.List;
import java.util.concurrent.TimeUnit;

import io.cucumber.datatable.DataTable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import pages.LoginPage;

public class LoginSteps {

	WebDriver driver = null;
	LoginPage loginPage;

	@Given("user is in login page")
	public void user_is_in_login_page() {

		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\test\\resources\\drivers\\chromedriver.exe");

		driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);

		driver.manage().window().maximize();

		driver.get("https://www.saucedemo.com/");
	}

	@When("user add valid username and password")
	public void user_add_valid_username_and_password() {

		loginPage = new LoginPage(driver);

		loginPage.userName.sendKeys("standard_user");

		loginPage.userPassword.sendKeys("secret_sauce");
	}

	@When("click login button")
	public void click_login_button() {

		loginPage = new LoginPage(driver);

		loginPage.loginButton.click();
	}

	@Then("user navigate to home page")
	public void user_navigate_to_home_page() {

		WebElement element = driver.findElement(By.xpath("//span[@class='title']"));
		Assert.assertEquals(element.getText().toString(), "PRODUCTS");
	}

	@When("user add invalid username and password")
	public void userEnterUsernameAndPassword(DataTable usercredentials) {
		//Write the code to handle Data Table
		List<String> data = usercredentials.row(0);
		loginPage = new LoginPage(driver);

		loginPage.userName.sendKeys(data.get(0));

		loginPage.userPassword.sendKeys(data.get(1));
	}

	@Then("user will not navigate to home page")
	public void userWillNotNavigateToHomePage() {
		WebElement element = driver.findElement(By.xpath("//h3[@data-test='error']"));
		Assert.assertEquals(element.getText().toString(), "Epic sadface: Username and password do not match any user in this service");
	}
}
