package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LanguagePage {

    WebDriver driver;

    WebDriverWait wait;

    public LanguagePage(WebDriver driver) {

        this.driver = driver;

        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    By languageButton =
            By.cssSelector(
                    "[data-testid='switch-language-link']"
            );

    public void switchLanguage() {

        String oldUrl = driver.getCurrentUrl();

        WebElement button = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        languageButton
                )
        );

        button.click();

        wait.until(driver ->
                !driver.getCurrentUrl().equals(oldUrl)
        );
    }
}