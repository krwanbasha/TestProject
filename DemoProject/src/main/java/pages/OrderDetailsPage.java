package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import io.qameta.allure.Step;

public class OrderDetailsPage extends PageBase {

	String Item;

	// OrderDetails Page constructor
	public OrderDetailsPage(WebDriver driver) {
		super(driver);
		jse = (JavascriptExecutor) driver;
		action = new Actions(driver);
		PageFactory.initElements(driver, this);
	}

	// Select size
	@FindBy(xpath = "/html/body/div[3]/div[2]/div[3]/div[4]/div[1]/div[3]/div/div/div/div[2]/div/div/div[2]/div[2]/div[2]/ul")
	WebElement selectSizeRBtn;

	// Add to basket
	@FindBy(xpath = "/html/body/div[3]/div[2]/div[3]/div[4]/div[1]/div[3]/div/div/div/div[2]/div/div/div[2]/div[2]/button")
	WebElement addToBasketBtn;

	@Step("Select the chosen item's size")
	public void selectSize() {
		selectliItem(selectSizeRBtn, 1).findElement(By.className("custom-radio")).click();
	}

	@Step("Add orders to basket")
	public void addToBasket() {
		clickButton(addToBasketBtn);
	}
}
