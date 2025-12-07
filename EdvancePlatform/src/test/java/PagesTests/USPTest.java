package PagesTests;

import Engine.Bot;
import Pages.USPPage;
import ParallelExecution.ParallelBaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class USPTest extends ParallelBaseTest {
    USPPage uspPage = new USPPage();
    Bot uspBot;
    @Test
    public void AllStudentsNavigateTest(){
        uspPage.navigate(5);
        Assert.assertEquals(uspPage.actualUsername, uspPage.expectedUsernameDisplayed);
    }
    @Test
    public void ClickProfileButtonAfterLogin(){
        uspPage.goToProfile();
        Assert.assertEquals(uspPage.actualUrl, uspPage.expectedUrl);
    }


    @Test
    public void CheckingCourseNumberafterFilteringCategories(){
        uspPage.ensureCategoryNameAndNumeberOfCourses();
        Assert.assertEquals(uspPage.actualCourseNumber, uspPage.expectedCourseNumber);
    }
}
