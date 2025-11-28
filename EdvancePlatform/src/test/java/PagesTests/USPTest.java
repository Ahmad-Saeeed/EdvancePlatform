package PagesTests;

import Engine.Bot;
import Pages.USPPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class USPTest extends BaseTest{
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
    }
    @Test
    public void CheckingCourseNumberafterFilteringCategories(){
        uspPage.ensureCategoryNameAndNumeberOfCourses();
        Assert.assertEquals(uspPage.actualCourseNumber, uspPage.expectedCourseNumber);
    }
}
