package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class P05_NotebookPage {
    WebDriver driver;
    public P05_NotebookPage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//button[text()='Add to cart']")
    private List<WebElement> addToCard;
    @FindBy(xpath = "//button[text()='Add to wishlist']")
    private List<WebElement> addToWhitList;
    @FindBy(xpath = "//button[text()='Add to compare list']")
    private List<WebElement> addToCompareList;
    @FindBy(xpath = "//p[@class='content']")
    private WebElement confirmationMessage;
    @FindBy(xpath = "(//button[text()='Add to wishlist'])[1]")
    private WebElement addWhiteListButton;
    public void clickAddToWhiteListButton(){
        addWhiteListButton.click();
    }
    public String getConfirmationMessage(){return confirmationMessage.getText();}
    public List<WebElement> getAddToCardButton(){return addToCard;}
    public List<WebElement> getAddToWhitList(){return addToWhitList;}
    public List<WebElement> getAddToCompareList(){return addToCompareList;}
}
