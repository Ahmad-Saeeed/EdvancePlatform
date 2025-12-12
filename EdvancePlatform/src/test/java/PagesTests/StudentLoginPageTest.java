package PagesTests;

import Pages.StudentLoginPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class StudentLoginPageTest extends BaseTest
{

    @Test
    public void forgetPasswordLinkTest()
    {
        StudentLoginPage logPG = new StudentLoginPage(bot);
        logPG.navigateToLoginPage();
        logPG.clickOnForgerPassword();

        String loginPageURL="https://edvance-ace.vercel.app/login";
        String currentURL;
        currentURL=logPG.currentURLAfterLoading(loginPageURL);
        Assert.assertTrue(currentURL.contains("forgot"));

    }

    @Test
    public void RegisterNowLinkTest()
    {

        StudentLoginPage logPG = new StudentLoginPage(bot);
        logPG.navigateToLoginPage();
        logPG.clickOnRegisterNow();

        String loginPageURL="https://edvance-ace.vercel.app/login";

        String currentURL=logPG.currentURLAfterLoading(loginPageURL);

        Assert.assertTrue(currentURL.contains("signup"));


    }

    @Test
    public void platformLogoNameFunctionalityTest()
    {
        StudentLoginPage logPG = new StudentLoginPage(bot);
        logPG.navigateToLoginPage();
        logPG.clickOnPlatformLogo();

        String loginPageURL="https://edvance-ace.vercel.app/login";
        String expectedURL="https://edvance-ace.vercel.app/";
        String actualURL=logPG.currentURLAfterLoading(loginPageURL);

        Assert.assertEquals(actualURL,expectedURL);

    }

    @Test
    public void featureOptionLinkTest()
    {
        StudentLoginPage logPG = new StudentLoginPage(bot);
        logPG.navigateToLoginPage();
        logPG.clikOnFeatureLink();

        String loginPageURL="https://edvance-ace.vercel.app/login";
        String expectedURL="https://edvance-ace.vercel.app/features";
        String actualURL=logPG.currentURLAfterLoading(loginPageURL);

        Assert.assertEquals(actualURL,expectedURL);

    }

    @Test
    public void aboutUsOptionLinkTest()
    {
        StudentLoginPage logPG = new StudentLoginPage(bot);
        logPG.navigateToLoginPage();
        logPG.clickOnAboutUs();

        String loginPageURL="https://edvance-ace.vercel.app/login";
        String expectedURL="https://edvance-ace.vercel.app/about";
        String actualURL=logPG.currentURLAfterLoading(loginPageURL);

        Assert.assertEquals(actualURL,expectedURL);

    }

    @Test
    public void contactUsOptionLinkTest()
    {
        StudentLoginPage logPG = new StudentLoginPage(bot);
        logPG.navigateToLoginPage();
        logPG.clickOnContactUs();

        String loginPageURL="https://edvance-ace.vercel.app/login";
        String expectedURL="https://edvance-ace.vercel.app/contact";
        String actualURL=logPG.currentURLAfterLoading(loginPageURL);

        Assert.assertEquals(actualURL,expectedURL);

    }

  /*
   @Test
    public void themeControlIcon()
    {
        StudentLoginPage logPG = new StudentLoginPage(bot);
        logPG.navigateToLoginPage();
        logPG.clickOnThemeIcon();

        Assert??

    }
*/


    @Test
    public void languageTogglingTest()
    {
        StudentLoginPage logPG = new StudentLoginPage(bot);
        logPG.navigateToLoginPage();
        String originalDisplayedLettersOnLanguageIcon= logPG.checkLanguageIcon();
        logPG.clickOnLanguageIcon();
        String currentDisplayedLettersOnLanguageIcon= logPG.checkLanguageIcon();

        if (originalDisplayedLettersOnLanguageIcon.equals("ع"))
        {
            Assert.assertEquals(currentDisplayedLettersOnLanguageIcon,"EN");
        }
        else
        {
            Assert.assertEquals(currentDisplayedLettersOnLanguageIcon,"ع");
        }



    }

    @Test
    public void loginLinkFromHeaderTest()
    {
        StudentLoginPage logPG = new StudentLoginPage(bot);
        logPG.navigateToLoginPage();
        logPG.clickOnLoginLinkFromHeader();

        String expectedURL="https://edvance-ace.vercel.app/login";
        String actualURL=logPG.currentURL();

        Assert.assertEquals(actualURL,expectedURL);

    }

    @Test
    public void joinForFreeButtonFromHeaderTest()
    {
        StudentLoginPage logPG = new StudentLoginPage(bot);
        logPG.navigateToLoginPage();
        logPG.clickOnJoinForFreeButtonFromHeader();

        String expectedURL="https://edvance-ace.vercel.app/signup";
        String actualURL=logPG.currentURLAfterLoading("https://edvance-ace.vercel.app/login");

        Assert.assertEquals(actualURL,expectedURL);

    }

    @Test (dataProvider = "Login Data")
    public void loginForm(String email, String password, String testcase)
    {
        StudentLoginPage loginPage = new StudentLoginPage(bot);
        loginPage.navigateToLoginPage();
        loginPage.enterEmailAccount(email);
        loginPage.enterPassword(password);
        loginPage.clickONLoginButton();

        switch (testcase)
        {
            case "Successful Login":
                Assert.assertTrue(loginPage.welcomeMessageDisplayed());
                break;
            case "Invalid email account with correct password":
                Assert.assertTrue(loginPage.errorMsgDisplayed());
                break;
            case "Invalid password with correct email account":
                Assert.assertTrue(loginPage.errorMsgDisplayed());
                break;

            case "Invalid email format":
                Assert.assertTrue(loginPage.invalidEmailErrorMsgDisplayed());
                break;

            case "Invalid password format":
                Assert.assertTrue(loginPage.passwordFieldErrorMsgDisplayed());
                break;
        }

    }

    @DataProvider(name = "Login Data")
    public Object[][] loginData()
    {
        return new Object[][]{
                {"student1@test.com","password123","Successful Login"},
                {"student2@test.com","password123","Successful Login"},
                {"student3@test.com","password123","Successful Login"},
               {"kk@jake.com","password123","Invalid email account with correct password"},
                {"student1@test.com","12345678","Invalid password with correct email account"},
               {"tester@xyz","password123","Invalid email format"},
                {"student1@test.com","1234567","Invalid password format"}

        };
    }



}


