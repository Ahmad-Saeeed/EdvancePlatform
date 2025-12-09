package PagesTests;

import Pages.CompanyLoginPage;
import org.testng.annotations.Test;
import org.testng.Assert;

public class CompanyLoginPageTest extends BaseTest {
        @Test
        public void validLoginTest() {

            // Step 1: Create the login page object

            CompanyLoginPage loginPage = new CompanyLoginPage(bot.driver);

            // Step 2: Navigate to login page
            loginPage.navigateToLoginPage();

            // Step 3: Enter valid email
            loginPage.enterValidEmail("company1@test.com");

            // Step 4: Enter valid password
            loginPage.enterValidPassword("password123");

            // Step 5: Click login button
            loginPage.clickLogin();

            // Step 6: Validate URL
            Assert.assertEquals(bot.driver.getCurrentUrl(),
                    "https://edvance-ace.vercel.app/company/dashboard");
        }
    }


