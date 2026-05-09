package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CountryPage;

public class ChangeCountryTest extends BaseTest {

    @Test
    public void changeCountry() {

        driver.get("https://www.talabat.com/ar/egypt");

        CountryPage page = new CountryPage(driver);

        // Kuwait

        page.openDropdown();

        page.selectKuwait();

        Assert.assertTrue(
                driver.getCurrentUrl().contains("kuwait"));

        System.out.println(
                "Kuwait selected successfully");

        // Jordan

        page.openDropdown();

        page.selectJordan();

        Assert.assertTrue(
                driver.getCurrentUrl().contains("jordan"));

        System.out.println(
                "Jordan selected successfully");
    }
}