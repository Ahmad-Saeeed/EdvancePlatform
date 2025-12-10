package PagesTests;

import Pages.TeacherDashBoardPage;
import Pages.TeacherLoginPage;
import Utilities.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class TeacherLoginPageTest extends BaseTest{
    TeacherLoginPage loginPage;
    @BeforeMethod
    public void setupPages() {
        loginPage = new TeacherLoginPage(bot);
        loginPage.navigateandValidLogin();
    }
    @Test
    public void successfullLoginTestTeacher1(){
        loginPage.enterEmail(ConfigReader.getProperty("teacher1Email"));
        loginPage.enterPassword(ConfigReader.getProperty("teacher.validPassword"));
        loginPage.clickOnLoginButton();
        Assert.assertTrue(loginPage.checkWelcomeMessage());
    }
    @Test
    public void successfullLoginTestTeacher2(){
        loginPage.enterEmail(ConfigReader.getProperty("teacher2Email"));
        loginPage.enterPassword(ConfigReader.getProperty("teacher.validPassword"));
        loginPage.clickOnLoginButton();
        Assert.assertTrue(loginPage.checkWelcomeMessage());
    }
    @Test
    public void successfullLoginTestTeacher3(){
        loginPage.enterEmail(ConfigReader.getProperty("teacher3Email"));
        loginPage.enterPassword(ConfigReader.getProperty("teacher.validPassword"));
        loginPage.clickOnLoginButton();
        Assert.assertTrue(loginPage.checkWelcomeMessage());
    }
    @Test
    public void successfullLoginTestTeacher4(){
        loginPage.enterEmail(ConfigReader.getProperty("teacher4Email"));
        loginPage.enterPassword(ConfigReader.getProperty("teacher.validPassword"));
        loginPage.clickOnLoginButton();
        Assert.assertTrue(loginPage.checkWelcomeMessage());
    }
    @Test
    public void invalidLoginEmailTest(){
        loginPage.enterEmail(ConfigReader.getProperty("invalidEmail"));
        loginPage.enterPassword(ConfigReader.getProperty("teacher.validPassword"));
        loginPage.clickOnLoginButton();
        Assert.assertTrue(loginPage.loginErrorMesDisplayed());
    }
    @Test
    public void invalidLoginPassTest(){
        loginPage.enterEmail(ConfigReader.getProperty("teacher1Email"));
        loginPage.enterPassword(ConfigReader.getProperty("teacher.invalidPassword"));
        loginPage.clickOnLoginButton();
        Assert.assertTrue(loginPage.loginErrorMesDisplayed());
    }

    @Test
    public void forggotPasswordTest(){
        loginPage.forggotPasswordClick();
        Assert.assertTrue(loginPage.checkForggotPassPagelanding());
    }

    @Test
    public void registerNowTest(){
        loginPage.registerNowClick();
        Assert.assertTrue(loginPage.checkRegisterPageLanding());
    }
    @Test
    public void featuresPageTest(){
        loginPage.featureClick();
        Assert.assertTrue(loginPage.checkFeaturePageLanding());
    }
    @Test
    public void aboutUsPageTest(){
        loginPage.aboutUsClick();
        Assert.assertTrue(loginPage.checkAboutUsPageLanding());
    }

    @Test
    public void contactUsPageTest(){
        loginPage.contactUsClick();
        Assert.assertTrue(loginPage.checkContactUsPageLanding());
    }
    @Test
    public void themeToggleTest(){
        loginPage.themeToggleLClick();
        Assert.assertTrue(loginPage.checkThemeToggleFunction());
    }
    @Test
    public void checkLanguageToggleButton() {
        String defaultLanguage = loginPage.checkLanguageIcon();

        loginPage.languageButtonLClick();

        String expectedLanguage = defaultLanguage.equals("ع") ? "EN" : "ع";
        String currentLanguage = loginPage.checkLanguageIcon();

        Assert.assertEquals(currentLanguage, expectedLanguage, "Language toggle failed!");
    }
    @Test
    public void joinFreeTest(){
        loginPage.joinFreeClick();
        Assert.assertTrue(loginPage.checkJoinFreePageLanding());
    }

}
