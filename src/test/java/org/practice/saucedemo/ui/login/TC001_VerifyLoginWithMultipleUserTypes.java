package org.practice.saucedemo.ui.login;

import org.practice.saucedemo.base.BaseUITest;
import org.practice.saucedemo.web.pages.saucedemo.SauceDemoLoginPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/** One test case, executed once for each login dataset. */
public class TC001_VerifyLoginWithMultipleUserTypes extends BaseUITest {
    private static final String VALID_PASSWORD = "secret_sauce";

    private SauceDemoLoginPage loginPage;

    @Override
    protected void initializePages() {
        loginPage = new SauceDemoLoginPage(getPage());
    }

    @Test(
            dataProvider = "loginData",
            description = "TC001 - Verify login with multiple user types"
    )
    public void verifyLoginWithMultipleUserTypes(
            String username,
            boolean shouldLoginSuccessfully,
            String expectedMessage
    ) {
        loginPage.openLoginPage(BASE_URL);
        loginPage.loginForm().loginAs(username, VALID_PASSWORD);

        if (shouldLoginSuccessfully) {
            Assert.assertEquals(loginPage.getProductTitle(), expectedMessage);
        } else {
            Assert.assertEquals(loginPage.loginForm().getErrorMessage(), expectedMessage);
        }
    }

    @DataProvider(name = "loginData")
    public Object[][] loginData() {
        return new Object[][]{
                {"standard_user", true, "Products"},
                {"locked_out_user", false,
                        "Epic sadface: Sorry, this user has been locked out."},
                {"problem_user", true, "Products"},
                {"performance_glitch_user", true, "Products"},
                {"error_user", true, "Products"},
                {"visual_user", true, "Products"}
        };
    }
}
