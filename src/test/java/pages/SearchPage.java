package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class SearchPage {

    WebDriver driver;

    By searchBox = By.cssSelector("input[data-testid='rest-search-box']");

    public SearchPage(WebDriver driver) {

        this.driver = driver;

        driver.get("https://www.talabat.com/egypt/restaurants/9838/maadi-old-el-nahda-street");

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void typeInSearchBox(String text) {

        driver.findElement(searchBox).clear();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(searchBox).sendKeys(text);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void pressEnter() {

        driver.findElement(searchBox).sendKeys(Keys.ENTER);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public boolean isSearchBoxDisplayed() {

        return driver.findElement(searchBox).isDisplayed();
    }

    public String getSearchBoxValue() {

        return driver.findElement(searchBox).getAttribute("value");
    }
}