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
        page.contactList()
                .selectContact(getTestData(1));
        page.contact()
                .delete();

        page.contactList()
                .selectContact(getTestData(2));
        page.contact()
                .delete();

        page.contactList()
                .verifyEmptyTable();
    }

}
