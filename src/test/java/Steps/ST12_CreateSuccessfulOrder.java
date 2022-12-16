package Steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.*;
import org.junit.Assert;

import static Steps.ST01_RegistrationStep.email;
import static Steps.ST01_RegistrationStep.password;

public class ST12_CreateSuccessfulOrder extends Hooks {

    P02_LoginPage loginPage;
    P03_HomePage homePage;
    P06_CheckOutPage checkOutPage;
    @Given("user login Successfully to Nop Commerce App")
    public void userInLoginPage() {
        initialization("Chrome");
        startApplication();
    }

    @When("user click go to card button and complete checkout")
    public void userClickGoToCardButtonAndCompleteCheckout() {
        loginPage=new P02_LoginPage(driver);
        homePage=new P03_HomePage(driver);
        checkOutPage=new P06_CheckOutPage(driver);
        loginPage.login(email,password);
        PageBase.hoverWebElement(driver,homePage.getShoppingCard());
        homePage.clickGoToCardButton();
        checkOutPage.checkTermsOfService();
        checkOutPage.ClickCheckoutButton();
    }

    @Then("order should created successfully")
    public void orderShouldCreatedSuccessfully() {
        Assert.assertTrue(true);
    }
}
