package PagesTests;


import ExcelTest.ExcelDataProvider;
import Pages.TeacherLoginPage;
import Utilities.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class TeacherLoginPageTest extends BaseTest {
    TeacherLoginPage loginPage;

    @BeforeMethod
    public void setupPages() {
        loginPage = new TeacherLoginPage(bot);

    }


    @Test(dataProvider = "loginData")
    public void successfullLoginTestTeacher(String email, String password) {
        loginPage.navigateToLoginPage();
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
        loginPage.clickOnLoginButton();
        Assert.assertTrue(loginPage.checkWelcomeMessage(), "Failed: Teacher  could not login successfully!");
    }

    @Test(dataProvider = "credentialsData", dataProviderClass = ExcelDataProvider.class)
    public void successfullLoginTestTeacherExcell(String email, String password) {
        loginPage.navigateToLoginPage();
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
        loginPage.clickOnLoginButton();
        Assert.assertTrue(loginPage.checkWelcomeMessage(), "Failed: Teacher  could not login successfully!");
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

    @DataProvider(name = "loginData")
    public Object[][] loginData()
    {
        return new Object[][]{
                {"ahmed.mohamed@teacher.com","password123"},
                {"fatma.ali@teacher.com","password123"},
                {"mahmoud.hassan@teacher.com","password123"},
                {"karim.youssef@teacher.com","password123"}
        };
    }

}
