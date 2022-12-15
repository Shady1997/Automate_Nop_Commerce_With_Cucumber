package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class P02_LoginPage {
	
	WebDriver driver;
	
	public P02_LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[@class='ico-login']")
	public WebElement loginTap;
	
	@FindBy(xpath="//input[@type='email']")
	private WebElement email;
	
	@FindBy(xpath="//input[@type='password']")
	private WebElement password;

	@FindBy(xpath="//input[@type='checkbox']")
	private WebElement rememberMe;

	@FindBy(xpath="(//button[@type='submit'])[2]")
	private WebElement loginButton;

	@FindBy(xpath="//a[text()='Forgot password?']")
	private WebElement forgetPassword;

	@FindBy(xpath="//button[@name='send-email']")
	private WebElement recoverButton;

	@FindBy(xpath="//p[@class='content']")
	private WebElement recoverConfirmationMessage;

	//TODO: Login to Application
	public void login(String email,String password)
	{
		// choose login tap from home page
		loginTap.click();
		// add email and password
		this.email.sendKeys(email);
		this.password.sendKeys(password);
		rememberMe.click();
		// click login button
		loginButton.click();
	}
	// to set new password
	public void setPassword(String email){
		forgetPassword.click();
		this.email.sendKeys(email);
		recoverButton.click();
	}
	// return recovery confirmation message
	public String getRecoverPasswordMessage() {
		return recoverConfirmationMessage.getText();
	}
}
