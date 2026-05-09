package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CountryPage {

    WebDriver driver;

    WebDriverWait wait;

    public CountryPage(WebDriver driver) {

        this.driver = driver;

        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    By countryDropdown = By.cssSelector("[data-testid='country-switcher']");

    By kuwaitOption = By.xpath("//span[contains(text(),'Kuwait')]");

    By jordanOption = By.xpath("//span[contains(text(),'Jordan')]");

    public void openDropdown() {

        WebElement dropdown = wait.until(
                ExpectedConditions.elementToBeClickable(
                        countryDropdown));

        dropdown.click();
    }

    public void selectKuwait() {

        WebElement kuwait = wait.until(
                ExpectedConditions.elementToBeClickable(
                        kuwaitOption));

        kuwait.click();
    }

    public void selectJordan() {

        WebElement jordan = wait.until(
                ExpectedConditions.elementToBeClickable(
                        jordanOption));

        jordan.click();
    }
}