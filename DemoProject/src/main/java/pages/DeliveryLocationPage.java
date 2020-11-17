package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import io.qameta.allure.Step;

public class DeliveryLocationPage extends PageBase {
	public DeliveryLocationPage(WebDriver driver) {
		super(driver);
		jse = (JavascriptExecutor) driver; 
		action = new Actions(driver);
		PageFactory.initElements(driver, this);
	}
	
	//Search for delivery location
	@FindBy(xpath = "/html/body/div[3]/div[2]/div/div[2]/div/div/div[1]/label/input")
	WebElement searchFld;
	
	//List of search results
	@FindBy(xpath = "/html/body/div[3]/div[2]/div/div[3]/div[2]/ul/li[1]")
	WebElement firstAreaItem;
	
	//get location
	@FindBy(xpath = "/html/body/div[3]/div[2]/div/div[3]/div[5]/div/ul/li[1]")
	WebElement firstZoneLink;
	
	//city area
	@FindBy(className = "zone-btn")
	WebElement cityArea;
	
	@Step("Search for delivery location")
	public void searchForDeliveryLocation()
	{
		clickButton(cityArea);
		clickButton(firstAreaItem);
		System.out.println("Area Name is: "+getText(firstAreaItem));
		clickButton(firstZoneLink);
	}

}
