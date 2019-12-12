package com.intrasoft.codinghive.web_pages;

import com.intrasoft.codinghive.test_utils.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.Properties;

public class ContactList extends BaseTest {

    @FindBy(xpath = "//input[@placeholder='Global Filter']")
    WebElement globalFilter;

    private final static String NAME = "Name";
    private final static String FILTER = "Filter";

    public ContactList() {
        initPageFactory();
    }

    public ContactList selectContact(Properties testData) {
        insertGlobalFilter(testData);
        clickDetails(testData);
        return this;
    }

    public ContactList verifyContactListPageOpens() {
        Assert.assertTrue(isElementPresent(By.xpath("//h3[contains(.,'Contact List')]")));
        return this;
    }

    public ContactList verifyContactListContent(Properties testData) {
        Assert.assertTrue(isElementPresent(By.xpath("//table[contains(.,'" + testData.getProperty(NAME) + "')]")));
        return this;
    }

    public ContactList verifyEmptyTable() {
        int numberOfRows = driver.findElements(By.xpath("//table//tbody[@class='ui-table-tbody']//tr")).size();
        Assert.assertEquals(numberOfRows, 0);
        return this;
    }

    private void insertGlobalFilter(Properties testData) {
        globalFilter.clear();
        globalFilter.sendKeys(testData.getProperty(FILTER));
    }

    private void clickDetails(Properties testData) {
        driver.findElement(By.xpath("//tbody[contains(.,'" + testData.getProperty(FILTER) + "')]//a[text()='Details']")).click();
        waitForLoad();
    }

}
