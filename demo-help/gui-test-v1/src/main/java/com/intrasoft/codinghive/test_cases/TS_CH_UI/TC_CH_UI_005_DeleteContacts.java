package com.intrasoft.codinghive.test_cases.TS_CH_UI;

import com.intrasoft.codinghive.test_utils.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_CH_UI_005_DeleteContacts extends BaseTest {

    @Test
    public void TC_CH_UI_005_DeleteContacts() {
        // Global Filter filtering name
        driver.findElement(By.xpath("//input[@placeholder='Global Filter']")).sendKeys("Contact 001a");
        waitForLoad();

        //click on Details
        driver.findElement(By.xpath("//tbody[contains(.,'Contact 001a')]//a[text()='Details']")).click();
        waitForLoad();

        // Delete Contact
        driver.findElement(By.xpath("//button[contains(.,'Delete')]")).click();
        driver.switchTo().alert().accept();
        driver.switchTo().defaultContent();
        waitForLoad();

        // Repeat Delete Action for rest Contacts
        driver.findElement(By.xpath("//input[@placeholder='Global Filter']")).sendKeys("Contact 002");
        waitForLoad();
        driver.findElement(By.xpath("//tbody[contains(.,'Contact 002')]//a[text()='Details']")).click();
        waitForLoad();
        driver.findElement(By.xpath("//button[contains(.,'Delete')]")).click();
        driver.switchTo().alert().accept();
        driver.switchTo().defaultContent();
        waitForLoad();

        // VERIFY THAT TABLE IS EMPTY AFTER DELETING ALL CONTACTS
        int numberOfRows = driver.findElements(By.xpath("//table//tbody[@class='ui-table-tbody']//tr")).size();
        Assert.assertEquals(numberOfRows, 0);
    }

}
