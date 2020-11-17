package tests;

import static org.testng.Assert.assertTrue;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.qameta.allure.Story;
import listeners.TestAllureListener;
import pages.DeliveryLocationPage;
import pages.HomePage;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Severity;
import ru.yandex.qatools.allure.model.SeverityLevel;

@Listeners({ TestAllureListener.class })
public class ChooseLocationTest extends TestBase {

	HomePage home;
	DeliveryLocationPage locationPage;
	
	@Test(priority = 1)
	@Severity(SeverityLevel.NORMAL)
	@Description("Choose delivery location")
	@Story("Test verify delivery location")
	public void UserCanChooseDeliveryLocation() {
		home = new HomePage(driver);
		home.moveToDeliverySection();
		assertTrue(driver.getCurrentUrl().equals("https://www.elmenus.com/cairo/delivery"));
	}
	
	@Test(priority = 2, dependsOnMethods = "UserCanChooseDeliveryLocation")
	@Severity(SeverityLevel.NORMAL)
	@Description("Search for location")
	@Story("Test verify delivery location")
	public void UserCanSearchForLocation() {
		locationPage = new DeliveryLocationPage(driver);
		locationPage.searchForDeliveryLocation();
		assertTrue(driver.getCurrentUrl().contains("features-order-online"));
	}
}
