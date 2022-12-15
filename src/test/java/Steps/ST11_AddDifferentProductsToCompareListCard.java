package Steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.*;
import org.testng.Assert;

import static Steps.ST01_RegistrationStep.email;
import static Steps.ST01_RegistrationStep.password;

public class ST11_AddDifferentProductsToCompareListCard extends TestBase{
    P02_LoginPage loginPage;
    P03_HomePage homePage;
    P04_ShoesPage shoesPage;
    P05_NotebookPage notebookPage;
    @Given("user login Successfully")
    public void userInLoginPage() {
        prepareClassProperties("Chrome");
        startApplication();
    }

    @When("user add one product from Notebooks in computer category to Compare List")
    public void userAddOneProductFromNotebooksInComputerCategoryToShoppingCard() throws InterruptedException {
        loginPage=new P02_LoginPage(driver);
        homePage=new P03_HomePage(driver);
        notebookPage=new P05_NotebookPage(driver);
        loginPage.login(email,password);
        PageBase.hoverWebElement(driver,homePage.ComputerProductsTap());
        homePage.selectComputerProduct();
        notebookPage.getAddToCompareList().get(0).click();
        Assert.assertEquals(notebookPage.getConfirmationMessage(),"The product has been added to your product comparison");
    }

    @And("user add one product from Shoes in Apparel category to Compare List")
    public void userAddOneProductFromShoesInApparelCategoryToShoppingCard() {
        shoesPage=new P04_ShoesPage(driver);
        PageBase.hoverWebElement(driver,homePage.apparelProductsTap());
        homePage.selectApparelProduct();
        shoesPage.getAddToCompareList().get(0).click();
        Assert.assertEquals(shoesPage.getConfirmationMessage(),"The product has been added to your product comparison");
    }

    @Then("the selected two products should added and appear correctly")
    public void theSelectedTwoProductsShouldAddedAndAppearCorrectlyInShoppingCard() {
        Assert.assertEquals(homePage.getShoppingCardAmount(),"(3)");
        Assert.assertEquals(homePage.getWhiteListAmount(),"(3)");
        tearDown();
    }
}
