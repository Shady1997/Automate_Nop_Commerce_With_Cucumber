package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class P04_ShoesPage {
    WebDriver driver;
    public P04_ShoesPage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    // elements in shoes page
    @FindBy(xpath = "(//span[@class='attribute-square'])[2]")
    private WebElement redShoes;
    public void filterShoes(){
        redShoes.click();}
    @FindBy(xpath = "//button[text()='Add to cart']")
    private List<WebElement> addToCard;
    @FindBy(xpath = "//button[text()='Add to wishlist']")
    private List<WebElement> addToWhitList;
    @FindBy(xpath = "//button[text()='Add to compare list']")
    private List<WebElement> addToCompareList;
    @FindBy(id = "product_attribute_9")
    private WebElement shoesSize;
    @FindBy(xpath = "//p[@class='content']")
    private WebElement confirmationMessage;
    @FindBy(xpath = "(//button[text()='Add to wishlist'])[1]")
    private WebElement addWhiteListButton;
    public void clickAddToWhiteListButton(){
        addWhiteListButton.click();
    }
    public String getConfirmationMessage(){
        return confirmationMessage.getText();
    }
    public List<WebElement> getAddToCardButton(){return addToCard;}
    public List<WebElement> getAddToWhitList(){return addToWhitList;}
    public List<WebElement> getAddToCompareList(){return addToCompareList;}
    public void selectShoesSize(){
        Select select=new Select(shoesSize);
        select.selectByIndex(1);
    }
}
