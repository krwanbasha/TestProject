package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import io.qameta.allure.Step;

public class RestaurantPage extends PageBase {
	//Restaurant Page constructor
	public RestaurantPage(WebDriver driver) {
		super(driver);
		jse = (JavascriptExecutor) driver; 
		action = new Actions(driver);
		PageFactory.initElements(driver, this);
	}
	
	//top dishes list
	@FindBy(className = "section-title")
	public WebElement topDishes;
	
	//restaurant name
	@FindBy(className = "resturant-name")
	public WebElement resturantName;
	
	//first item of top dishes
	@FindBy(xpath = "/html/body/div[3]/div[2]/div[3]/div[4]/div[1]/div[3]/div/div/div/div[1]/div/div/div[2]/div[1]/div/div[2]/div[1]/div[1]/a")
	WebElement topDishesItem;
	
	@Step("Choose from top dishes")
	public void chooseFromTopDishes()
	{
		clickButton(topDishesItem);
	}
}
