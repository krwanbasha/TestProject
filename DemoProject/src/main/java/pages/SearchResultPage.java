package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import io.qameta.allure.Step;

public class SearchResultPage extends PageBase {
	
	//Search result Page constructor
	public SearchResultPage(WebDriver driver) {
		super(driver);
		jse = (JavascriptExecutor) driver; 
		action = new Actions(driver);
		PageFactory.initElements(driver, this);
	}
	
	//path of search item
	@FindBy(xpath = "/html/body/div[3]/div[2]/div/div/div/div[2]/div/div[1]")
	WebElement searchItem;
	
	@Step("Click on specific order")
	public void specificSearchResult()
	{
		clickButton(searchItem);
	}

}
