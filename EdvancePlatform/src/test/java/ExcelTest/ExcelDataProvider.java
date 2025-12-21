package ExcelTest;


import DataProviders.Excel.ExcelUtilsData;
import org.testng.annotations.DataProvider;


//import static DataProviders.Excel.ExcelUtilsData.sheetIndex;


public class ExcelDataProvider {

    //This method is used as a data provider for a test method to test login
    @DataProvider(name = "credentialsData")
    public static Object[][] getExcelData() throws Exception {

        //Location of the Excel workbook that stores emails and passwords for login
        String filePath = "src/test/resources/LoginSheet.xlsx";

        //Sheet in the Excel workbook above, it will be changed by index below
        String sheetName;

        //Array that carry all the sheets' names in the Excel workbook
        String[] sheets = {"Admin", "Teachers", "Companies", "Parents", "UniversityStudents", "Students"};

        //Change the number passed to select sheet by index from the above array
        //So, you can change the emails used for login, and pass this name to the ExcelUtilData method
        sheetName = sheets[4];

        //Passing the Excel workbook location and sheet in it chosen by index to retrieve
        // emails and passwords from it
        return ExcelUtilsData.getTestData(filePath, sheetName);


    }

}

