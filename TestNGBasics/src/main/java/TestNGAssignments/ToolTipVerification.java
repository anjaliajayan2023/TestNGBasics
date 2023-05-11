package TestNGAssignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ToolTipVerification {
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
		public void verifytooltipofbuttons() {
			driver.get(" https://selenium.obsqurazone.com/window-popup.php");
			WebElement likeusonfb=driver.findElement(By.xpath("//a[@class='btn btn-primary windowSingle']"));
			String tooltip=likeusonfb.getAttribute("title");
			String expectedtooltip="Follow @obsqurazone on Facebook";
			System.out.println(tooltip);
			softassert.assertEquals(tooltip,expectedtooltip);
			
			
			WebElement followall=driver.findElement(By.xpath("//a[@id='windowMulti']"));
			String tooltip1=followall.getAttribute("title");
			String expectedtooltip1="Follow @obsqurazone";
			System.out.println(tooltip1);
			softassert.assertEquals(tooltip1,expectedtooltip1);
		}
	}
}
