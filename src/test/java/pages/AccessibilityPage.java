package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class AccessibilityPage {

    WebDriver driver;
    WebDriverWait wait;

    public AccessibilityPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    By htmlTag = By.tagName("html");
    By bodyTag = By.tagName("body");
    By allImages = By.tagName("img");

    // Get lang attribute
    public String getLangAttribute() {

        WebElement html = wait.until(
                ExpectedConditions.visibilityOfElementLocated(htmlTag)
        );

        String lang = html.getAttribute("lang");

        System.out.println("HTML lang: " + lang);

        return lang;
    }

    // Get dir attribute
    public String getDirAttribute() {

        WebElement html = wait.until(
                ExpectedConditions.visibilityOfElementLocated(htmlTag)
        );

        String dir = html.getAttribute("dir");

        if (dir == null || dir.isEmpty()) {

            WebElement body = driver.findElement(bodyTag);

            dir = body.getAttribute("dir");
        }

        System.out.println("Dir attribute: " + dir);

        return dir;
    }

    // Count images without alt
    public int getImagesWithoutAltCount() {

        List<WebElement> images = driver.findElements(allImages);

        int count = 0;

        for (WebElement img : images) {

            String alt = img.getAttribute("alt");

            if (alt == null || alt.trim().isEmpty()) {

                count++;

                System.out.println(
                        "Image without alt: "
                                + img.getAttribute("src")
                );
            }
        }

        System.out.println("Images without alt count: " + count);

        return count;
    }

    // Get page title
    public String getPageTitle() {

        String title = driver.getTitle();

        System.out.println("Page title: " + title);

        return title;
    }
}