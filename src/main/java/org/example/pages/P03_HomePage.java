package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class P03_HomePage {

    WebDriver driver;
    public P03_HomePage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    // searching in home page
    @FindBy(xpath = "//input[@name='q']")
    private WebElement searchBox;
    @FindBy(xpath = "//button[@class='button-1 search-box-button']")
    private WebElement searchButton;
    @FindBy(xpath = "(//button[@class='button-2 product-box-add-to-cart-button'])[1]")
    private WebElement searchResult;
    // computers products
    @FindBy(xpath = "//a[@href='/computers']")
    private WebElement computersProducts;
    @FindBy(xpath = "//a[@href='/notebooks']")
    private WebElement notebooksProducts;
    // apparel Products
    @FindBy(xpath = "//a[@href='/apparel']")
    private WebElement apparelProducts;
    @FindBy(xpath = "//a[@href='/shoes']")
    private WebElement shoesProducts;
    // currency change
    @FindBy(id = "customerCurrency")
    private WebElement currecny;

    @FindBy(xpath = "(//h1)[1]")
    private WebElement productPageHeader;

    @FindBy(xpath = "//span[@class='cart-qty']")
    private WebElement shoppingCard;
    @FindBy(xpath = "//span[@class='wishlist-qty']")
    private WebElement wishList;
    @FindBy(xpath = "//button[text()='Go to cart']")
    private WebElement goToCardButton;
    public void clickGoToCardButton(){goToCardButton.click();}
    public WebElement getShoppingCard(){return shoppingCard;}
    public String getWhiteListAmount(){return wishList.getText();}
    public String getShoppingCardAmount(){return shoppingCard.getText();}
    public void selectComputerProduct(){
        notebooksProducts.click();
    }
    public WebElement ComputerProductsTap(){
        return computersProducts;
    }
    public WebElement apparelProductsTap(){
        return apparelProducts;
    }
    public void selectApparelProduct(){
        shoesProducts.click();
    }
    public String getProductPageHeader(){
        return productPageHeader.getText().toString();
    }
    public void changeCurrency(){
        Select select=new Select(currecny);
        select.selectByIndex(1);
    }
    public String getFirstCurrency(){
        Select select=new Select(currecny);
        return select.getFirstSelectedOption().getText();
    }
    public void searchProducts(){
        searchBox.sendKeys("MacBook");
        searchButton.click();
    }
    public boolean checkSearchResult(){
       return searchResult.getText().equals("Add to cart");
    }
}
