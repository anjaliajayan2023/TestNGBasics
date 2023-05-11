package TestNGBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestNGBasic {
	WebDriver driver;
	SoftAssert softassert=new SoftAssert();
	@BeforeMethod
	
	public void BrowserLaunch1() {
		ChromeOptions co=new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver(co);
		driver.manage().window().maximize();
	
	driver.get("https://selenium.obsqurazone.com/simple-form-demo.php");

}
	@Test(priority=-1,enabled=false)
	
	public void verifyurl() {
		String expectedurl="https://selenium.obsqurazone.com/simple-form-demo.php";
		String actualurl=driver.getCurrentUrl();
	Assert.assertEquals(actualurl, expectedurl);//assert-class
}
	@Test(priority=0,enabled=true,dependsOnMethods ="verifyurl")
	public void verifybuttontext() {
		WebElement showmsg=driver.findElement(By.xpath("//button[text()='Show Message']"));
		String expectedtext="Submit";
		String actualbuttontext=showmsg.getText();
		System.out.println(actualbuttontext);
		Assert.assertEquals(actualbuttontext,expectedtext);
	
		}
	@Test(priority=1)
	public void verifycheckboxdemo() {
		WebElement checkboxdemo=driver.findElement(By.xpath("//a[text()='Checkbox Demo']"));
		checkboxdemo.click();
		WebElement singlecheckbox=driver.findElement(By.xpath("//input[@id='gridCheck']"));
		boolean status=singlecheckbox.isDisplayed();
		//Assert.assertEquals(true, status);
		Assert.assertTrue(status,"Box is not displayed");
	}
	@Test
//	//soft assert wont throw an exception whenever tstcasefails
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
