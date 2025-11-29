package PagesTests;

import Pages.TeacherLoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TeacherLoginPageTest extends BaseTest{
    //TeacherLoginPage loginPage = new TeacherLoginPage(bot);
    @Test
    public void successfullLoginTestTeacher1(){
        TeacherLoginPage loginPage = new TeacherLoginPage(bot);
        loginPage.navigateToLoginPage();
        loginPage.enter1stValidEmail();
        loginPage.enterValidPassword();
        loginPage.clickOnLoginButton();
        Assert.assertTrue(loginPage.checkWelcomeMessage());
    }
    @Test
    public void successfullLoginTestTeacher2(){
        TeacherLoginPage loginPage = new TeacherLoginPage(bot);
        loginPage.navigateToLoginPage();
        loginPage.enter2ndtValidEmail();
        loginPage.enterValidPassword();
        loginPage.clickOnLoginButton();
        Assert.assertTrue(loginPage.checkWelcomeMessage());
    }
    @Test
    public void successfullLoginTestTeacher3(){
        TeacherLoginPage loginPage = new TeacherLoginPage(bot);
        loginPage.navigateToLoginPage();
        loginPage.enter3rdValidEmail();
        loginPage.enterValidPassword();
        loginPage.clickOnLoginButton();
        Assert.assertTrue(loginPage.checkWelcomeMessage());
    }
    @Test
    public void successfullLoginTestTeacher4(){
        TeacherLoginPage loginPage = new TeacherLoginPage(bot);
        loginPage.navigateToLoginPage();
        loginPage.enter4thValidEmail();
        loginPage.enterValidPassword();
        loginPage.clickOnLoginButton();
        Assert.assertTrue(loginPage.checkWelcomeMessage());
    }
    @Test
    public void invalidLoginEmailTest(){
        TeacherLoginPage loginPage = new TeacherLoginPage(bot);
        loginPage.navigateToLoginPage();
        loginPage.enterInvalidEmail();
        loginPage.enterValidPassword();
        loginPage.clickOnLoginButton();
        Assert.assertTrue(loginPage.loginErrorMesDisplayed());
    }
    @Test
    public void invalidLoginPassTest(){
        TeacherLoginPage loginPage = new TeacherLoginPage(bot);
        loginPage.navigateToLoginPage();
        loginPage.enter1stValidEmail();
        loginPage.enterInvalidPassword();
        loginPage.clickOnLoginButton();
        Assert.assertTrue(loginPage.loginErrorMesDisplayed());
    }

    @Test
    public void forggotPasswordTest(){
        TeacherLoginPage loginPage = new TeacherLoginPage(bot);
        loginPage.navigateToLoginPage();
        loginPage.forggotPasswordClick();
        Assert.assertTrue(loginPage.checkForggotPassPagelanding());
    }

    @Test
    public void registerNowTest(){
        TeacherLoginPage loginPage = new TeacherLoginPage(bot);
        loginPage.navigateToLoginPage();
        loginPage.registerNowClick();
        Assert.assertTrue(loginPage.checkRegisterPageLanding());
    }
    @Test
    public void featuresPageTest(){
        TeacherLoginPage loginPage = new TeacherLoginPage(bot);
        loginPage.navigateToLoginPage();
        loginPage.featureClick();
        Assert.assertTrue(loginPage.checkFeaturePageLanding());
    }
    @Test
    public void aboutUsPageTest(){
        TeacherLoginPage loginPage = new TeacherLoginPage(bot);
        loginPage.navigateToLoginPage();
        loginPage.aboutUsClick();
        Assert.assertTrue(loginPage.checkAboutUsPageLanding());
    }

    @Test
    public void contactUsPageTest(){
        TeacherLoginPage loginPage = new TeacherLoginPage(bot);
        loginPage.navigateToLoginPage();
        loginPage.contactUsClick();
        Assert.assertTrue(loginPage.checkContactUsPageLanding());
    }
    @Test
    public void themeToggleTest(){
        TeacherLoginPage loginPage = new TeacherLoginPage(bot);
        loginPage.navigateToLoginPage();
        loginPage.themeToggleLClick();
        Assert.assertTrue(loginPage.checkThemeToggleFunction());
    }
    @Test
    public void languageToggleTest(){
        TeacherLoginPage loginPage = new TeacherLoginPage(bot);
        loginPage.navigateToLoginPage();
        String defaultLanguage = loginPage.checkLanguageIcon();
        loginPage.languageButtonLClick();
        String currentLanguageOnIcon = loginPage.checkLanguageIcon();
        if (defaultLanguage.equals("ع")){
            Assert.assertEquals(currentLanguageOnIcon,"EN");
        }else
            Assert.assertEquals(currentLanguageOnIcon,"ع");


    }
    @Test
    public void joinFreeTest(){
        TeacherLoginPage loginPage = new TeacherLoginPage(bot);
        loginPage.navigateToLoginPage();
        loginPage.joinFreeClick();
        Assert.assertTrue(loginPage.checkJoinFreePageLanding());
    }

}
