package PagesTests;

import Pages.AdminLoginPage;
import Pages.AdminDashboardPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AdminLoginTest extends BaseTest {

    private static final String LOGIN_URL = "https://edvance-ace.vercel.app/login";
    private static final String VALID_USERNAME = "admin@edvance.com";
    private static final String VALID_PASSWORD = "Admin@123";

    @Test(description = "Verify successful login with valid credentials")
    public void testSuccessfulLogin() {
        AdminLoginPage loginPage = new AdminLoginPage(bot);
        AdminDashboardPage dashboardPage = new AdminDashboardPage(bot);

        loginPage.navigateToLoginPage(LOGIN_URL)
                .enterUsername(VALID_USERNAME)
                .enterPassword(VALID_PASSWORD)
                .clickLoginButton();

        // Verify navigation to dashboard
        String currentUrl = dashboardPage.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("dashboard"),
                "User should be redirected to dashboard after successful login");

        // Verify dashboard is displayed
        Assert.assertTrue(dashboardPage.isDashboardDisplayed(),
                "Dashboard should be displayed after successful login");
    }


    @Test(description = "Verify login fails with invalid username")
    public void testLoginWithInvalidUsername() {
        AdminLoginPage loginPage = new AdminLoginPage(bot);

        loginPage.navigateToLoginPage(LOGIN_URL)
                .enterUsername("invalidUser")
                .enterPassword(VALID_PASSWORD)
                .clickLoginButton();

        // Verify error message is displayed
        Assert.assertTrue(loginPage.isErrorMessageDisplayed(),
                "Error message should be displayed for invalid credentials");

        String errorMsg = loginPage.getErrorMessage();
        Assert.assertFalse(errorMsg.isEmpty(),
                "Error message text should not be empty");
    }

    @Test(description = "Verify login fails with invalid password")
    public void testLoginWithInvalidPassword() {
        AdminLoginPage loginPage = new AdminLoginPage(bot);

        loginPage.navigateToLoginPage(LOGIN_URL)
                .enterUsername(VALID_USERNAME)
                .enterPassword("wrongPassword")
                .clickLoginButton();

        // Verify error message is displayed
        Assert.assertTrue(loginPage.isErrorMessageDisplayed(),
                "Error message should be displayed for invalid password");
    }

    @Test(description = "Verify login fails with empty credentials")
    public void testLoginWithEmptyCredentials() {
        AdminLoginPage loginPage = new AdminLoginPage(bot);

        loginPage.navigateToLoginPage(LOGIN_URL)
                .enterUsername("")
                .enterPassword("")
                .clickLoginButton();

        // Verify error message or stay on login page
        String currentUrl = bot.driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("login"),
                "User should remain on login page with empty credentials");
    }

    @Test(description = "Verify login button is displayed on page load")
    public void testLoginButtonIsDisplayed() {
        AdminLoginPage loginPage = new AdminLoginPage(bot);

        loginPage.navigateToLoginPage(LOGIN_URL);

        Assert.assertTrue(loginPage.isLoginButtonDisplayed(),
                "Login button should be visible on the login page");
    }

    @Test(description = "Verify forgot password link functionality")
    public void testForgotPasswordLink() {
        AdminLoginPage loginPage = new AdminLoginPage(bot);

        String oldUrl = LOGIN_URL;
        loginPage.navigateToLoginPage(oldUrl)
                .clickForgotPassword();

        // Verify URL changed to forgot password page
        String newUrl = bot.getURLWhenItChanges(oldUrl);
        Assert.assertTrue(newUrl.contains("forgot") || newUrl.contains("reset"),
                "Should navigate to forgot password page");
    }
}