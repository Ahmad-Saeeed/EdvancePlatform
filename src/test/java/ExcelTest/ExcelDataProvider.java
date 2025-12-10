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
        sheetName = sheets[1];
        return ExcelUtilsData.getTestData(filePath, sheetName);

//        //selectedSheet = sheets.Admin;
//        switch (sheets.Admin) {
//            case Admin:
//                sheetName = "Admin"; return ExcelUtilsData.getTestData(filePath, sheetName);
//                break;
//            case Teachers:
//                sheetName = "Teachers"; return ExcelUtilsData.getTestData(filePath, sheetName);
//                break;
//            case Companies:
//                sheetName = "Companies"; return ExcelUtilsData.getTestData(filePath, sheetName);
//                break;
//            case Parents:
//                sheetName = "Parents"; return ExcelUtilsData.getTestData(filePath, sheetName);
//                break;
//            case UniversityStudents:
//                sheetName = "UniversityStudents"; return ExcelUtilsData.getTestData(filePath, sheetName);
//                break;
//            case Students:
//                sheetName = "Students"; return ExcelUtilsData.getTestData(filePath, sheetName);
//                break;
//    }
    }

}

