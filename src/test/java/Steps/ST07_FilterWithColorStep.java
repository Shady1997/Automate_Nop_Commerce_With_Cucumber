package Steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P02_LoginPage;
import org.example.pages.P03_HomePage;
import org.example.pages.P04_ShoesPage;
import org.example.pages.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

import static Steps.ST01_RegistrationStep.email;
import static Steps.ST01_RegistrationStep.password;

public class ST07_FilterWithColorStep extends TestBase{

    P02_LoginPage loginPage;
    P03_HomePage homePage;
    P04_ShoesPage shoesPage;
    @Given("user login to the application")
    public void userInLoginPage() {
        prepareClassProperties("Chrome");
        startApplication();
    }


    @When("user select subcategory and filter with specific color")
    public void userSelectSubcategoryAndFilterWithSpecificColor() {
        loginPage=new P02_LoginPage(driver);
        homePage=new P03_HomePage(driver);
        shoesPage=new P04_ShoesPage(driver);
        loginPage.login(email,password);
        PageBase.hoverWebElement(driver,homePage.apparelProductsTap());
        homePage.selectApparelProduct();
        shoesPage.filterShoes();
    }

    @Then("filtered results should appear correctly")
    public void filteredResultsShouldAppearCorrectly() {
        List<WebElement> elements=shoesPage.getAddToCardButton();
        Assert.assertNotEquals(elements.size(),0);
        tearDown();
    }
}
