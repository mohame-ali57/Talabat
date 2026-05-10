package tests;

import base.BaseTest;
import pages.SearchPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SearchTest extends BaseTest {

    SearchPage searchPage;

    @BeforeMethod
    public void init() {

        searchPage = new SearchPage(driver);
    }

    @DataProvider(name = "foodItems")
    public Object[][] foodItems() {

        return new Object[][]{

                {"pizza"},
                {"كشري"},
                {"burger"},
                {"kfc"},
                {"sushi"}
        };
    }

    @Test(priority = 1)
    public void test_searchBoxVisible() {

        Assert.assertTrue(
                searchPage.isSearchBoxDisplayed(),
                "Search box should be visible"
        );
    }

    @Test(priority = 2)
    public void test_searchBoxEmpty() {

        String val = searchPage.getSearchBoxValue();

        Assert.assertTrue(
                val == null || val.isEmpty(),
                "Search box should be empty on load"
        );
    }

    @Test(priority = 3, dataProvider = "foodItems")
    public void test_searchWithFoodItems(String food) {

        searchPage.typeInSearchBox(food);

        searchPage.pressEnter();

        Assert.assertNotNull(
                driver.getCurrentUrl(),
                "Page should stay stable after searching: " + food
        );
    }
}