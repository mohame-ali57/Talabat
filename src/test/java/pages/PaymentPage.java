package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class PaymentPage {

    WebDriver driver;
    WebDriverWait wait;

    public PaymentPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(25));
    }

    By loader = By.cssSelector("div.loader");

    By username = By.name("usernameInOrderPayment");
    By password = By.name("passwordInOrderPayment");
    By loginBtn = By.id("login_btn");

    By nextBtn = By.id("next_btn");

    By safePayUsername = By.name("safepay_username");
    By safePayPassword = By.name("safepay_password");
    By safePayLoginBtn = By.id("pay_now_btn_SAFEPAY");

    By thankMessage = By.cssSelector("span[translate='Thank_you_for_buying_with_Advantage']");

    public void waitForLoaderToDisappear() {
        try {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));
        } catch (Exception ignored) {
        }
    }

    public void setInfo(String user, String pass) {

        waitForLoaderToDisappear();

        wait.until(ExpectedConditions.visibilityOfElementLocated(username)).sendKeys(user);
        wait.until(ExpectedConditions.visibilityOfElementLocated(password)).sendKeys(pass);
        wait.until(ExpectedConditions.elementToBeClickable(loginBtn)).click();

        waitForLoaderToDisappear();
    }

    public void clickNextBtn() {

        waitForLoaderToDisappear();

        WebElement nextButton = wait.until(
                ExpectedConditions.elementToBeClickable(nextBtn)
        );

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block: 'center'});",
                nextButton
        );

        nextButton.click();

        waitForLoaderToDisappear();
    }

    public void setPayment(String safeUser, String safePass) {

        waitForLoaderToDisappear();

        WebElement safeUsernameInput = wait.until(
                ExpectedConditions.visibilityOfElementLocated(safePayUsername)
        );

        safeUsernameInput.clear();
        safeUsernameInput.sendKeys(safeUser);

        WebElement safePasswordInput = wait.until(
                ExpectedConditions.visibilityOfElementLocated(safePayPassword)
        );

        safePasswordInput.clear();
        safePasswordInput.sendKeys(safePass);

        waitForLoaderToDisappear();

        WebElement payNowButton = wait.until(
                ExpectedConditions.presenceOfElementLocated(safePayLoginBtn)
        );

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block: 'center'});",
                payNowButton
        );

        wait.until(ExpectedConditions.elementToBeClickable(safePayLoginBtn));

        payNowButton.click();

        waitForLoaderToDisappear();
    }

    public void verifyThankMessage() {

        waitForLoaderToDisappear();

        String actualMessage = wait.until(
                ExpectedConditions.visibilityOfElementLocated(thankMessage)
        ).getText();

        Assert.assertEquals(
                actualMessage,
                "Thank you for buying with Advantage"
        );
    }
}