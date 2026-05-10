package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

    WebDriver driver;
    WebDriverWait wait;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    By loginBtn = By.id("menuUserSVGPath");
    By createAccount = By.linkText("CREATE NEW ACCOUNT");
    By shopProduct = By.id("tabletsImg");

    // loader اللي بيغطي الصفحة
    By loader = By.cssSelector("div.loader");

    public void waitForLoaderToDisappear() {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));
    }

    public void clickLoginBtn() {
        waitForLoaderToDisappear();
        wait.until(ExpectedConditions.elementToBeClickable(loginBtn)).click();
    }

    public void clickSignUp() {
        waitForLoaderToDisappear();
        wait.until(ExpectedConditions.elementToBeClickable(createAccount)).click();
    }

    public void shopProduct() {
        waitForLoaderToDisappear();
        wait.until(ExpectedConditions.elementToBeClickable(shopProduct)).click();
    }
}