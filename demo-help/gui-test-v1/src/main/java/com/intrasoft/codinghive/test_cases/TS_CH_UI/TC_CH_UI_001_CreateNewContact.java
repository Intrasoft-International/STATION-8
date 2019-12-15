package com.intrasoft.codinghive.test_cases.TS_CH_UI;

import com.intrasoft.codinghive.test_utils.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_CH_UI_001_CreateNewContact extends BaseTest {

    @Test
    public void TC_CH_UI_001_CreateNewContact() {
        // select from menu Button > Add New Contact
        driver.findElement(By.id("newContact")).click();

        // wait for page to load
        waitForLoad();

        //common input fields
        driver.findElement(By.name("name")).sendKeys("Contact 001");
        driver.findElement(By.name("address")).sendKeys("Address 001");
        driver.findElement(By.name("phone")).sendKeys("2101111111");
        driver.findElement(By.name("email")).sendKeys("email001@intrasoft-intl.com");

        // DROPDOWN
            // not working for p-dropdown
            //new Select(driver.findElement(By.name("city"))).selectByVisibleText("Athens");

            // not working for p-dropdown
            //driver.findElement(By.name("city")).click();
            //new Select(driver.findElement(By.name("city"))).selectByVisibleText("Athens");
        driver.findElement(By.name("city")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[contains(@class,'ui-dropdown-item')]")));
        driver.findElement(By.xpath("//li[contains(@class,'ui-dropdown-item') and contains(.,'Athens')]")).click();

        // CHECKBOX
        //label[text()='Disabled']/preceding-sibling::input[@type='checkbox']

        // common click() is not working for angular primeng checkbox
        //driver.findElement(By.xpath("//label[text()='Disabled']/preceding-sibling::input[@type='checkbox']")).click();

        // with ACTIONS is not working. no error but no clicking too
        //WebElement chbox = driver.findElement(By.xpath("//label[text()='Disabled']/preceding-sibling::input[@type='checkbox']"));
        //Actions action = new Actions(driver);
        //action.click(chbox).perform();

        // with JAVASCRIPT EXECUTOR works properly

        //System.out.println("VALUE BEFORE CLICKING:" + driver
        //        .findElement(By.xpath("//label[text()='Disabled']/preceding-sibling::input[@type='checkbox']"))
        //        .getAttribute("value"));
        //WebElement chbox = driver.findElement(By.xpath("//label[text()='Disabled']/preceding-sibling::input[@type='checkbox']"));
        //((JavascriptExecutor) driver).executeScript("arguments[0].click();", chbox);
        //System.out.println("VALUE AFTER CLICKING:" + driver
        //        .findElement(By.xpath("//label[text()='Disabled']/preceding-sibling::input[@type='checkbox']"))
        //        .getAttribute("value"));

        //if (driver.findElement(By.xpath("//label[text()='Disabled']/preceding-sibling::input[@type='checkbox']")).isSelected()) {
        //    System.out.println("SELECTED");
        //} else {
        //    System.out.println("NOT SELECTED");
        //}
        //((JavascriptExecutor) driver).executeScript("arguments[0].click();", driver.findElement(By.xpath("//label[text()='Disabled']/preceding-sibling::input[@type='checkbox']")));
        //if (driver.findElement(By.xpath("//label[text()='Disabled']/preceding-sibling::input[@type='checkbox']")).isSelected()) {
        //    System.out.println("SELECTED");
        //} else {
        //    System.out.println("NOT SELECTED");
        //}

        // WHEN the desired option is to ENABLE the contact
        //  IF the checkbox is unchecked
        //      no action
        //  ELSE
        //      check the checkbox
        // WHEN the desired option is to DISABLE the contact
        //  IF the checkbox is unchecked
        //      check the checkbox
        //  ELSE
        //      no action

        WebElement chbox;
        String status = "enabled"; // enabled or disabled
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
        //System.out.println("Selected Gender:" + driver.findElement(By.xpath("//p-radiobutton[@value='f']")).isSelected());
        //
        //if (isElementPresent(By.xpath("//p-radiobutton[@value='f']//*[contains(@class,'ui-state-active')]"))){
        //    System.out.println("Selected Gender: female");
        //} else {
        //    if (isElementPresent(By.xpath("//p-radiobutton[@value='m']//*[contains(@class,'ui-state-active')]"))) {
        //        System.out.println("Selected Gender: male");
        //    }
        //}
        //
        //driver.findElement(By.xpath("//p-radiobutton[@value='m']")).click();
        //
        //driver.findElement(By.xpath("//p-radiobutton[@value='m']//*[contains(@class,'ui-radiobutton-box')]")).click();
        //
        //if (isElementPresent(By.xpath("//p-radiobutton[@value='f']//*[contains(@class,'ui-state-active')]"))){
        //    System.out.println("Selected Gender: female");
        //} else {
        //    if (isElementPresent(By.xpath("//p-radiobutton[@value='m']//*[contains(@class,'ui-state-active')]"))) {
        //        System.out.println("Selected Gender: male");
        //    }
        //}
        //
        //WHEN the desired option for gender is FEMALE
        //IF the selected radiobutton is FEMALE
        //THEN no action
        //ELSE
        //IF the selected rariobutton is MALE
        //THEN select FEMALE
        //
        //WHEN the desired option for gender is MALE
        //IF the selected radiobutton is FEMALE
        //THEN select MALE
        //ELSE
        //IF the selected rariobutton is MALE
        //THEN no action

        WebElement radiobutton;
        String gender = "female"; // male or female
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
        driver.findElement(By.xpath("//button[contains(text(),'Save')]")).click();

        //wait for page to load after successful creation of contact
        waitForLoad();

        //verify auto re-direction to Contact List Page
        Assert.assertTrue(isElementPresent(By.xpath("//h3[contains(.,'Contact List')]")));

        //verify that table contains contact 'Contact 001'
        Assert.assertTrue(isElementPresent(By.xpath("//table[contains(.,'Contact 001')]")));

    }

}
