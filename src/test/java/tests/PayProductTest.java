package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.PaymentPage;
import pages.ProductPage;

public class PayProductTest extends BaseTest {

    @Test
    public void payProduct() {

        driver.get("https://advantageonlineshopping.com/");

        HomePage homePage = new HomePage(driver);
        ProductPage productPage = new ProductPage(driver);
        PaymentPage paymentPage = new PaymentPage(driver);

        homePage.shopProduct();

        productPage.chooseProduct();
        productPage.addToCart();
        productPage.openCart();
        productPage.clickCheckOut();

        paymentPage.setInfo("test1661", "Mohamed123@#");

        productPage.openCart();
        productPage.clickCheckOut();

        paymentPage.clickNextBtn();
        paymentPage.setPayment("Mohamed", "Mohamed12@");

        paymentPage.verifyThankMessage();
    }
}