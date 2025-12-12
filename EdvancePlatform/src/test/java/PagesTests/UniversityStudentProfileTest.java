package PagesTests;

import ExcelTest.ExcelDataProvider;
import Pages.UniversityStudentProfilePage;
import CrossBrowsingExecution.CrossBrowserBaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
//import static DataProviders.Excel.ExcelUtilsData.sheetIndex;


public class UniversityStudentProfileTest extends CrossBrowserBaseTest {
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

    @Test (dataProvider = "credentialsData",dataProviderClass = ExcelDataProvider.class)
    public void TestLoginUsingExcelSheet(String username, String password) throws Exception{
        universityStudentProfilePage.UniversityStudentLoginUsingExcelData(username, password);
    }

    @Test(dataProvider = "credentialsData", dataProviderClass = ExcelDataProvider.class)
    public void PrintToConsoleExcelDataTest(String username, String password) {
        //This method is opened chrome 5 times once per row in excel sheet and print to console its name
        System.out.println("Testing with Username: " + username + " and Password: " + password);
    }
}
