package TestNGAssignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestNGExplicitWait {
	public class TestNGBasic {
		WebDriver driver;
		SoftAssert softassert = new SoftAssert();

		@BeforeMethod
		public void BrowserLaunch1() {
			ChromeOptions co = new ChromeOptions();
			co.addArguments("--remote-allow-origins=*");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(co);
			driver.manage().window().maximize();

		}

		@Test
		public void verifytextmsgisdisplayedafterclickingstartbutton() {
			WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(6));
			driver.get("https://selenium.obsqurazone.com/jquery-progress-bar.php");
			WebElement startbutton = driver.findElement(By.xpath("//button[@id='downloadButton']"));
			startbutton.click();
			w.until(ExpectedConditions.visibilityOf(startbutton));
			WebElement completetext = driver.findElement(By.xpath("//div[text()='Complete!']"));
			boolean status = completetext.isDisplayed();
			softassert.assertTrue(status);
		}
	}
}
