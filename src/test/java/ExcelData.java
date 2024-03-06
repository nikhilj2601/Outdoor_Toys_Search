import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;
public class ExcelData {
	public String readFromExcel(String Filepath) {
		String inputFile = null;
		try(FileInputStream fis = new FileInputStream(Filepath);
			XSSFWorkbook workbook = new XSSFWorkbook(fis)){
			XSSFSheet sheet = workbook.getSheetAt(0);
			XSSFRow row = sheet.getRow(0);
			XSSFCell cell = row.getCell(0);
			if(cell != null) {
				inputFile = cell.getStringCellValue();
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
		return inputFile;
	}
	public void WriteToExcel(String Filepath, List<WebElement> webElements) {
		try(FileOutputStream fos = new FileOutputStream(Filepath);
			XSSFWorkbook workbook = new XSSFWorkbook()){
			XSSFSheet sheet1 = workbook.createSheet("Output");
			int rowNum = 0;
			for(WebElement element : webElements) {
				if(element.getText().contains("Toys")) {
				XSSFRow row = sheet1.createRow(rowNum++);
				XSSFCell cell1 = row.createCell(0);
				XSSFCell cell2 = row.createCell(1);
				String elementText = element.getText();
				String elementlink = element.getAttribute("href");
				cell1.setCellValue(elementText);
				cell2.setCellValue(elementlink);
				}
			}
			System.out.println("Successfully printed the output in the excel file!!!");
			workbook.write(fos);
			workbook.close();
			fos.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}