package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AccessibilityPage;

public class AccessibilityTest extends BaseTest {

    @Test
    public void testAccessibility() {

        driver.get("https://www.talabat.com/egypt");

        AccessibilityPage access = new AccessibilityPage(driver);

        // Test lang attribute
        String lang = access.getLangAttribute();
        Assert.assertTrue(
                lang != null && (lang.contains("ar") || lang.contains("en")),
                "FAIL → Language attribute not detected properly"
        );

        // Test dir attribute
        String dir = access.getDirAttribute();
        Assert.assertTrue(
                dir != null && (dir.equals("rtl") || dir.equals("ltr")),
                "FAIL → Direction attribute not detected properly"
        );

        // Test alt attributes
        int imagesWithoutAlt = access.getImagesWithoutAltCount();
        Assert.assertTrue(
                imagesWithoutAlt < 10,
                "FAIL → Too many images without alt"
        );

        // Test title
        String title = access.getPageTitle();
        Assert.assertFalse(
                title.trim().isEmpty(),
                "FAIL → Page title is empty"
        );

        System.out.println("Accessibility test passed successfully!");
    }
}