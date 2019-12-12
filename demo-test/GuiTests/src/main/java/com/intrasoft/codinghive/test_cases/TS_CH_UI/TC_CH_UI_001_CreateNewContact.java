package com.intrasoft.codinghive.test_cases.TS_CH_UI;

import com.intrasoft.codinghive.test_utils.BaseTest;
import org.testng.annotations.Test;

public class TC_CH_UI_001_CreateNewContact extends BaseTest {

    @Test
    public void TC_CH_UI_001_CreateNewContact() {
        page.menu()
                .clickNewContact();

        page.contact()
                .inputData(getTestData())
                .save();

        page.contactList()
                .verifyContactListPageOpens()
                .verifyContactListContent(getTestData());
    }

}
