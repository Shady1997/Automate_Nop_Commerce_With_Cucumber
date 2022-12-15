package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class P01_RegistrationPage {
    WebDriver driver;

    public P01_RegistrationPage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    // registration tap
    @FindBy(xpath = "//a[@class='ico-register']")
    public WebElement registerTap;

    // user data
    @FindBy(xpath = "(//input[@type='radio'])[1]")
    private WebElement gender;
    @FindBy(xpath = "//input[@name='FirstName']")
    private WebElement firstName;
    @FindBy(xpath = "//input[@name='LastName']")
    private WebElement lastName;
    @FindBy(xpath = "//a[@class='button-1 register-continue-button']")
    public WebElement continueButton;
    @FindBy(xpath = "//select[@name='DateOfBirthDay']")
    private WebElement dayOfBirth;
    @FindBy(xpath = "//select[@name='DateOfBirthMonth']")
    private WebElement monthOfBirth;
    @FindBy(xpath = "//select[@name='DateOfBirthYear']")
    private WebElement yearOfBirth;
    @FindBy(xpath = "//input[@type='email']")
    private WebElement email;
    @FindBy(xpath = "//input[@name='Company']")
    private WebElement company;
    @FindBy(xpath = "(//input[@type='password'])[1]")
    private WebElement password;
    @FindBy(xpath = "(//input[@type='password'])[2]")
    private WebElement confirmPassword;
    @FindBy(xpath = "(//button[@type='submit'])[2]")
    private WebElement registerButton;

    public void registerNewUser(
            String fname,
            String lname,
            String useerEmail,
            String companyName,
            String userPassword){
        // TODO: add new user
        // fill user data
        gender.click();
        firstName.sendKeys(fname);
        lastName.sendKeys(lname);

        Select select=new Select(dayOfBirth);
        select.selectByIndex(1);
        select=new Select(monthOfBirth);
        select.selectByIndex(1);
        select=new Select(yearOfBirth);
        select.selectByIndex(1);

        email.sendKeys(useerEmail);
        company.sendKeys(companyName);

        password.sendKeys(userPassword);
        confirmPassword.sendKeys(userPassword);

        registerButton.click();
    }

}
