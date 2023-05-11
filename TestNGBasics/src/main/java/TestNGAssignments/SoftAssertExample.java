package TestNGAssignments;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SoftAssertExample {
	WebDriver driver;
	SoftAssert softassert=new SoftAssert();

	@BeforeMethod

	public void BrowserLaunch1() {
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(co);
		driver.manage().window().maximize();
		driver.get("https://selenium.obsqurazone.com/bootstrap-dual-list.php");
	}
@Test
public void verifytextofoptions() {
	driver.findElement(By.xpath("//select[@id='bootstrap-duallistbox-nonselected-list_duallistbox_demo1[]']//option"));
List<WebElement>options=driver.findElements(By.xpath("//select[@id='bootstrap-duallistbox-nonselected-list_duallistbox_demo1[]']//option"));
for (int i=0;i<options.size();i++) {
    String expectedText="option";
    String actualText=options.get(i).getText();
    softassert.assertEquals(actualText,expectedText);
   
}

}
}
