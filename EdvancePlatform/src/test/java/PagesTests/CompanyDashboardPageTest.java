package PagesTests;

import Pages.CompanyDashboardPage;
import Pages.CompanyLoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CompanyDashboardPageTest extends BaseTest {

    @Test
    public void verifyDashboardStats() {

        // Step 1: Login
        CompanyLoginPage loginPage = new CompanyLoginPage(bot.driver);
        loginPage.navigateToLoginPage();
        loginPage.enterValidEmail("company1@test.com");
        loginPage.enterValidPassword("password123");
        loginPage.clickLogin();

        // Step 2: Create dashboard page object
        CompanyDashboardPage dashboard = new CompanyDashboardPage(bot.driver);

        // Step 3: Verify stats (example)
        Assert.assertEquals(dashboard.getTotalJobs(), "3");
        Assert.assertEquals(dashboard.getActiveJobs(), "3");


    }
}
