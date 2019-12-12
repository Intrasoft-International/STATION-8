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
        page.contactList()
                .selectContact(getTestData(1));

        page.contact()
                .edit()
                .verifyEditMode()
                .inputData(getTestData(2))
                .update()
                .verifyViewMode(getTestData(2));
    }

}
