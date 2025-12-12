package DataProviders.Excel;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.IOException;

    public class ExcelUtilsData {

        public static Object[][] getTestData(String filePath, String sheetName) {

            Object[][] data = null;
            Workbook workbook = null;

            try (FileInputStream fileInputStream = new FileInputStream(filePath)) {

                workbook = new XSSFWorkbook(fileInputStream);
                Sheet sheet = workbook.getSheet(sheetName);
                if (sheet == null) {
                    throw new IllegalArgumentException("Sheet '" + sheetName + "' not found in the workbook.");
                }

                int totalRows = sheet.getLastRowNum();
                int totalCols = sheet.getRow(sheet.getFirstRowNum()).getLastCellNum();
                data = new Object[totalRows][totalCols];

                for (int i = 1; i <= totalRows; i++) {
                    Row row = sheet.getRow(i);
                    if (row == null) { continue; }
                    for (int j = 0; j < totalCols; j++) {
                        Cell cell = row.getCell(j);
                        data[i - 1][j] = getCellValueAsString(cell);
                    }
                }

            } catch (IOException e) {
                e.printStackTrace();
                // In a real framework, you would log this error and fail the setup
            } finally {
                if (workbook != null) {
                    try {
                        workbook.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            return data;
        }

        private static String getCellValueAsString(Cell cell) {
            if (cell == null) { return ""; }

            switch (cell.getCellType()) {
                case STRING:
                    return cell.getStringCellValue();
                case NUMERIC:
                    if (DateUtil.isCellDateFormatted(cell)) {
                        return cell.getDateCellValue().toString();
                    } else {
                        DataFormatter formatter = new DataFormatter();
                        return formatter.formatCellValue(cell);
                    }
                case BOOLEAN:
                    return String.valueOf(cell.getBooleanCellValue());
                case FORMULA:
                    Workbook workbook = cell.getSheet().getWorkbook();
                    FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();
                    return getCellValueAsString(evaluator.evaluateInCell(cell));
                case BLANK:
                    return "";
                default:
                    return "";
            }
        }


    }
