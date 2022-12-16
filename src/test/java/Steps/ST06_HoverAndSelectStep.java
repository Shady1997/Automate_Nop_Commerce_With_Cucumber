package Steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P02_LoginPage;
import org.example.pages.P03_HomePage;
import org.example.pages.PageBase;
import org.testng.Assert;

import static Steps.ST01_RegistrationStep.email;
import static Steps.ST01_RegistrationStep.password;

public class ST06_HoverAndSelectStep extends Hooks {
    P02_LoginPage loginPage;
    P03_HomePage homePage;
    @Given("user login to Application")
    public void userInLoginPage() {
        initialization("Chrome");
        startApplication();
    }

    @When("Hover over any category and select subcategory")
    public void hoverOverAnyCategoryAndSelectSubcategory() {
        loginPage=new P02_LoginPage(driver);
        homePage=new P03_HomePage(driver);
        loginPage.login(email,password);
        PageBase.hoverWebElement(driver,homePage.ComputerProductsTap());
        homePage.selectComputerProduct();
    }

    @Then("the sub category page should appear correctly")
    public void theSubCategoryPageShouldAppearCorrectly() {
        Assert.assertEquals(homePage.getProductPageHeader(),"Notebooks");
        tearDown();
    }
}
