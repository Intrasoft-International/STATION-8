package com.intrasoft.codinghive.test_cases.TS_CH_UI;

import com.intrasoft.codinghive.test_utils.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_CH_UI_004_SearchAndEditContact extends BaseTest {

    @Test
    public void TC_CH_UI_004_SearchAndEditContact() {
        // Global Filter filtering name
        driver.findElement(By.xpath("//input[@placeholder='Global Filter']")).sendKeys("Contact 001");
        waitForLoad();

        //click on Details
        driver.findElement(By.xpath("//tbody[contains(.,'Contact 001')]//a[text()='Details']")).click();
        waitForLoad();

        // click EDIT
        driver.findElement(By.xpath("//a[text()='Edit']")).click();
        waitForLoad();

        // verify that EDIT CONTACT page opens
        Assert.assertTrue(isElementPresent(By.xpath("//h3[contains(.,'Edit Contact')]")));

        //UPDATE ALL FIELDS (clear and insert new value)
        driver.findElement(By.name("name")).clear();
        driver.findElement(By.name("name")).sendKeys("Contact 001a");

        driver.findElement(By.name("address")).clear();
        driver.findElement(By.name("address")).sendKeys("Address 001a");

        driver.findElement(By.name("phone")).clear();
        driver.findElement(By.name("phone")).sendKeys("2101111111a");

        driver.findElement(By.name("email")).clear();
        driver.findElement(By.name("email")).sendKeys("email001a@intrasoft-intl.com");

        driver.findElement(By.name("city")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[contains(@class,'ui-dropdown-item')]")));
        driver.findElement(By.xpath("//li[contains(@class,'ui-dropdown-item') and contains(.,'Thessaloniki')]")).click();

        // CHECKBOX
        WebElement chbox;
        String status = "disabled"; // enabled or disabled
        if (status.equalsIgnoreCase("enabled")) {
            chbox = driver.findElement(By.xpath("//label[text()='Disabled']/preceding-sibling::input[@type='checkbox']"));
            if (chbox.isSelected()) {
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", chbox);
            }
        } else {
            chbox = driver.findElement(By.xpath("//label[text()='Disabled']/preceding-sibling::input[@type='checkbox']"));
            if (!chbox.isSelected()) {
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", chbox);
            }
        }

        // RADIOBUTTON
        String gender = "male"; // male or female
        if(gender.equalsIgnoreCase("female")) {
            if (isElementPresent(By.xpath("//p-radiobutton[@value='m']//*[contains(@class,'ui-state-active')]"))){
                driver.findElement(By.xpath("//p-radiobutton[@value='f']//*[contains(@class,'ui-radiobutton-box')]")).click();
            }
        } else {
            if (isElementPresent(By.xpath("//p-radiobutton[@value='f']//*[contains(@class,'ui-state-active')]"))){
                driver.findElement(By.xpath("//p-radiobutton[@value='m']//*[contains(@class,'ui-radiobutton-box')]")).click();
            }
        }

        // BUTTON
        driver.findElement(By.xpath("//button[contains(text(),'Update')]")).click();
        waitForLoad();

        // VERIFY CHANGES
        //Verify TITLE
        Assert.assertTrue(isElementPresent(By.xpath("//h3[contains(.,'Contact 001a')]")));

        //Verify address
        Assert.assertTrue(isElementPresent(By.xpath("//dt[contains(.,'Address')]/following-sibling::dd[contains(.,'Address 001a')]")));

        //Verify city
        Assert.assertTrue(isElementPresent(By.xpath("//dt[contains(.,'City')]/following-sibling::dd[contains(.,'Thessaloniki')]")));

        //Verify phone
        Assert.assertTrue(isElementPresent(By.xpath("//dt[contains(.,'Phone')]/following-sibling::dd[contains(.,'2101111111a')]")));

        //Verify email
        Assert.assertTrue(isElementPresent(By.xpath("//dt[contains(.,'Email')]/following-sibling::dd[contains(.,'email001a@intrasoft-intl.com')]")));

        //Verify gender
        Assert.assertTrue(isElementPresent(By.xpath("//dt[contains(.,'Gender')]/following-sibling::dd[contains(.,'Male')]")));

        //Verify status
        Assert.assertTrue(isElementPresent(By.xpath("//dt[contains(.,'Status')]/following-sibling::dd[contains(.,'disabled')]")));

    }

}
