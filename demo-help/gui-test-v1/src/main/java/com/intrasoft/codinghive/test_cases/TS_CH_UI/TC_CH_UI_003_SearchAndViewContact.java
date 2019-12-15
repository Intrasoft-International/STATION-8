package com.intrasoft.codinghive.test_cases.TS_CH_UI;

import com.intrasoft.codinghive.test_utils.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_CH_UI_003_SearchAndViewContact extends BaseTest {

    @Test
    public void TC_CH_UI_003_SearchAndViewContact() {
        // Global Filter filtering name
        driver.findElement(By.xpath("//input[@placeholder='Global Filter']")).sendKeys("Contact 001");
        waitForLoad();

        //click on Details
        driver.findElement(By.xpath("//tbody[contains(.,'Contact 001')]//a[text()='Details']")).click();
        waitForLoad();

        //Verify TITLE
        Assert.assertTrue(isElementPresent(By.xpath("//h3[contains(.,'Contact 001')]")));
        //alternatively
        Assert.assertTrue(driver.findElement(By.xpath("//h3")).getText().equals("Contact 001"));

        //Verify address
        Assert.assertTrue(isElementPresent(By.xpath("//dd[contains(.,'Address 001')]")));
        // verify including label to verify that values are following the correct labels
        Assert.assertTrue(isElementPresent(By.xpath("//dt[contains(.,'Address')]/following-sibling::dd[contains(.,'Address 001')]")));

        //Verify city
        Assert.assertTrue(isElementPresent(By.xpath("//dt[contains(.,'City')]/following-sibling::dd[contains(.,'Athens')]")));

        //Verify phone
        Assert.assertTrue(isElementPresent(By.xpath("//dt[contains(.,'Phone')]/following-sibling::dd[contains(.,'2101111111')]")));

        //Verify email
        Assert.assertTrue(isElementPresent(By.xpath("//dt[contains(.,'Email')]/following-sibling::dd[contains(.,'email001@intrasoft-intl.com')]")));

        //Verify gender
        Assert.assertTrue(isElementPresent(By.xpath("//dt[contains(.,'Gender')]/following-sibling::dd[contains(.,'Female')]")));

        //Verify status
        Assert.assertTrue(isElementPresent(By.xpath("//dt[contains(.,'Status')]/following-sibling::dd[contains(.,'enabled')]")));

        //verify buttons
        Assert.assertTrue(isElementPresent(By.xpath("//a[text()='Edit']")));
        Assert.assertTrue(isElementPresent(By.xpath("//a[text()='Back']")));
        Assert.assertTrue(isElementPresent(By.xpath("//button[contains(.,'Delete')]")));

        // go Back
        driver.findElement(By.xpath("//a[text()='Back']")).click();
        waitForLoad();

        // verify go Back works properly
        Assert.assertTrue(isElementPresent(By.xpath("//h3[contains(.,'Contact List')]")));
    }

}
