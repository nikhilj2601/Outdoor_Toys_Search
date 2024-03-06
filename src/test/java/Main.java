import java.io.FileNotFoundException;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class Main {
	public static void main(String[] args) throws FileNotFoundException, InterruptedException {
		String URL = "http://www.ebay.com";
		WebDriver driver = DriverSetup.getWebDriver(URL);
		screenshot.captureScreenshot(driver, "1");
		ExcelData ed = new ExcelData();
		String inputpath = (System.getProperty("user.dir") + "\\Data\\input file.xlsx");
		String outputpath = (System.getProperty("user.dir") + "\\Data\\output file.xlsx");
		String Input = ed.readFromExcel(inputpath);
		advancedOptionsHandling op = new advancedOptionsHandling();
		op.advancedClick(driver);
		op.inputBox(Input, driver);
		op.dropDown(driver);
		op.filters(driver);
		op.search(driver);
		Thread.sleep(9000);
		List<WebElement> links = op.listFormation(driver);
		ed.WriteToExcel(outputpath, links);
		op.quitBrowser(driver);		
	}
}