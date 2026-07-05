package ultilities;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;

public class ExcelUtils {

    public static Object[][] getLoginData() {

        Object[][] data = null;

        try {
            String filePath = System.getProperty("user.dir") + "\\src\\testdata\\excelFile\\DataTest.xlsx";
            System.out.println(filePath);

            FileInputStream fis = new FileInputStream(filePath);

            Workbook workbook = new XSSFWorkbook(fis);

            Sheet sheet = workbook.getSheetAt(0);

            int rowCount = sheet.getPhysicalNumberOfRows();
            int colCount = sheet.getRow(0).getPhysicalNumberOfCells();

            data = new Object[rowCount - 1][colCount];

            for (int i = 1; i < rowCount; i++) {

                for (int j = 0; j < colCount; j++) {

                    Cell cell = sheet.getRow(i).getCell(j);

                    if (cell == null) {
                        data[i - 1][j] = "";
                    } else {
                        data[i - 1][j] = cell.toString();
                    }
                }
            }

            workbook.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        for (Object[] row : data) {
            System.out.println(java.util.Arrays.toString(row));
        }

        return data;
    }
}