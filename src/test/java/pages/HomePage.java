package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HomePage {

    WebDriver driver;
    WebDriverWait wait;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    By searchBox = By.id("search-box-map-first");

    // كل عناصر الدروب داون
    By suggestions = By.cssSelector("div, li, span");

    public void search(String text) {

        WebElement box = wait.until(
                ExpectedConditions.elementToBeClickable(searchBox)
        );

        box.click();
        box.sendKeys(Keys.CONTROL + "a");
        box.sendKeys(Keys.DELETE);

        box.sendKeys(text);

        // ⛔ مهم جداً: انتظار ظهور الاقتراحات
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(suggestions));

        // 📌 نجمع النتائج ونطبعها
        List<WebElement> list = driver.findElements(suggestions);

        System.out.println("===== Suggestions =====");

        for (WebElement el : list) {
            String txt = el.getText();
            if (txt != null && !txt.trim().isEmpty()) {
                System.out.println(txt);
            }
        }

        // ⛔ مهم: نوقف التنفيذ عشان تشوف النتيجة
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}