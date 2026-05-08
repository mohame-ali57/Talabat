package tests;

import base.BaseTest;
import org.testng.annotations.Test;

public class OpenTalabatTest extends BaseTest {

    @Test
    public void openWebsite() {

        System.out.println(driver.getTitle());
    }
}