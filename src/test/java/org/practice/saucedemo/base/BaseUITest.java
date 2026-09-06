package org.practice.saucedemo.base;

import com.microsoft.playwright.Page;
import org.practice.saucedemo.factory.DriverFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

/** Browser setup and cleanup shared by all UI test cases. */
public abstract class BaseUITest {
    protected static final String BASE_URL = System.getProperty(
            "baseUrl",
            "https://www.saucedemo.com/"
    );

    private DriverFactory driverFactory;
    private Page page;

    @Parameters("browser")
    @BeforeMethod(alwaysRun = true)
    public final void setUp(@Optional("chromium") String browserFromXml) {
        String browser = System.getProperty("browser", browserFromXml);
        boolean headless = Boolean.parseBoolean(System.getProperty("headless", "true"));

        driverFactory = new DriverFactory();
        page = driverFactory.createPage(browser, headless);
        initializePages();
    }

    protected abstract void initializePages();

    protected final Page getPage() {
        return page;
    }

    @AfterMethod(alwaysRun = true)
    public final void tearDown() {
        if (driverFactory != null) {
            driverFactory.close();
            driverFactory = null;
        }
        page = null;
    }
}
