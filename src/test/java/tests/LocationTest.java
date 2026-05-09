package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.LocationPage;

public class LocationTest extends BaseTest {

    @Test
    public void selectArea() {

        driver.get("https://www.talabat.com/ar/egypt");

        LocationPage page = new LocationPage(driver);

        page.selectLocation("maadi");

        System.out.println("Selected location successfully");

    }
}