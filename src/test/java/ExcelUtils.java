import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelUtils
{
    private XSSFSheet excelWSheet;

    public ExcelUtils(String path, String sheetName) throws IOException {
        FileInputStream excelFile = new FileInputStream(path);

        XSSFWorkbook excelWorkbook = new XSSFWorkbook(excelFile);
        excelWSheet = excelWorkbook.getSheet(sheetName);
    }

    public String getCellData(int rowNum, int colNum) {
        XSSFRow row = excelWSheet.getRow(rowNum);
        if (row == null) {
            return null;
        }

        XSSFCell cell = row.getCell(colNum);

        return cell == null ? "" : cell.getStringCellValue();
    }

    public int getLastRowNum() {
        return excelWSheet.getLastRowNum();
    }
}
