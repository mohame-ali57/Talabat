package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegisterPage {

    WebDriver driver;
    WebDriverWait wait;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    By username = By.name("usernameRegisterPage");
    By email = By.name("emailRegisterPage");
    By password = By.name("passwordRegisterPage");
    By confirmPassword = By.name("confirm_passwordRegisterPage");
    By firstName = By.name("first_nameRegisterPage");
    By lastName = By.name("last_nameRegisterPage");
    By phoneNumber = By.name("phone_numberRegisterPage");
    By country = By.name("countryListboxRegisterPage");
    By city = By.name("cityRegisterPage");
    By address = By.name("addressRegisterPage");
    By region = By.name("state_/_province_/_regionRegisterPage");
    By postalCode = By.name("postal_codeRegisterPage");
    By agree = By.name("i_agree");
    By registerBtn = By.id("register_btn");

    public void setInfo(
            String user,
            String mail,
            String pass,
            String confirmPass,
            String fName,
            String lName,
            String phone,
            String cityName,
            String userAddress,
            String userRegion,
            String pCode) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(username)).sendKeys(user);
        wait.until(ExpectedConditions.visibilityOfElementLocated(email)).sendKeys(mail);
        wait.until(ExpectedConditions.visibilityOfElementLocated(password)).sendKeys(pass);
        wait.until(ExpectedConditions.visibilityOfElementLocated(confirmPassword)).sendKeys(confirmPass);
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstName)).sendKeys(fName);
        wait.until(ExpectedConditions.visibilityOfElementLocated(lastName)).sendKeys(lName);
        wait.until(ExpectedConditions.visibilityOfElementLocated(phoneNumber)).sendKeys(phone);
        wait.until(ExpectedConditions.visibilityOfElementLocated(city)).sendKeys(cityName);
        wait.until(ExpectedConditions.visibilityOfElementLocated(address)).sendKeys(userAddress);
        wait.until(ExpectedConditions.visibilityOfElementLocated(region)).sendKeys(userRegion);
        wait.until(ExpectedConditions.visibilityOfElementLocated(postalCode)).sendKeys(pCode);
        wait.until(ExpectedConditions.elementToBeClickable(agree)).click();
    }

    public void selectCountry(String countryName) {
        WebElement countryDropdown = wait.until(
                ExpectedConditions.visibilityOfElementLocated(country));

        Select selectCountry = new Select(countryDropdown);
        selectCountry.selectByVisibleText(countryName);
    }

    public void clickRegister() {
        wait.until(ExpectedConditions.elementToBeClickable(registerBtn)).click();
    }
}