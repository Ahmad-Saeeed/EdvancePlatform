package ExcelTest;


import DataProviders.Excel.ExcelUtilsData;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExcelTest {

    // TestNG DataProvider method
    @DataProvider(name = "excelData")
    public Object[][] getExcelData() throws Exception {
        // Assuming your ExcelUtils class has a method like readData
        String filePath = "src/test/resources/TestData.xlsx"; // Adjust path as needed
        String sheetName = "Sheet1";

        // Call the utility method to read data
        return ExcelUtilsData.getTestData(filePath, sheetName);
    }

    // Your actual TestNG Test method
    @Test(dataProvider = "excelData")
    public void mySeleniumTest(String username, String password) {
        // This test will run once for every row of data in your Excel sheet.
        System.out.println("Testing with Username: " + username + " and Password: " + password);
        // ... Your Selenium code using username and password ...
    }
}
