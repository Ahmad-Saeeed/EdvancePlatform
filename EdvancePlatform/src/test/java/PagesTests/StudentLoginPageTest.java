package PagesTests;

import Pages.StudentLoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class StudentLoginPageTest extends BaseTest {


        @Test
        public void successfulLoginTest()
        {
            StudentLoginPage logPG = new StudentLoginPage(bot);
            logPG.navigateToLoginPage();
            logPG.enterFirstValidEmail();
            logPG.enterValidPassword();
            logPG.clickONLoginButton();

            String expectedURL = "لوحة التحكم";
           /* String actualURL = logPG.textget();
            Assert.assertEquals(actualURL, expectedURL);
        */}
    }


