package tests;

import static org.testng.Assert.assertTrue;

import java.io.FileReader;
import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.opencsv.CSVReader;

import io.qameta.allure.Description;
import io.qameta.allure.Story;
import listeners.TestAllureListener;
import pages.HomePage;
import pages.OrderDetailsPage;
import pages.RestaurantPage;
import pages.SearchResultPage;
import ru.yandex.qatools.allure.annotations.Severity;
import ru.yandex.qatools.allure.model.SeverityLevel;

@Listeners({ TestAllureListener.class })
public class CheckOutTest extends TestBase {
	// initialize objects
	HomePage home;
	SearchResultPage searchResults;
	RestaurantPage restPage;
	OrderDetailsPage orderDetailsPage;

	// initialize parameters
	String searchName = "hadramoutalsammar";
	String nameTitle = "Hadramout & Al Sammar";

	CSVReader reader;

	@Severity(SeverityLevel.BLOCKER)
	@Description("login into El-menus")
	@Story("Test verify checkout orders")
	@Test(priority = 1)
	public void UserCanLoginToElmenus() throws IOException {

		// get path of CSV file
		String CSV_file = System.getProperty("user.dir") + "/src/test/java/data/UserData.csv";
		reader = new CSVReader(new FileReader(CSV_file));

		String[] csvCell;

		// while loop will be executed till the last value in CSV file .
		while ((csvCell = reader.readNext()) != null) {
			String email = csvCell[0];
			email.replaceAll("[ï»¿]", "");
			String password = csvCell[1];
			String profileName = csvCell[2];
			home = new HomePage(driver);
			home.openLoginForm();
			home.loginToElmenus(email, password);
			Assert.assertTrue(home.userName.getText().contains(profileName));
		}
	}

	@Severity(SeverityLevel.NORMAL)
	@Description("Search for a Restaurant")
	@Story("Test verify checkout orders")
	@Test(priority = 2, dependsOnMethods = "UserCanLoginToElmenus")
	public void UserCanSearchforaRestaurant() {
		home.findRestaurant(searchName);
		assertTrue(driver.getCurrentUrl().contains(searchName));
	}

	@Severity(SeverityLevel.NORMAL)
	@Description("Choose first result")
	@Story("Test verify checkout orders")
	@Test(priority = 3, dependsOnMethods = "UserCanSearchforaRestaurant")
	public void UserCanChooseResult() {
		searchResults = new SearchResultPage(driver);
		searchResults.specificSearchResult();
		restPage = new RestaurantPage(driver);
		assertTrue(restPage.resturantName.getText().contains(nameTitle));
	}

	@Severity(SeverityLevel.NORMAL)
	@Description("Choose from Top Dishes list")
	@Story("Test verify checkout orders")
	@Test(priority = 4, dependsOnMethods = "UserCanChooseResult")
	public void UserCanChooseFromTopDishes() {
		assertTrue(restPage.topDishes.getText().contains("Top Dishes"));
		restPage.chooseFromTopDishes();
	}

	@Severity(SeverityLevel.CRITICAL)
	@Description("Select order details & add it to basket")
	@Story("Test verify checkout orders")
	@Test(priority = 5, dependsOnMethods = "UserCanChooseFromTopDishes")
	public void UserCanSelectOrderDetails() {
		orderDetailsPage = new OrderDetailsPage(driver);
		orderDetailsPage.addToBasket();
	}
	
	@Severity(SeverityLevel.TRIVIAL)
	@Description("Sign out from el menus")
	@Story("Test verify checkout orders")
	@Test(priority = 6, dependsOnMethods = "UserCanSelectOrderDetails")
	public void UserCanSignOut() {
		home = new HomePage(driver);
		home.signOut();
	}
}
