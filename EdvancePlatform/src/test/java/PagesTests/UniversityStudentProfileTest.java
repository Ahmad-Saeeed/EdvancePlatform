package PagesTests;

import ExcelTest.ExcelDataProvider;
import Pages.UniversityStudentProfilePage;
import CrossBrowsingExecution.CrossBrowserBaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

//This test class contains all the tests needed for University student
public class UniversityStudentProfileTest extends CrossBrowserBaseTest {
    UniversityStudentProfilePage universityStudentProfilePage = new UniversityStudentProfilePage();

    //This test method makes login by a number of users changed according to the number pass inside it
    //Then it asserts that the actual username displayed is the same as expected username stored in
    //the array named 'usernames' in the page where the method comes from
    @Test
    public void AllStudentsNavigateTest(){
        universityStudentProfilePage.UniversityStudentProfileNavigation(5);
        Assert.assertEquals(universityStudentProfilePage.actualUsername, universityStudentProfilePage.expectedUsernameDisplayed);
    }

    //This test method uses navigation then click on 'Profile' button, it asserts that the actual URL
    //is the same as the expected URL stored in the page where the method comes from
    @Test
    public void ClickProfileButtonAfterLogin(){
        universityStudentProfilePage.goToProfile();
        Assert.assertEquals(universityStudentProfilePage.actualUrl, universityStudentProfilePage.expectedUrl);
    }

    //This test method is used to check that when click on each category button the number of courses
    //is changed according to chosen category, then assert that the actual number displayed
    //is the same as the expected number of courses
    //The expected number of courses is come from comparing the index of the category chosen against
    //the index of the array 'numberOfCourses' defined in the page where the method comes from
    @Test
    public void CheckingCourseNumberafterFilteringCategories(){
        universityStudentProfilePage.ensureCategoryNameAndNumeberOfCourses();
        Assert.assertEquals(universityStudentProfilePage.actualCourseNumber, universityStudentProfilePage.expectedCourseNumber);
    }


    //This method test login but this time using Excel workbook as a data provider
    //Note: the parameters passed to the method (username and password) must match the number
    //of columns in the sheet to be worked
    @Test (dataProvider = "credentialsData",dataProviderClass = ExcelDataProvider.class)
    public void TestLoginUsingExcelSheet(String username, String password) throws Exception{
        universityStudentProfilePage.UniversityStudentLoginUsingExcelData(username, password);
    }

    //This method used to print to console user name and password retrieved from Excel workbook
    @Test(dataProvider = "credentialsData", dataProviderClass = ExcelDataProvider.class)
    public void PrintToConsoleExcelDataTest(String username, String password) {
        //This method is opened chrome 5 times once per row in Excel sheet and print to console its name
        System.out.println("Testing with Username: " + username + " and Password: " + password);
    }
}
