package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LanguagePage;

public class ChangeLanguageTest extends BaseTest {

    @Test
    public void changeLanguage() {

        driver.get("https://www.talabat.com/ar/egypt");

        LanguagePage page =
                new LanguagePage(driver);

        page.switchLanguage();

        String currentUrl =
                driver.getCurrentUrl();

        Assert.assertFalse(
                currentUrl.contains("/ar/")
        );

        System.out.println(
                "Language changed successfully"
        );
    }
}