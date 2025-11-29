package PagesTests;

import Pages.TeacherDashBoardPage;
import Pages.TeacherLoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TeacherDashBoardPageTest extends BaseTest {
    @Test
    public void successfulDashBoardPageLanding(){
        TeacherDashBoardPage dashBoard = new TeacherDashBoardPage(bot);
        TeacherLoginPage loginPage = new TeacherLoginPage(bot);
        loginPage.navigateToLoginPage();
        loginPage.enter1stValidEmail();
        loginPage.enterValidPassword();
        loginPage.clickOnLoginButton();
        Assert.assertTrue(dashBoard.verifyDashBoardPageLanding());
    }
    @Test
    public void accessStudentsPage(){
        TeacherDashBoardPage dashBoard = new TeacherDashBoardPage(bot);
        TeacherLoginPage loginPage = new TeacherLoginPage(bot);
        loginPage.navigateToLoginPage();
        loginPage.enter1stValidEmail();
        loginPage.enterValidPassword();
        loginPage.clickOnLoginButton();
        dashBoard.clickOnStudentsField();
        Assert.assertTrue(dashBoard.checkStudentsPageLanding());
    }
    @Test
    public  void accessSessionsSchedulePage(){
        TeacherDashBoardPage dashBoard = new TeacherDashBoardPage(bot);
        TeacherLoginPage loginPage = new TeacherLoginPage(bot);
        loginPage.navigateToLoginPage();
        loginPage.enter1stValidEmail();
        loginPage.enterValidPassword();
        loginPage.clickOnLoginButton();
        dashBoard.clickOnSessionScheduleField();
        Assert.assertTrue(dashBoard.checkSessionSchedulePageLanding());
    }
    @Test
    public  void accessStatisticsPage(){
        TeacherDashBoardPage dashBoard = new TeacherDashBoardPage(bot);
        TeacherLoginPage loginPage = new TeacherLoginPage(bot);
        loginPage.navigateToLoginPage();
        loginPage.enter1stValidEmail();
        loginPage.enterValidPassword();
        loginPage.clickOnLoginButton();
        dashBoard.clickOnStatisticsField();
        Assert.assertTrue(dashBoard.checkStatisticsPageLanding());
    }
    @Test
    public void checkThemeToggleButton(){
        TeacherDashBoardPage dashBoard = new TeacherDashBoardPage(bot);
        TeacherLoginPage loginPage = new TeacherLoginPage(bot);
        loginPage.navigateToLoginPage();
        loginPage.enter1stValidEmail();
        loginPage.enterValidPassword();
        loginPage.clickOnLoginButton();
        dashBoard.themeToggleLClick();
        Assert.assertTrue(dashBoard.checkThemeToggleFunction());
    }
    @Test
    public void checkLanguageToggleButton(){
        TeacherDashBoardPage dashBoard = new TeacherDashBoardPage(bot);
        TeacherLoginPage loginPage = new TeacherLoginPage(bot);
        loginPage.navigateToLoginPage();
        loginPage.enter1stValidEmail();
        loginPage.enterValidPassword();
        loginPage.clickOnLoginButton();
        String defaultLanguage = dashBoard.checkLanguageIcon();
        dashBoard.languageButtonLClick();
        String currentLanguageOnIcon = dashBoard.checkLanguageIcon();
        if (defaultLanguage.equals("ع")){
            Assert.assertEquals(currentLanguageOnIcon,"EN");
        }else
            Assert.assertEquals(currentLanguageOnIcon,"ع");
    }
    @Test
    public void checknotificationSectionDisplay(){
        TeacherDashBoardPage dashBoard = new TeacherDashBoardPage(bot);
        TeacherLoginPage loginPage = new TeacherLoginPage(bot);
        loginPage.navigateToLoginPage();
        loginPage.enter1stValidEmail();
        loginPage.enterValidPassword();
        loginPage.clickOnLoginButton();
        dashBoard.clicOnknotificationButton();
        Assert.assertTrue(dashBoard.checknotificationSectionDisplay());
    }
    @Test
    public void checkAccesToProfilePage(){
        TeacherDashBoardPage dashBoard = new TeacherDashBoardPage(bot);
        TeacherLoginPage loginPage = new TeacherLoginPage(bot);
        loginPage.navigateToLoginPage();
        loginPage.enter1stValidEmail();
        loginPage.enterValidPassword();
        loginPage.clickOnLoginButton();
        dashBoard.clickOnDropDownMenu();
        dashBoard.clickOnProfileInDropDownMenu();
        Assert.assertTrue(dashBoard.checkProfilePageLanding());
    }
    @Test
    public void checkEditProfileSection(){
        TeacherDashBoardPage dashBoard = new TeacherDashBoardPage(bot);
        TeacherLoginPage loginPage = new TeacherLoginPage(bot);
        loginPage.navigateToLoginPage();
        loginPage.enter1stValidEmail();
        loginPage.enterValidPassword();
        loginPage.clickOnLoginButton();
        dashBoard.clickOnDropDownMenu();
        dashBoard.clickOnProfileInDropDownMenu();
        dashBoard.clickOnEditProfileButton();
        //Assert.assertTrue(dashBoard.waitForEditFieldsToLoad());
        dashBoard.enterInSpecializationField();
        dashBoard.enterInSpecializationyearsOfExField();
        dashBoard.clickOnSaveChangesButton();
        //Assert.assertTrue(dashBoard.checkPopUpMessageContent());//trying to check the popup message content
        //dashBoard.acceptPopUpMessage();// accept the popup message
        Assert.assertTrue(dashBoard.checkEnteredDataSaved());

    }
    @Test
    public void checkAccesToEarningsPage(){
        TeacherDashBoardPage dashBoard = new TeacherDashBoardPage(bot);
        TeacherLoginPage loginPage = new TeacherLoginPage(bot);
        loginPage.navigateToLoginPage();
        loginPage.enter1stValidEmail();
        loginPage.enterValidPassword();
        loginPage.clickOnLoginButton();
        dashBoard.clickOnDropDownMenu();
        dashBoard.clickOnEarningsButton();
        Assert.assertTrue(dashBoard.checkEarningsPageLanding());
    }
    @Test
    public void checkLogoutSuccessful(){
        TeacherDashBoardPage dashBoard = new TeacherDashBoardPage(bot);
        TeacherLoginPage loginPage = new TeacherLoginPage(bot);
        loginPage.navigateToLoginPage();
        loginPage.enter1stValidEmail();
        loginPage.enterValidPassword();
        loginPage.clickOnLoginButton();
        dashBoard.clickOnDropDownMenu();
        dashBoard.clickOnLogoutButton();
        Assert.assertTrue(dashBoard.checkLogoutSuccessfull());
    }


}
