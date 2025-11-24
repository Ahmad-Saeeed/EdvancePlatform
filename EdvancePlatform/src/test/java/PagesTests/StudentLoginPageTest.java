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

        Assert.assertTrue(logPG.isWelcomeMessageExist());
    }

    @Test
    public void successfulLoginTest_Student2()
    {
        StudentLoginPage logPG = new StudentLoginPage(bot);
        logPG.navigateToLoginPage();
        logPG.enterSecValidEmail();
        logPG.enterValidPassword();
        logPG.clickONLoginButton();

        Assert.assertTrue(logPG.isWelcomeMessageExist());
    }

    @Test
    public void successfulLoginTest_Student3()
    {
        StudentLoginPage logPG = new StudentLoginPage(bot);
        logPG.navigateToLoginPage();
        logPG.enterThirdValidEmail();
        logPG.enterValidPassword();
        logPG.clickONLoginButton();

        Assert.assertTrue(logPG.isWelcomeMessageExist());
    }

    @Test
    public void unsuccessfulLoginTest()
    {
        StudentLoginPage logPG = new StudentLoginPage(bot);
        logPG.navigateToLoginPage();
        logPG.enterInvalidEmail();
        logPG.enterInvalidPassword();
        logPG.clickONLoginButton();

        Assert.assertTrue(logPG.erorrMsgDisplayed());
    }

    @Test
    public void forgetPasswordLinkTest()
    {
        StudentLoginPage logPG = new StudentLoginPage(bot);
        logPG.navigateToLoginPage();
        logPG.clickOnForgerPassword();

        String loginPageURL="https://edvance-ace.vercel.app/login";
        String currentURL;

        // check until URL changes
        do
        {
            currentURL=logPG.currentURL();

        }while (currentURL.equals(loginPageURL));

       Assert.assertTrue(currentURL.contains("forgot"));


    }

    @Test
    public void signUpLinkTest()
    {

        StudentLoginPage logPG = new StudentLoginPage(bot);
        logPG.navigateToLoginPage();
        logPG.clickOnRegisterNow();

        String loginPageURL="https://edvance-ace.vercel.app/login";
        String currentURL;

        // check until URL changes
        do
        {
            currentURL=logPG.currentURL();

        }while (currentURL.equals(loginPageURL));

        Assert.assertTrue(currentURL.contains("signup"));

    }



}


