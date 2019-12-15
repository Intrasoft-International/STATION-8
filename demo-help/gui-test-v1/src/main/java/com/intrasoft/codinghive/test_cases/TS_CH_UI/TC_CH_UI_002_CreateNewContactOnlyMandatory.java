package com.intrasoft.codinghive.test_cases.TS_CH_UI;

import com.intrasoft.codinghive.test_utils.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_CH_UI_002_CreateNewContactOnlyMandatory extends BaseTest {

    @Test
    public void TC_CH_UI_002_CreateNewContactOnlyMandatory() {
        // select from menu Button > Add New Contact
        driver.findElement(By.id("newContact")).click();

        // wait for page to load
        waitForLoad();

        //only mandatory fields
        driver.findElement(By.name("name")).sendKeys("Contact 002");
        driver.findElement(By.name("email")).sendKeys("email002@intrasoft-intl.com");

        driver.findElement(By.name("city")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[contains(@class,'ui-dropdown-item')]")));
        driver.findElement(By.xpath("//li[contains(@class,'ui-dropdown-item') and contains(.,'Thessaloniki')]")).click();

        driver.findElement(By.xpath("//button[contains(text(),'Save')]")).click();

        //wait for page to load after successful creation of contact
        waitForLoad();

        //verify auto re-direction to Contact List Page
        Assert.assertTrue(isElementPresent(By.xpath("//h3[contains(.,'Contact List')]")));

        //verify that table contains contact 'Contact 002'
        Assert.assertTrue(isElementPresent(By.xpath("//table[contains(.,'Contact 002')]")));

    }

}
