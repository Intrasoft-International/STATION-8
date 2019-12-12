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
        page.contactList()
                .selectContact(getTestData(1));

        page.contact()
                .verifyViewMode(getTestData(2))
                .back();

        page.contactList().verifyContactListPageOpens();
    }

}
