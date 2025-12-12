package ExcelTest;


import DataProviders.Excel.ExcelUtilsData;
import org.testng.annotations.DataProvider;


//import static DataProviders.Excel.ExcelUtilsData.sheetIndex;


public class ExcelDataProvider {
    @DataProvider(name = "credentialsData")
    public static Object[][] getExcelData() throws Exception {
        String filePath = "src/test/resources/LoginSheet.xlsx";
        String sheetName;
        String[] sheets = {"Admin", "Teachers", "Companies", "Parents", "UniversityStudents", "Students"};

        //Change this according to login accounts needed
        sheetName = sheets[4];
        return ExcelUtilsData.getTestData(filePath, sheetName);


    }

}

