package TestNGAssignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SoftAssertOnCss {
	public class SoftAssertExample {
		WebDriver driver;
		SoftAssert softassert = new SoftAssert();
		String color;

		@BeforeMethod

		public void BrowserLaunch1() {
			ChromeOptions co = new ChromeOptions();
			co.addArguments("--remote-allow-origins=*");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(co);
			driver.manage().window().maximize();
			driver.get("https://selenium.obsqurazone.com/bootstrap-alert.php");

		}

		@Test
		public void verifycolorofalertbutton() {
			WebElement normalsuccess = driver.findElement(By.xpath("//button[@id='normal-btn-success']"));
			String backgroundcolor = normalsuccess.getCssValue("background-color");
			String expectedcolor="rgba(40, 167, 69, 1)";
			softassert.assertEquals(expectedcolor,backgroundcolor);
			
			
			WebElement normaldanger = driver.findElement(By.xpath("//button[@id='normal-btn-danger']"));
			String backgroundcolor1 = normaldanger.getCssValue("background-color");
			String expectedcolor1="rgba(220, 53, 69, 1)";
			softassert.assertEquals(expectedcolor1,backgroundcolor1);
			softassert.assertAll();

		}
	}
}
