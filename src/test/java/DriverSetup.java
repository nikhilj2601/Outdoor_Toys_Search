import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
public class DriverSetup {
	public static WebDriver driver;
	public static WebDriver getWebDriver(String URL) {
		try {
			driver = new ChromeDriver();
			driver.get(URL);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			driver.manage().window().maximize();
		} catch(Exception e) {
			System.out.println("Chrome not available, trying Edge browser");
			WebDriver driver = new EdgeDriver();
			driver.get(URL);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			driver.manage().window().maximize();
		}
		return driver;
	}
}