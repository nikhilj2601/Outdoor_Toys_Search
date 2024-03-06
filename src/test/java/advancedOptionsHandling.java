import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
public class advancedOptionsHandling {
	public void advancedClick(WebDriver driver) {
		driver.findElement(By.id("gh-as-a")).click();
		screenshot.captureScreenshot(driver, "2");
	}
	public void inputBox(String file,WebDriver driver) {
		driver.findElement(By.cssSelector("#_nkw")).sendKeys(file);
		screenshot.captureScreenshot(driver, "3");
	}
	public void dropDown(WebDriver driver) {
		Select objSelect =new Select(driver.findElement(By.id("s0-1-17-4[0]-7[1]-_in_kw")));
		objSelect.selectByVisibleText("Any words, any order");
		screenshot.captureScreenshot(driver, "4");
		Select obj = new Select(driver.findElement(By.xpath("//*[@id=\'s0-1-17-4[0]-7[3]-_sacat\']")));
		obj.selectByVisibleText("Toys & Hobbies");
		screenshot.captureScreenshot(driver, "5");
	}
	public void filters(WebDriver driver) {
		driver.findElement(By.id("s0-1-17-5[1]-[0]-LH_TitleDesc")).click();
		screenshot.captureScreenshot(driver, "6");
		driver.findElement(By.id("s0-1-17-6[4]-[0]-LH_ItemCondition")).click();
		screenshot.captureScreenshot(driver, "7");
		driver.findElement(By.id("s0-1-17-5[5]-[0]-LH_FR")).click();
		screenshot.captureScreenshot(driver, "8");
		driver.findElement(By.id("s0-1-17-5[5]-[1]-LH_RPA")).click();
		screenshot.captureScreenshot(driver, "9");
		driver.findElement(By.id("s0-1-17-5[6]-[0]-LH_FS")).click();
		screenshot.captureScreenshot(driver, "10");
		driver.findElement(By.id("s0-1-17-6[7]-[3]-LH_PrefLoc")).click();
		screenshot.captureScreenshot(driver, "11");
	}
	public void search(WebDriver driver) {
		driver.findElement(By.xpath("/html/body/div[2]/div/main/form/div[2]/button")).click();
		screenshot.captureScreenshot(driver, "12");
	}
	public List<WebElement> listFormation(WebDriver driver) {
		return driver.findElements(By.tagName("a"));
	}
	public void quitBrowser(WebDriver driver) {
		driver.quit();
	}
}