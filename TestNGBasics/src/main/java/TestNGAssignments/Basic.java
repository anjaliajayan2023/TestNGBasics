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

public class Basic {
	WebDriver driver;
	SoftAssert softassert = new SoftAssert();

	@BeforeMethod

	public void BrowserLaunch1() {
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(co);
		driver.manage().window().maximize();

		driver.get("https://selenium.obsqurazone.com/check-box-demo.php");
	}

	@Test
	public void softassertExample() {
		WebElement checkboxdemo = driver
				.findElement(By.xpath("(//div[@class='form-check']//label[@class='form-check-label'][1])"));
		boolean status = checkboxdemo.isDisplayed();
		softassert.assertTrue(status);

		WebElement checkbox1 = driver.findElement(By.xpath("//label[@for='check-box-one']"));
		String expected_name = "Check Box One";
		String actual_name = checkbox1.getText();
		softassert.assertEquals(actual_name, expected_name);
		softassert.assertAll();

	}

}
