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
    public void successfulDashBoardPageLanding() {
        Assert.assertTrue(dashBoard.verifyDashBoardPageLanding(), "Failed: Dashboard page did NOT load successfully!");
    }

    @Test
    public void accessStudentsPage() {
        dashBoard.clickOnStudentsField();
        Assert.assertTrue(dashBoard.checkStudentsPageLanding(), "Failed: Students page did NOT open!");
    }

    @Test
    public void accessSessionsSchedulePage() {
        dashBoard.clickOnSessionScheduleField();
        Assert.assertTrue(dashBoard.checkSessionSchedulePageLanding(), "Failed: Session Schedule page did NOT open!");
    }

    @Test
    public void accessStatisticsPage() {
        dashBoard.clickOnStatisticsField();
        Assert.assertTrue(dashBoard.checkStatisticsPageLanding(), "Failed: Statistics page did NOT open!");
    }

    @Test
    public void checkThemeToggleButton() {
        dashBoard.themeToggleLClick();
        Assert.assertTrue(dashBoard.checkThemeToggleFunction(), "Failed: Theme toggle did NOT switch!");
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
    public void checknotificationSectionDisplay() {
        dashBoard.clicOnknotificationButton();
        Assert.assertTrue(dashBoard.checknotificationSectionDisplay(), "Failed: Notification section did NOT appear!");
    }

    @Test
    public void checkAccesToProfilePage() {
        dashBoard.clickOnDropDownMenu();
        dashBoard.clickOnProfileInDropDownMenu();
        Assert.assertTrue(dashBoard.checkProfilePageLanding(), "Failed: Profile page did NOT open!");
    }

    @Test
    public void checkEditProfileSection() {
        dashBoard.clickOnDropDownMenu();
        dashBoard.clickOnProfileInDropDownMenu();
        dashBoard.clickOnEditProfileButton();
        dashBoard.enterInSpecializationField();
        dashBoard.enterInSpecializationyearsOfExField();
        dashBoard.clickOnSaveChangesButton();
        dashBoard.acceptPopUpMessage();// accept the popup message
        Assert.assertTrue(dashBoard.checkEnteredDataSaved(), "Failed: Profile changes were NOT saved!");

    }

    @Test
    public void checkAccesToEarningsPage() {
        dashBoard.clickOnDropDownMenu();
        dashBoard.clickOnEarningsButton();
        Assert.assertTrue(dashBoard.checkEarningsPageLanding(), "Failed: Earnings page did NOT open!");
    }

    @Test
    public void checkLogoutSuccessful() {
        dashBoard.clickOnDropDownMenu();
        dashBoard.clickOnLogoutButton();
        Assert.assertTrue(dashBoard.checkLogoutSuccessfull(), "Failed: Logout did NOT redirect to login page!");
    }

    @Test
    public void checkCreateNewCoursePage() {
        dashBoard.clickCreateNewCourse();
        Assert.assertTrue(dashBoard.checkCreateNewCoursePageLanding(), "Failed: Create New Course page did NOT open!");
    }

    @Test
    public void createNewCourseandDeleteIT() {
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
        Assert.assertTrue(dashBoard.verifyCourseAdded(), "Failed: New course was NOT added!");
        dashBoard.clickDeleteButtonofTheNewCourse();
        dashBoard.acceptDeletePopupMessage();
        dashBoard.verifyPageRelod();
        Assert.assertTrue(dashBoard.verifytheCourseDeleted(), "Failed: Course was NOT deleted!");

    }

}
