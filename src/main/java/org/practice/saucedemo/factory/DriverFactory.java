package org.practice.saucedemo.factory;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public final class DriverFactory implements AutoCloseable {

    private Playwright playwright;
    private Browser browser;
    private BrowserContext browserContext;

    public Page createPage(String browserName, boolean headless) {
        playwright = Playwright.create();

        BrowserType browserType = switch (browserName.toLowerCase()) {
            case "firefox" -> playwright.firefox();
            case "webkit" -> playwright.webkit();
            case "chrome", "chromium" -> playwright.chromium();
            default -> throw new IllegalArgumentException(
                    "Unsupported browser: " + browserName
            );
        };

        browser = browserType.launch(
                new BrowserType.LaunchOptions().setHeadless(headless)
        );
        browserContext = browser.newContext();
        return browserContext.newPage();
    }

    @Override
    public void close() {
        if (browserContext != null) {
            browserContext.close();
            browserContext = null;
        }

        if (browser != null) {
            browser.close();
            browser = null;
        }

        if (playwright != null) {
            playwright.close();
            playwright = null;
        }
    }
}
