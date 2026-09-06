package org.practice.saucedemo.web.pages.base;

import com.microsoft.playwright.Page;

/** Common behavior shared by every page object. */
public class BasePage {
    protected final Page page;

    public BasePage(Page page) {
        this.page = page;
    }

    public void open(String url) {
        page.navigate(url);
    }
}
