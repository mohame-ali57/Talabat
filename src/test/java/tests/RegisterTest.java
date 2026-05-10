package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.RegisterPage;

public class RegisterTest extends BaseTest {

    @Test
    public void register() {

        driver.get("https://advantageonlineshopping.com/");

        HomePage homePage = new HomePage(driver);
        RegisterPage registerPage = new RegisterPage(driver);

        int x = (int) (Math.random() * 9000);

        String username = "test" + x;
        String mail = "test" + x + "@gmail.com";

        System.out.println(username);
        System.out.println(mail);

        homePage.clickLoginBtn();
        homePage.clickSignUp();

        registerPage.setInfo(
                username,
                mail,
                "Mohamed123@#",
                "Mohamed123@#",
                "Mohamed",
                "Ali",
                "01012345678",
                "Cairo",
                "Nasr City",
                "Cairo",
                "12345");

        registerPage.selectCountry("Egypt");
        registerPage.clickRegister();
    }
}