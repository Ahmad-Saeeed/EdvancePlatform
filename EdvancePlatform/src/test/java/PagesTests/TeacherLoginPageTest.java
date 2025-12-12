package PagesTests;


import Pages.TeacherLoginPage;
import Utilities.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class TeacherLoginPageTest extends BaseTest {
    TeacherLoginPage loginPage;

    @BeforeMethod
    public void setupPages() {
        loginPage = new TeacherLoginPage(bot);

    }


    @Test
    public void successfullLoginTestTeacher1() {
        loginPage.navigateToLoginPage();
        loginPage.enterEmail(ConfigReader.getProperty("teacher.properties","teacher1Email"));
        loginPage.enterPassword(ConfigReader.getProperty("teacher.properties","teacher.validPassword"));
        loginPage.clickOnLoginButton();
        Assert.assertTrue(loginPage.checkWelcomeMessage(), "Failed: Teacher 1 could not login successfully!");
    }

    @Test
    public void successfullLoginTestTeacher2() {
        loginPage.navigateToLoginPage();
        loginPage.enterEmail(ConfigReader.getProperty("teacher.properties","teacher2Email"));
        loginPage.enterPassword(ConfigReader.getProperty("teacher.properties","teacher.validPassword"));
        loginPage.clickOnLoginButton();
        Assert.assertTrue(loginPage.checkWelcomeMessage(), "Failed: Teacher 2 could not login successfully!");
    }

    @Test
    public void successfullLoginTestTeacher3() {
        loginPage.navigateToLoginPage();
        loginPage.enterEmail(ConfigReader.getProperty("teacher.properties","teacher3Email"));
        loginPage.enterPassword(ConfigReader.getProperty("teacher.properties","teacher.validPassword"));
        loginPage.clickOnLoginButton();
        Assert.assertTrue(loginPage.checkWelcomeMessage(), "Failed: Teacher 3 could not login successfully!");
    }

    @Test
    public void successfullLoginTestTeacher4() {
        loginPage.navigateToLoginPage();
        loginPage.enterEmail(ConfigReader.getProperty("teacher.properties","teacher4Email"));
        loginPage.enterPassword(ConfigReader.getProperty("teacher.properties","teacher.validPassword"));
        loginPage.clickOnLoginButton();
        Assert.assertTrue(loginPage.checkWelcomeMessage(), "Failed: Teacher 4 could not login successfully!");
    }

    @Test
    public void invalidLoginEmailTest() {
        loginPage.navigateToLoginPage();
        loginPage.enterEmail(ConfigReader.getProperty("teacher.properties","invalidEmail"));
        loginPage.enterPassword(ConfigReader.getProperty("teacher.properties","teacher.validPassword"));
        loginPage.clickOnLoginButton();
        Assert.assertTrue(loginPage.loginErrorMesDisplayed());
    }

    @Test
    public void invalidLoginPassTest() {
        loginPage.navigateToLoginPage();
        loginPage.enterEmail(ConfigReader.getProperty("teacher.properties","teacher1Email"));
        loginPage.enterPassword(ConfigReader.getProperty("teacher.properties","teacher.invalidPassword"));
        loginPage.clickOnLoginButton();
        Assert.assertTrue(loginPage.loginErrorMesDisplayed(), "Failed: Error message was NOT displayed for invalid email!");
    }

    @Test
    public void forggotPasswordTest() {
        loginPage.navigateToLoginPage();
        loginPage.forggotPasswordClick();
        Assert.assertTrue(loginPage.checkForggotPassPagelanding(), "Failed: Forgot Password page did NOT load!");
    }

    @Test
    public void registerNowTest() {
        loginPage.navigateToLoginPage();
        loginPage.registerNowClick();
        Assert.assertTrue(loginPage.checkRegisterPageLanding(), "Failed: Register page did NOT load!");
    }

    @Test
    public void featuresPageTest() {
        loginPage.navigateToLoginPage();
        loginPage.featureClick();
        Assert.assertTrue(loginPage.checkFeaturePageLanding(), "Failed: Features page did NOT load!");
    }

    @Test
    public void aboutUsPageTest() {
        loginPage.navigateToLoginPage();
        loginPage.aboutUsClick();
        Assert.assertTrue(loginPage.checkAboutUsPageLanding(), "Failed: About Us page did NOT load!");
    }

    @Test
    public void contactUsPageTest() {
        loginPage.navigateToLoginPage();
        loginPage.contactUsClick();
        Assert.assertTrue(loginPage.checkContactUsPageLanding(), "Failed: Contact Us page did NOT load!");
    }

    @Test
    public void themeToggleTest() {
        loginPage.navigateToLoginPage();
        loginPage.themeToggleLClick();
        Assert.assertTrue(loginPage.checkThemeToggleFunction(), "Failed: Theme toggle button did NOT work!");
    }

    @Test
    public void checkLanguageToggleButton() {
        loginPage.navigateToLoginPage();
        String defaultLanguage = loginPage.checkLanguageIcon();

        loginPage.languageButtonLClick();

        String expectedLanguage = defaultLanguage.equals("ع") ? "EN" : "ع";
        String currentLanguage = loginPage.checkLanguageIcon();

        Assert.assertEquals(currentLanguage, expectedLanguage, "Language toggle failed!");
    }

    @Test
    public void joinFreeTest() {
        loginPage.navigateToLoginPage();
        loginPage.joinFreeClick();
        Assert.assertTrue(loginPage.checkJoinFreePageLanding(), "Failed: Join Free page did NOT load!");
    }

}
