package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class P06_CheckOutPage {
    WebDriver driver;
    public P06_CheckOutPage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(id = "termsofservice")
    private WebElement termsOfService;
    @FindBy(id = "checkout")
    private WebElement checkout;
    public void ClickCheckoutButton(){checkout.click();}
    public void checkTermsOfService(){termsOfService.click();}
}
