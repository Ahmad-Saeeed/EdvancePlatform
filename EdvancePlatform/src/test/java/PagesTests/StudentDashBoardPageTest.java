package PagesTests;

import Pages.StudentDashBoardPage;
import Pages.StudentLoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class StudentDashBoardPageTest extends BaseTest {

    @Test
    public void navigateToStudentDashboardThroughEdvanceLogo()
    {
        StudentDashBoardPage dashBoardPage = new StudentDashBoardPage(bot);
        dashBoardPage.clickOnMyCoursesOptionFromNavigationBar();
        dashBoardPage.clickOnEdvanceLogoFromNavigationBar();
        String actualURL = dashBoardPage.currentURLAfterLoading("https://edvance-ace.vercel.app/student/my-courses");
        Assert.assertEquals(actualURL, "https://edvance-ace.vercel.app/student/dashboard");
    }

    @Test
    public void navigateToStudentDashboardFromNavigationBar()
    {
        StudentDashBoardPage dashBoardPage = new StudentDashBoardPage(bot);
        dashBoardPage.clickOnMyCoursesOptionFromNavigationBar();
        dashBoardPage.clickOnDashboardOptionFromNavigationBar();
        String actualURL = dashBoardPage.currentURLAfterLoading("https://edvance-ace.vercel.app/student/my-courses");
        Assert.assertEquals(actualURL, "https://edvance-ace.vercel.app/student/dashboard");
    }

    @Test
    public void navigateToMyCoursesPageFromNavigationBar() {
        StudentDashBoardPage dashBoardPage = new StudentDashBoardPage(bot);
        dashBoardPage.clickOnMyCoursesOptionFromNavigationBar();
        String actualURL = dashBoardPage.currentURLAfterLoading("https://edvance-ace.vercel.app/student/dashboard");
        Assert.assertEquals(actualURL, "https://edvance-ace.vercel.app/student/my-courses");
    }

    @Test
    public void navigateToAIStudyGuideFromNavigationBar() {
        StudentDashBoardPage dashBoardPage = new StudentDashBoardPage(bot);
        dashBoardPage.clickOnAIStudyGuideOptionFromNavigationBar();
        String actualURL = dashBoardPage.currentURLAfterLoading("https://edvance-ace.vercel.app/student/dashboard");
        Assert.assertEquals(actualURL, "https://edvance-ace.vercel.app/student/ai-mentor");
    }

    @Test
    public void navigateToMyProgressFromNavigationBar() {
        StudentDashBoardPage dashBoardPage = new StudentDashBoardPage(bot);
        dashBoardPage.clickOnMyProgressOptionFromNavigationBar();
        String actualURL = dashBoardPage.currentURLAfterLoading("https://edvance-ace.vercel.app/student/dashboard");
        Assert.assertEquals(actualURL, "https://edvance-ace.vercel.app/student/progress");
    }

    @Test(enabled = false)
    public void searchForCourse() {
        StudentDashBoardPage dashBoardPage = new StudentDashBoardPage(bot);
        dashBoardPage.searchForACourse("CourseNameExample");

        //assertion
    }

    @Test(enabled = false)
    public void searchForATeacher() {
        StudentDashBoardPage dashBoardPage = new StudentDashBoardPage(bot);
        dashBoardPage.searchForATeacher("TeacherNameExample");
        dashBoardPage.clickOnSearchByTeacherNameFieldButton();
    }

    @BeforeMethod
    public void preSteps() {
        StudentLoginPage loginPage = new StudentLoginPage(bot);
        loginPage.successfulLogin();
    }

}
