package PagesTests;

import Pages.StudentLoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class StudentLoginPageTest extends BaseTest
{
    @Test
    public void successfulLoginTest_Student1()
    {
        StudentLoginPage logPG = new StudentLoginPage(bot);
        logPG.navigateToLoginPage();
        logPG.enterFirstValidEmail();
        logPG.enterValidPassword();
        logPG.clickONLoginButton();

        Assert.assertTrue(logPG.welcomeMessageDisplayed());
    }

    @Test
    public void successfulLoginTest_Student2()
    {
        StudentLoginPage logPG = new StudentLoginPage(bot);
        logPG.navigateToLoginPage();
        logPG.enterSecValidEmail();
        logPG.enterValidPassword();
        logPG.clickONLoginButton();

        Assert.assertTrue(logPG.welcomeMessageDisplayed());
    }

    @Test
    public void successfulLoginTest_Student3()
    {
        StudentLoginPage logPG = new StudentLoginPage(bot);
        logPG.navigateToLoginPage();
        logPG.enterThirdValidEmail();
        logPG.enterValidPassword();
        logPG.clickONLoginButton();

        Assert.assertTrue(logPG.welcomeMessageDisplayed());
    }

    @Test
    public void unsuccessfulLoginTest()
    {
        StudentLoginPage logPG = new StudentLoginPage(bot);
        logPG.navigateToLoginPage();
        logPG.enterInvalidEmail();
        logPG.enterInvalidPassword();
        logPG.clickONLoginButton();

        Assert.assertTrue(logPG.errorMsgDisplayed());
    }

    @Test
    public void forgetPasswordLinkTest()
    {
        StudentLoginPage logPG = new StudentLoginPage(bot);
        logPG.navigateToLoginPage();
        logPG.clickOnForgerPassword();

        String loginPageURL="https://edvance-ace.vercel.app/login";
        String currentURL;

        // check until URL changes (Manual way)
        /*

            do
            {
                currentURL=logPG.currentURL();

            }while (currentURL.equals(loginPageURL));

         */

        // This function handles changing in the URL while maintaining waiting times out period
        //i.e. if the url doesn't change it will give times out exception

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





}


