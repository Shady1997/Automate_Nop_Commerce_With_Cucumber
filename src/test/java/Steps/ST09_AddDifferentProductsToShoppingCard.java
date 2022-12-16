package Steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.*;
import org.testng.Assert;

import static Steps.ST01_RegistrationStep.email;
import static Steps.ST01_RegistrationStep.password;

public class ST09_AddDifferentProductsToShoppingCard extends Hooks {
    P02_LoginPage loginPage;
    P03_HomePage homePage;
    P04_ShoesPage shoesPage;
    P05_NotebookPage notebookPage;
    @Given("user login correctly")
    public void userInLoginPage() {
        initialization("Chrome");
        startApplication();
    }

    @When("user add one product from Notebooks in computer category to shopping card")
    public void userAddOneProductFromNotebooksInComputerCategoryToShoppingCard() throws InterruptedException {
        loginPage=new P02_LoginPage(driver);
        homePage=new P03_HomePage(driver);
        notebookPage=new P05_NotebookPage(driver);
        loginPage.login(email,password);
        PageBase.hoverWebElement(driver,homePage.ComputerProductsTap());
        homePage.selectComputerProduct();
        notebookPage.getAddToCardButton().get(0).click();
        Thread.sleep(4000);
        PageBase.scrollWithSpecificSize(driver,0,700);
        notebookPage.getAddToCardButton().get(0).click();
        Assert.assertEquals(notebookPage.getConfirmationMessage(),"The product has been added to your shopping cart");
    }

    @And("user add one product from Shoes in Apparel category to shopping card")
    public void userAddOneProductFromShoesInApparelCategoryToShoppingCard() {
        shoesPage=new P04_ShoesPage(driver);
        PageBase.hoverWebElement(driver,homePage.apparelProductsTap());
        homePage.selectApparelProduct();
        shoesPage.getAddToCardButton().get(0).click();
        shoesPage.selectShoesSize();
        PageBase.scrollWithSpecificSize(driver,0,400);
        shoesPage.getAddToCardButton().get(0).click();
        Assert.assertEquals(shoesPage.getConfirmationMessage(),"The product has been added to your shopping cart");
    }

    @Then("the selected two products should added and appear correctly in shopping card")
    public void theSelectedTwoProductsShouldAddedAndAppearCorrectlyInShoppingCard() {
        Assert.assertEquals(homePage.getShoppingCardAmount(),"(3)");
        tearDown();
    }
}
