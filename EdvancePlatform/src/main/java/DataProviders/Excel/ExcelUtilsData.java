package DataProviders.Excel;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.IOException;

    public class ExcelUtilsData {

        // IMPORTANT: The path and sheet name are passed from your TestNG DataProvider
        public static Object[][] getTestData(String filePath, String sheetName) {

            Object[][] data = null;
            Workbook workbook = null;

            try (FileInputStream fis = new FileInputStream(filePath)) {

                // 1. Open the Workbook (for .xlsx files)
                workbook = new XSSFWorkbook(fis);

                // 2. Get the desired Sheet
                Sheet sheet = workbook.getSheet(sheetName);

                // Handle case where sheet doesn't exist
                if (sheet == null) {
                    throw new IllegalArgumentException("Sheet '" + sheetName + "' not found in the workbook.");
                }

                // 3. Determine data dimensions (Excluding the header row)
                int totalRows = sheet.getLastRowNum(); // Gets the index of the last row (0-based)
                int totalCols = sheet.getRow(sheet.getFirstRowNum()).getLastCellNum(); // Gets the number of cells in the header row

                // Initialize the 2D array: Rows = Total Rows - Header Row; Columns = Total Columns
                data = new Object[totalRows][totalCols];

                // 4. Iterate over rows (starting from row index 1 to skip the header)
                for (int i = 1; i <= totalRows; i++) {
                    Row row = sheet.getRow(i);

                    // Ensure row is not null (e.g., if there are blank rows in between)
                    if (row == null) {
                        continue;
                    }

                    // 5. Iterate over columns (cells)
                    for (int j = 0; j < totalCols; j++) {
                        Cell cell = row.getCell(j);

                        // Call helper method to get the cell value as a String
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

        // Helper method to handle different cell types
        private static String getCellValueAsString(Cell cell) {
            if (cell == null) {
                return "";
            }

            // Use CellType to read the value correctly
            switch (cell.getCellType()) {
                case STRING:
                    return cell.getStringCellValue();
                case NUMERIC:
                    // Check if it's a date or a regular number
                    if (DateUtil.isCellDateFormatted(cell)) {
                        return cell.getDateCellValue().toString();
                    } else {
                        // Use DataFormatter to handle numbers (including large ones) as strings
                        DataFormatter formatter = new DataFormatter();
                        return formatter.formatCellValue(cell);
                    }
                case BOOLEAN:
                    return String.valueOf(cell.getBooleanCellValue());
                case FORMULA:
                    // Evaluate formula and recursively call this method for the result
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
