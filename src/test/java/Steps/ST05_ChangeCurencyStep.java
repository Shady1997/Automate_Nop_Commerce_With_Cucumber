package Steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P02_LoginPage;
import org.example.pages.P03_HomePage;
import org.testng.Assert;

import static Steps.ST01_RegistrationStep.email;
import static Steps.ST01_RegistrationStep.password;

public class ST05_ChangeCurencyStep extends Hooks {

    P02_LoginPage loginPage;
    P03_HomePage homePage;
    String firstOption;
    @Given("user login to nop commerce")
    public void userInLoginPage() {
        initialization("Chrome");
        startApplication();
    }

    @When("change current currency to another")
    public void changeCurrentCurrencyToAnother() {
        loginPage=new P02_LoginPage(driver);
        homePage=new P03_HomePage(driver);
        loginPage.login(email,password);
        firstOption=homePage.getFirstCurrency();
        homePage.changeCurrency();
    }

    @Then("currency should changed correctly")
    public void currencyShouldChangedCorrectly() {
        Assert.assertNotEquals(firstOption,homePage.getFirstCurrency());
        tearDown();
    }
}
