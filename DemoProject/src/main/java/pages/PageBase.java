package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageBase {
	public static WebDriver driver;
	public static WebDriverWait wait;
	public static JavascriptExecutor jse;
	public Select select;
	public Actions action;

	// PageBase constructor
	@SuppressWarnings("static-access")
	public PageBase(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	protected static void clickButton(WebElement button) {
		button.click();
	}

	protected static void setTextElementText(WebElement textElement, String value) {
		textElement.sendKeys(value);
	}

	protected static void scrollToBottom()

	{
		jse.executeScript("window.scrollBy(0,250)", "");
	}

	protected static void goToElement(WebElement element) {
		jse.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	protected static void clearText(WebElement element) {
		element.clear();
	}

	protected static void goToPreviousPage() {
		driver.navigate().back();
	}

	protected static String getText(WebElement element) {
		return element.getText();
	}

	protected static void waitUntil(WebElement element) {
		wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	protected static WebElement selectliItem(WebElement parentElement, int b) {
		List<WebElement> links = parentElement.findElements(By.tagName("li"));
		return links.get(b);
		
	}
}
