package PagesTests;

import Pages.TeacherDashBoardPage;
import Pages.TeacherLoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TeacherDashBoardPageTest extends BaseTest {

    //setup method
    TeacherDashBoardPage dashBoard;
    TeacherLoginPage loginPage;

    @BeforeMethod
    public void setupPages() {
        dashBoard = new TeacherDashBoardPage(bot);
        loginPage = new TeacherLoginPage(bot);
        loginPage.navigateandValidLogin();
    }
    @Test
    public void successfulDashBoardPageLanding(){
        Assert.assertTrue(dashBoard.verifyDashBoardPageLanding());
    }
    @Test
    public void accessStudentsPage(){
        dashBoard.clickOnStudentsField();
        Assert.assertTrue(dashBoard.checkStudentsPageLanding());
    }
    @Test
    public  void accessSessionsSchedulePage(){
        dashBoard.clickOnSessionScheduleField();
        Assert.assertTrue(dashBoard.checkSessionSchedulePageLanding());
    }
    @Test
    public  void accessStatisticsPage(){
        dashBoard.clickOnStatisticsField();
        Assert.assertTrue(dashBoard.checkStatisticsPageLanding());
    }
    @Test
    public void checkThemeToggleButton(){
        dashBoard.themeToggleLClick();
        Assert.assertTrue(dashBoard.checkThemeToggleFunction());
    }
    @Test
    public void checkLanguageToggleButton() {
        String defaultLanguage = dashBoard.checkLanguageIcon();

        dashBoard.languageButtonLClick();

        String expectedLanguage = defaultLanguage.equals("ع") ? "EN" : "ع";
        String currentLanguage = dashBoard.checkLanguageIcon();

        Assert.assertEquals(currentLanguage, expectedLanguage, "Language toggle failed!");
    }
    @Test
    public void checknotificationSectionDisplay(){
        dashBoard.clicOnknotificationButton();
        Assert.assertTrue(dashBoard.checknotificationSectionDisplay());
    }
    @Test
    public void checkAccesToProfilePage(){
        dashBoard.clickOnDropDownMenu();
        dashBoard.clickOnProfileInDropDownMenu();
        Assert.assertTrue(dashBoard.checkProfilePageLanding());
    }
    @Test
    public void checkEditProfileSection(){
        dashBoard.clickOnDropDownMenu();
        dashBoard.clickOnProfileInDropDownMenu();
        dashBoard.clickOnEditProfileButton();
        dashBoard.enterInSpecializationField();
        dashBoard.enterInSpecializationyearsOfExField();
        dashBoard.clickOnSaveChangesButton();
        dashBoard.acceptPopUpMessage();// accept the popup message
        Assert.assertTrue(dashBoard.checkEnteredDataSaved());

    }
    @Test
    public void checkAccesToEarningsPage(){
        dashBoard.clickOnDropDownMenu();
        dashBoard.clickOnEarningsButton();
        Assert.assertTrue(dashBoard.checkEarningsPageLanding());
    }
    @Test
    public void checkLogoutSuccessful(){
        dashBoard.clickOnDropDownMenu();
        dashBoard.clickOnLogoutButton();
        Assert.assertTrue(dashBoard.checkLogoutSuccessfull());
    }

    @Test
    public void checkCreateNewCoursePage(){
        dashBoard.clickCreateNewCourse();
        Assert.assertTrue(dashBoard.checkCreateNewCoursePageLanding());
    }
    @Test
    public void createNewCourseandDeleteIT(){
        dashBoard.clickCreateNewCourse();
        dashBoard.enterCourseTittle();
        dashBoard.enterCourseDescription();
        dashBoard.enterSubject();
        dashBoard.chooseFromList();
        dashBoard.clickNextButton();
        dashBoard.enterCoursePrice();
        dashBoard.enterCourseDuration();
        dashBoard.enterCourseNumofLessons();
        dashBoard.clickCreateCourseButton();
        Assert.assertTrue(dashBoard.verifyCourseAdded());
        dashBoard.clickDeleteButtonofTheNewCourse();
        dashBoard.acceptDeletePopupMessage();
        dashBoard.verifyPageRelod();
        Assert.assertTrue(dashBoard.verifytheCourseDeleted());

    }

}
