package com.intrasoft.codinghive.web_pages;

import com.intrasoft.codinghive.test_utils.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Menu extends BaseTest {

    @FindBy(id = "newContact")
    WebElement addNewContactBtn;
    @FindBy(id = "listOfContacts")
    WebElement contactListBtn;

    public Menu () {
        initPageFactory();
    }

    public Menu clickNewContact(){
        addNewContactBtn.click();
        waitForLoad();
        return this;
    }

    public Menu clickContactList(){
        contactListBtn.click();
        waitForLoad();
        return this;
    }

}
