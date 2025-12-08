package PagesTests;

import Pages.UniversityStudentProfilePage;
import ParallelExecution.ParallelBaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UniversityStudentProfileTest extends ParallelBaseTest {
    UniversityStudentProfilePage universityStudentProfilePage = new UniversityStudentProfilePage();

    @Test
    public void AllStudentsNavigateTest(){
        universityStudentProfilePage.UniversityStudentProfileNavigation(5);
        Assert.assertEquals(universityStudentProfilePage.actualUsername, universityStudentProfilePage.expectedUsernameDisplayed);
    }
    @Test
    public void ClickProfileButtonAfterLogin(){
        universityStudentProfilePage.goToProfile();
        Assert.assertEquals(universityStudentProfilePage.actualUrl, universityStudentProfilePage.expectedUrl);
    }


    @Test
    public void CheckingCourseNumberafterFilteringCategories(){
        universityStudentProfilePage.ensureCategoryNameAndNumeberOfCourses();
        Assert.assertEquals(universityStudentProfilePage.actualCourseNumber, universityStudentProfilePage.expectedCourseNumber);
    }
}
