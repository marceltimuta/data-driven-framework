package utils;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;

public class ExcelReader {

    private String path = null;
    private FileInputStream fis = null;
    private XSSFWorkbook workbook = null;
    private XSSFSheet sheet = null;
    private XSSFCell cell = null;

    public ExcelReader(String path) {
        this.path = path;
        try {
            fis = new FileInputStream(path);
            workbook = new XSSFWorkbook(fis);
            sheet = workbook.getSheetAt(0);
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String[][] getTableArray() {
        String[][] tabArray = null;
        int startRow = 1;
        int startCol = 0;
        int ci, cj;
        int totalRows = sheet.getLastRowNum();
        int totalCols = 3;

        tabArray = new String[totalRows][totalCols];
        ci = 0;

        for (int i = startRow; i <= totalRows; i++, ci++) {
            cj = 0;
            for (int j = startCol; j < totalCols; j++, cj++) {
                try {
                    tabArray[ci][cj] = getCellData(i, j);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return tabArray;
    }

    public String getCellData(int RowNum, int ColNum) throws Exception {
        try {
            cell = sheet.getRow(RowNum).getCell(ColNum);
            return cell.getStringCellValue();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            throw (e);
        }
    }
}
