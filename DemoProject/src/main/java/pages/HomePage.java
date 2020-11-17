package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import io.qameta.allure.Step;

public class HomePage extends PageBase
{
	// Home Page constructor
	public HomePage(WebDriver driver) {
		super(driver);
		jse = (JavascriptExecutor) driver; 
		action = new Actions(driver);
		PageFactory.initElements(driver, this);
	} 

	//login elements
	@FindBy(className ="btn-link")
	WebElement loginLink; 
	
	@FindBy(name = "email")
	WebElement emailFld;
	
	@FindBy(name = "password")
	WebElement passwordFld;
	
	@FindBy(className = "submit-btn")
	WebElement loginBtn;
	
	//user name
	@FindBy(className = "username")
	public WebElement userName;
	
	//search field path
	@FindBy(xpath = "/html/body/div[3]/section[1]/div[1]/div/div/form/div/div[1]/div/input")
	public WebElement searchFld;
	
	//search button
	@FindBy(className = "btn-primary")
	WebElement goBtn;
	
	//Delivery section
	@FindBy(className = "clickable-anchor")
	WebElement deliveryLink;
	
	@Step("Open login form")
	public void openLoginForm()
	{
		clickButton(loginLink);
	}
	
	@Step("Login to El-menus")
	public void loginToElmenus(String email, String password)
	{
		clearText(emailFld);
		setTextElementText(emailFld, email);
		clearText(passwordFld);
		setTextElementText(passwordFld, password);
		clickButton(loginBtn);
	}
	
	@Step("Search for a resturant")
	public void findRestaurant(String name)
	{
		setTextElementText(searchFld, name);
		clickButton(goBtn);
	}
	
	@Step("Open delevry location section")
	public void moveToDeliverySection()
	{
		getText(deliveryLink);
		clickButton(deliveryLink);
	}
	
}