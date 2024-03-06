import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.io.File;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
public class screenshot {
	public static void captureScreenshot(WebDriver driver, String screenshotName) {
        try {
            TakesScreenshot ts = (TakesScreenshot) driver;
            File source = ts.getScreenshotAs(OutputType.FILE);
            String destinationPath = (System.getProperty("user.dir") + "\\screenshots\\" + screenshotName +".png");
            Files.copy(source.toPath(), new File(destinationPath).toPath(), StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Screenshot captured: " + destinationPath);
        } catch (IOException e) {
            System.out.println("Exception while taking screenshot: " + e.getMessage());
        }
	}
}