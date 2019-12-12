package com.intrasoft.codinghive.test_utils;

import com.intrasoft.codinghive.web_pages.Contact;
import com.intrasoft.codinghive.web_pages.ContactList;
import com.intrasoft.codinghive.web_pages.Menu;

public class Page extends BaseTest {

    private Menu menu;
    private Contact contact;
    private ContactList contactList;

    public Menu menu() {
        synchronized (this) {
            if (menu == null) {
                menu = new Menu();
            }
        }
        return menu;
    }

    public Contact contact() {
        synchronized (this) {
            if (contact == null) {
                contact = new Contact();
            }
        }
        return contact;
    }

    public ContactList contactList() {
        synchronized (this) {
            if (contactList == null) {
                contactList = new ContactList();
            }
        }
        return contactList;
    }
}
