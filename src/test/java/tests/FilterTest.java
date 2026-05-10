package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LocationPage;
import pages.FilterPage;

public class FilterTest extends BaseTest {

    @Test
    public void filterRestaurantsByRatingAndDelivery() {

        driver.get("https://www.talabat.com/ar/egypt");

        LocationPage locationPage = new LocationPage(driver);
        locationPage.selectLocation("Cairo Festival City");

        FilterPage filterPage = new FilterPage(driver);

        int beforeFilter = filterPage.getRestaurantCount();
        System.out.println("Before filter: " + beforeFilter);

        filterPage.filterByRating();
        filterPage.filterByFreeDelivery();
        filterPage.filterByFastDelivery();
        filterPage.confirmFilters();

        int afterFilter = filterPage.getRestaurantCount();
        System.out.println("After filter: " + afterFilter);

        Assert.assertTrue(
                afterFilter > 0,
                "Should show restaurants after filtering");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Filter test passed successfully!");
    }
}