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

public class SoftAssertGetNewUser {
	public class TestNGBasic {
		WebDriver driver;
		SoftAssert softassert=new SoftAssert();

		@BeforeMethod
		public void BrowserLaunch1() {
			ChromeOptions co = new ChromeOptions();
			co.addArguments("--remote-allow-origins=*");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(co);
			driver.manage().window().maximize();
			
		}
		@Test
		public void verifytextbuttonofgetnewuser() {
			WebDriverWait w=new WebDriverWait(driver, Duration.ofSeconds(6));
			driver.get("https://selenium.obsqurazone.com/dynamic-load.php");
			WebElement getnewuser=driver.findElement(By.xpath("//button[@class='btn btn-info']"));
			getnewuser.click();
			w.until(ExpectedConditions.visibilityOf(getnewuser));
			String actualtext=getnewuser.getText();
			String expectedtext="Get New User";
			System.out.println(actualtext);
			softassert.assertEquals(actualtext, expectedtext);
			
			WebElement image=driver.findElement(By.xpath("//div[@class='card text-center']"));
			boolean status=image.isDisplayed();
			softassert.assertTrue(status);
			
		}

}
}
