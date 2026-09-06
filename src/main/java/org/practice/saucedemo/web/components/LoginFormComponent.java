package org.practice.saucedemo.web.components;

import com.microsoft.playwright.Page;

/** Reusable controls and actions belonging to the login form. */
public class LoginFormComponent {
    private static final String USERNAME_INPUT = "[data-test='username']";
    private static final String PASSWORD_INPUT = "[data-test='password']";
    private static final String LOGIN_BUTTON = "[data-test='login-button']";
    private static final String ERROR_MESSAGE = "[data-test='error']";

    private final Page page;

    public LoginFormComponent(Page page) {
        this.page = page;
    }

    public void loginAs(String username, String password) {
        page.locator(USERNAME_INPUT).fill(username);
        page.locator(PASSWORD_INPUT).fill(password);
        page.locator(LOGIN_BUTTON).click();
    }

    public String getErrorMessage() {
        return page.locator(ERROR_MESSAGE).innerText().trim();
    }
}
