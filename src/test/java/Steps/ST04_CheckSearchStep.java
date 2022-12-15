package Steps;

import com.relevantcodes.extentreports.LogStatus;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P02_LoginPage;
import org.example.pages.P03_HomePage;
import org.example.pages.PageBase;

import java.io.IOException;

import static Steps.ST01_RegistrationStep.email;
import static Steps.ST01_RegistrationStep.password;

public class ST04_CheckSearchStep extends TestBase{

    P02_LoginPage loginPage;
    P03_HomePage homePage;

    @Given("user login to nop commerce web application")
    public void userInLoginPage() {
        prepareClassProperties("Chrome");
        startApplication();
    }

    @When("search for product")
    public void searchForProduct() {
        loginPage=new P02_LoginPage(driver);
        homePage=new P03_HomePage(driver);
        loginPage.login(email,password);
        homePage.searchProducts();

    }

    @Then("results should appear correctly")
    public void resultsShouldAppearCorrectly() throws IOException {
        homePage.checkSearchResult();
        // extend report status
        test.log(LogStatus.PASS, "Searching Work Correctly");
        tearDown();
//        PageBase.startHtmlReport(System.getProperty("user.dir")+"/target/HtmlReports","report.html");
    }
}
