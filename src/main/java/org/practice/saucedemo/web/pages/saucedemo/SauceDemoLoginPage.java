package org.practice.saucedemo.web.pages.saucedemo;

import com.microsoft.playwright.Page;
import org.practice.saucedemo.web.components.LoginFormComponent;
import org.practice.saucedemo.web.pages.base.BasePage;

/** Page object representing the complete SauceDemo login page. */
public class SauceDemoLoginPage extends BasePage {
    private static final String PRODUCT_TITLE = "[data-test='title']";

    private final LoginFormComponent loginForm;

    public SauceDemoLoginPage(Page page) {
        super(page);
        loginForm = new LoginFormComponent(page);
    }

    public void openLoginPage(String baseUrl) {
        open(baseUrl);
    }

    public LoginFormComponent loginForm() {
        return loginForm;
    }

    public String getProductTitle() {
        return page.locator(PRODUCT_TITLE).innerText().trim();
    }
}
