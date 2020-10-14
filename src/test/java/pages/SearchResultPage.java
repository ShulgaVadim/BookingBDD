package pages;

import com.codeborne.selenide.Condition;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import java.util.List;

import static com.codeborne.selenide.Selenide.*;

@Log4j2
public class SearchResultPage {
    private static final String HOTEL_NAME = ".sr-hotel__name";
    private static final String HOTEL_RATING = "//span[contains(text(), '%s')]/ancestor::div[@class='sr_item_main_block']/following::*//div[@class='bui-review-score__badge']";
    private static final String STRING_RESULT = "[data-block-id=\"heading\"]";

    public SearchResultPage isPageOpened() {
        $(By.cssSelector(STRING_RESULT)).waitUntil(Condition.visible, 30);
        return new SearchResultPage();
    }

    public List<String> getResults() {
        List<String> results = $$(HOTEL_NAME).texts();
        log.info("The found hotels on first page: " + results);
        return results;
    }

    public String getRatingFor(String hotelName) {
        return $(By.xpath(String.format(HOTEL_RATING, hotelName))).text();
    }
}

