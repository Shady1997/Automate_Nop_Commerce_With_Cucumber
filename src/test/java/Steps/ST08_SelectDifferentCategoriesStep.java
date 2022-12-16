package Steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P02_LoginPage;
import org.example.pages.P03_HomePage;
import org.example.pages.P04_ShoesPage;
import org.example.pages.PageBase;
import org.testng.Assert;

import static Steps.ST01_RegistrationStep.email;
import static Steps.ST01_RegistrationStep.password;

public class ST08_SelectDifferentCategoriesStep extends Hooks {

    P02_LoginPage loginPage;
    P03_HomePage homePage;
    P04_ShoesPage shoesPage;
    @Given("user login to the app")
    public void userInLoginPage() {
        initialization("Chrome");
        startApplication();
    }

    @When("user select hover Computers categories and select Notebooks sub category")
    public void userSelectHoverComputersCategoriesAndSelectNotebooksSubCategory() {
        loginPage=new P02_LoginPage(driver);
        homePage=new P03_HomePage(driver);
        shoesPage=new P04_ShoesPage(driver);
        loginPage.login(email,password);
        PageBase.hoverWebElement(driver,homePage.ComputerProductsTap());
        homePage.selectComputerProduct();
    }

    @Then("Notebooks page should start correctly")
    public void notebooksPageShouldStartCorrectly() {
        Assert.assertEquals(homePage.getProductPageHeader(),"Notebooks");
    }

    @And("user select hover Apparel categories and select Shoes sub category")
    public void userSelectHoverApparelCategoriesAndSelectShoesSubCategory() {
        PageBase.hoverWebElement(driver,homePage.apparelProductsTap());
        homePage.selectApparelProduct();
    }

    @Then("Shoes page should appear correctly")
    public void shoesPageShouldAppearCorrectly() {
        Assert.assertEquals(homePage.getProductPageHeader(),"Shoes");
        tearDown();
    }
}
