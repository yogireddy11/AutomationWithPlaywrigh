package utilities;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelUtils {

    static FileInputStream inputStream;
    static XSSFWorkbook workbook;
    static XSSFSheet sheet;

    //    public ExcelUtils() throws IOException {
//        inputStream = new FileInputStream("C:\\Users\\yogireddy\\Downloads\\RegisterData.xlsx");
//        workbook = new XSSFWorkbook(inputStream);
//        sheet = workbook.getSheet("Sheet1");
//    }
//
//    public void readFile(){
//        int rowSize = sheet.getLastRowNum()-1;
//        for (int i=0;i<rowSize;i++){
//
//        }
//    }
    public static Object[][] readExcelData(String path, String sheetName) {

        try (FileInputStream fis = new FileInputStream(path);
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheet(sheetName);

            int rows = sheet.getPhysicalNumberOfRows();
            int cols = sheet.getRow(0).getPhysicalNumberOfCells();

            Object[][] data = new Object[rows - 1][cols];

            DataFormatter formatter = new DataFormatter();

            for (int i = 1; i < rows; i++) {

                Row row = sheet.getRow(i);

                if (row == null) {
                    continue;
                }

                for (int j = 0; j < cols; j++) {

                    Cell cell = row.getCell(j, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                    data[i - 1][j] = formatter.formatCellValue(cell);
                }
            }

            return data;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
