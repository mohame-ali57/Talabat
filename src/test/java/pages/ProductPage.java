package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductPage {

    WebDriver driver;
    WebDriverWait wait;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    By chooseProduct = By.id("16");
    By addToCartBtn = By.name("save_to_cart");
    By cartBtn = By.id("shoppingCartLink");
    By checkOutBtn = By.id("checkOutButton");

    public void chooseProduct() {
        wait.until(ExpectedConditions.elementToBeClickable(chooseProduct)).click();
    }

    public void addToCart() {
        wait.until(ExpectedConditions.elementToBeClickable(addToCartBtn)).click();
    }

    public void openCart() {
        wait.until(ExpectedConditions.elementToBeClickable(cartBtn)).click();
    }

    public void clickCheckOut() {
        wait.until(ExpectedConditions.elementToBeClickable(checkOutBtn)).click();
    }
}