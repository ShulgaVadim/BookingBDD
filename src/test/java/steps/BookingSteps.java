package steps;

import com.codeborne.selenide.Configuration;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import pages.SearchResultPage;

import java.util.List;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class BookingSteps {
    private static final String URL = "https://www.booking.com/searchresults.en-gb.html";
    private static final String SEARCH_FIELD = "ss";
    private static final String SEARCH_BUTTON = ".sb-searchbox__button";
    SearchResultPage searchResultPage = new SearchResultPage();

    @Before
    public void initializeBrowser() {
        Configuration.clickViaJs = true;
        Configuration.timeout = 4000;
        Configuration.startMaximized = true;
    }

    @Given("User opens search page")
    public void userOpensSearchPage() {
        open(URL);
    }

    @Given("Name of the hotel is {string}")
    public void nameOfTheHotelIs(String hotel) {
        $(By.id(SEARCH_FIELD)).sendKeys(hotel);
    }

    @When("User does search")
    public void userDoesSearch() {
        $(SEARCH_BUTTON).click();
    }

    @Then("Hotel {string} is on the first page")
    public void hotelIsOnTheFirstPage(String hotelName) {
        searchResultPage.isPageOpened();
        List<String> hotels = searchResultPage.getResults();
        assertTrue(hotels.contains(hotelName));
    }

    @And("Hotel {string} has {string}")
    public void ratingShouldBe(String hotelName, String rating) {
        String expectedRating = searchResultPage.getRatingFor(hotelName);
        assertEquals(expectedRating, rating, "Рейтинг не соответствует");
    }
    @After
    public void closeBrowser() {
        getWebDriver().quit();
    }
}
