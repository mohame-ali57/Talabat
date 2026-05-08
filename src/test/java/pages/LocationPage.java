package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class LocationPage {
    WebDriver driver;
    WebDriverWait wait;

    public LocationPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(25));
    }

    By searchBox = By.id("search-box-map-first");
    By dropdownItems = By.cssSelector("ul[data-testid='drop-down-address-list-component'] li");

    public void selectLocation(String location) {
        WebElement box = wait.until(
            ExpectedConditions.visibilityOfElementLocated(searchBox)
        );
        box.click();
        box.clear();
        box.sendKeys(location);

        
        wait.until(ExpectedConditions.visibilityOfElementLocated(dropdownItems));

        
        List<WebElement> items = driver.findElements(dropdownItems);
        if (items.isEmpty()) {
            throw new RuntimeException("Dropdown is empty for: " + location);
        }

        WebElement firstItem = items.get(0);
        wait.until(ExpectedConditions.elementToBeClickable(firstItem));

        
        ((JavascriptExecutor) driver).executeScript(
            "arguments[0].scrollIntoView(true);", firstItem
        );
        ((JavascriptExecutor) driver).executeScript(
            "arguments[0].click();", firstItem
        );

     
        wait.until(driver ->
            driver.getCurrentUrl().contains("restaurants")
        );
    }
}