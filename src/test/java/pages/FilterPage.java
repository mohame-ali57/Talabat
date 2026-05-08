package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class FilterPage {
    WebDriver driver;
    WebDriverWait wait;

    public FilterPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    By filterRating = By.id("top_rated-0");
    By filterFreeDelivery = By.id("free_delivery-1");
    By confirmButton = By.cssSelector("button[data-testid='filter-submit-btn']");
    By restaurantCards = By.cssSelector("a[data-testid='restaurant-a']");

    public void filterByRating() {
        WebElement ratingCheckbox = wait.until(
            ExpectedConditions.elementToBeClickable(filterRating)
        );
        ratingCheckbox.click();
        System.out.println("Rating 4.0+ filter selected");
    }

    public void filterByFreeDelivery() {
        WebElement deliveryCheckbox = wait.until(
            ExpectedConditions.elementToBeClickable(filterFreeDelivery)
        );
        deliveryCheckbox.click();
        System.out.println("Free delivery filter selected");
    }

    public void confirmFilters() {
        WebElement confirm = wait.until(
            ExpectedConditions.elementToBeClickable(confirmButton)
        );
        confirm.click();
        try { Thread.sleep(2000); }
        catch (InterruptedException e) { e.printStackTrace(); }
    }

    public int getRestaurantCount() {
        List<WebElement> cards = driver.findElements(restaurantCards);
        System.out.println("Restaurants found: " + cards.size());
        return cards.size();
    }
}