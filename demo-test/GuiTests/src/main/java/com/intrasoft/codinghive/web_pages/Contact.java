package com.intrasoft.codinghive.web_pages;

import com.intrasoft.codinghive.test_utils.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.Properties;

public class Contact extends BaseTest {

    @FindBy(name = "name")
    WebElement name;
    @FindBy(name = "address")
    WebElement address;
    @FindBy(name = "city")
    WebElement city;
    @FindBy(name = "phone")
    WebElement phone;
    @FindBy(name = "email")
    WebElement email;
    @FindBy(xpath = "//button[contains(text(),'Save')]")
    WebElement saveBtn;
    @FindBy(xpath = "//button[contains(.,'Delete')]")
    WebElement deleteBtn;
    @FindBy(xpath = "//a[text()='Back']")
    WebElement backBtn;
    @FindBy(xpath = "//a[text()='Edit']")
    WebElement editBtn;
    @FindBy(xpath = "//button[contains(text(),'Update')]")
    WebElement updateBtn;

    private final static String NAME = "Name";
    private final static String ADDRESS = "Address";
    private final static String CITY = "City";
    private final static String PHONE = "Phone";
    private final static String EMAIL = "Email";
    private final static String GENDER = "Gender";
    private final static String STATUS = "Status";

    public Contact() {
        initPageFactory();
    }

    public Contact inputData(Properties testData) {
        input(name, testData.getProperty(NAME));
        input(address, testData.getProperty(ADDRESS));
        dropdown(city, testData.getProperty(CITY));
        input(phone, testData.getProperty(PHONE));
        input(email, testData.getProperty(EMAIL));
        checkbox("Disabled", testData.getProperty(STATUS));
        radiobutton(testData.getProperty(GENDER));
        return this;
    }

    public Contact save() {
        saveBtn.click();
        waitForLoad();
        return this;
    }

    public Contact delete() {
        deleteBtn.click();
        driver.switchTo().alert().accept();
        driver.switchTo().defaultContent();
        waitForLoad();
        return this;
    }

    public Contact back() {
        backBtn.click();
        waitForLoad();
        return this;
    }

    public Contact edit() {
        editBtn.click();
        waitForLoad();
        return this;
    }

    public Contact update() {
        updateBtn.click();
        waitForLoad();
        return this;
    }

    public Contact verifyViewMode(Properties testData) {
        //Verify TITLE
        Assert.assertTrue(driver.findElement(By.xpath("//h3")).getText().equals(testData.getProperty(NAME)));

        //Verify address
        Assert.assertTrue(isElementPresent(By.xpath("//dt[contains(.,'Address')]/following-sibling::dd[contains(.,'" + testData.getProperty(ADDRESS) + "')]")));

        //Verify city
        Assert.assertTrue(isElementPresent(By.xpath("//dt[contains(.,'City')]/following-sibling::dd[contains(.,'" + testData.getProperty(CITY) + "')]")));

        //Verify phone
        Assert.assertTrue(isElementPresent(By.xpath("//dt[contains(.,'Phone')]/following-sibling::dd[contains(.,'" + testData.getProperty(PHONE) + "')]")));

        //Verify email
        Assert.assertTrue(isElementPresent(By.xpath("//dt[contains(.,'Email')]/following-sibling::dd[contains(.,'" + testData.getProperty(EMAIL) + "')]")));

        //Verify gender
        if (testData.getProperty(GENDER).equalsIgnoreCase("female"))
            Assert.assertTrue(isElementPresent(By.xpath("//dt[contains(.,'Gender')]/following-sibling::dd[contains(.,'Female')]")));
        else
            Assert.assertTrue(isElementPresent(By.xpath("//dt[contains(.,'Gender')]/following-sibling::dd[contains(.,'Male')]")));

        //Verify status
        if (testData.getProperty(STATUS).equalsIgnoreCase("enabled"))
            Assert.assertTrue(isElementPresent(By.xpath("//dt[contains(.,'Status')]/following-sibling::dd[contains(.,'enabled')]")));
        else
            Assert.assertFalse(isElementPresent(By.xpath("//dt[contains(.,'Status')]/following-sibling::dd[contains(.,'enabled')]")));

        //verify buttons
        Assert.assertTrue(isElementPresent(By.xpath("//a[text()='Edit']")));
        Assert.assertTrue(isElementPresent(By.xpath("//a[text()='Back']")));
        Assert.assertTrue(isElementPresent(By.xpath("//button[contains(.,'Delete')]")));

        return this;
    }

    public Contact verifyEditMode() {
        Assert.assertTrue(isElementPresent(By.xpath("//h3[contains(.,'Edit Contact')]")));
        return this;
    }

    private void input(WebElement input, String value) {
        if (value != null && !value.isEmpty()) {
            input.clear();
            input.sendKeys(value);
        }
    }

    private void dropdown(WebElement dropdown, String value) {
        if (value != null && !value.isEmpty()) {
            dropdown.click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[contains(@class,'ui-dropdown-item')]")));
            driver.findElement(By.xpath("//li[contains(@class,'ui-dropdown-item') and contains(.,'" + value + "')]")).click();
        }
    }

    private void checkbox(String checkboxLabel, String value) {
        if (value != null && !value.isEmpty()) {
            WebElement chbox;
            if (value.equalsIgnoreCase("enabled")) {
                chbox = driver.findElement(By.xpath("//label[text()='" + checkboxLabel + "']/preceding-sibling::input[@type='checkbox']"));
                if (chbox.isSelected()) {
                    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", chbox);
                }
            } else {
                chbox = driver.findElement(By.xpath("//label[text()='" + checkboxLabel + "']/preceding-sibling::input[@type='checkbox']"));
                if (!chbox.isSelected()) {
                    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", chbox);
                }
            }
        }
    }

    private void radiobutton(String value) {
        if (value != null && !value.isEmpty()) {
            if (value.equalsIgnoreCase("female")) {
                if (isElementPresent(By.xpath("//p-radiobutton[@value='m']//*[contains(@class,'ui-state-active')]"))) {
                    driver.findElement(By.xpath("//p-radiobutton[@value='f']//*[contains(@class,'ui-radiobutton-box')]")).click();
                }
            } else {
                if (isElementPresent(By.xpath("//p-radiobutton[@value='f']//*[contains(@class,'ui-state-active')]"))) {
                    driver.findElement(By.xpath("//p-radiobutton[@value='m']//*[contains(@class,'ui-radiobutton-box')]")).click();
                }
            }
        }
    }


}
