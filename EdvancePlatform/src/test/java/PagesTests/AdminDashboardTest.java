


package PagesTests;

import Pages.AdminDashboardPage;
import Pages.AdminLoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AdminDashboardTest extends BaseTest {

    private static final String LOGIN_URL = "https://edvance-ace.vercel.app/login";
    private static final String VALID_USERNAME = "admin@edvance.com";
    private static final String VALID_PASSWORD = "Admin@123";

    private AdminDashboardPage dashboardPage;

    @BeforeClass
    public void loginBeforeTests() {
        AdminLoginPage loginPage = new AdminLoginPage(bot);

        loginPage.navigateToLoginPage(LOGIN_URL)
                .enterUsername(VALID_USERNAME)
                .enterPassword(VALID_PASSWORD)
                .clickLoginButton();

        dashboardPage = new AdminDashboardPage(bot);
    }

    @Test(description = "Verify dashboard page is displayed after login")
    public void testDashboardIsDisplayed() {
        Assert.assertTrue(dashboardPage.isDashboardDisplayed(),
                "Dashboard should be displayed after successful login");
    }

    @Test(description = "Verify dashboard URL contains 'dashboard'")
    public void testDashboardURL() {
        String currentUrl = dashboardPage.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("dashboard") || currentUrl.contains("home"),
                "URL should contain 'dashboard' or 'home' after login");
    }

    @Test(description = "Verify dashboard title is displayed")
    public void testDashboardTitle() {
        String title = dashboardPage.getDashboardTitle();
        Assert.assertFalse(title.isEmpty(),
                "Dashboard title should not be empty");
    }

    @Test(description = "Verify navigation menu is displayed")
    public void testNavigationMenu() {
        Assert.assertTrue(dashboardPage.isNavigationMenuDisplayed(),
                "Navigation menu should be visible on dashboard");
    }

    @Test(description = "Verify user can logout successfully")
    public void testLogout() {
        String dashboardUrl = dashboardPage.getCurrentUrl();

        AdminLoginPage loginPage = dashboardPage.logout();

        // Wait for URL to change
        String newUrl = bot.getURLWhenItChanges(dashboardUrl);

        // Verify redirected to login page
        Assert.assertTrue(newUrl.contains("login"),
                "Should be redirected to login page after logout");

        // Verify login button is visible again
        Assert.assertTrue(loginPage.isLoginButtonDisplayed(),
                "Login button should be displayed after logout");
    }
}





