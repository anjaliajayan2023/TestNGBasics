package TestNGAssignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AssignmentTestNG {
	WebDriver driver;

	@BeforeMethod

	public void BrowserLaunch1() {
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(co);
		driver.manage().window().maximize();
		
	}
//	@Test
//	
//	public void verifyshowselectedbuttonisdisplayed() {
//	driver.get("https://selenium.obsqurazone.com/radio-button-demo.php");
//		WebElement showselectedbutton=driver.findElement(By.xpath("//button[text()='Show Selected Value']"));
//	boolean status=showselectedbutton.isDisplayed();
//	Assert.assertTrue(status,"Button is not displayed");
//	}
//	@Test
//	public void verifybuttontext() {
//	driver.get("https://selenium.obsqurazone.com/radio-button-demo.php");
//		WebElement buttontext=driver.findElement(By.xpath("//button[text()='Show Selected Value']"));
//	String expectedtext="Show Selected Value";
//		String actualtext=buttontext.getText();
//		System.out.println(actualtext);
//	Assert.assertEquals(actualtext,expectedtext);
//	}
//
	@Test
	public void verifytextofjavascriptalert() {
	driver.get("https://selenium.obsqurazone.com/javascript-alert.php");
	WebElement alert=driver.findElement(By.xpath("//button[@onclick='jsConfirm()']"));
		alert.click();
		String expectedalerttext="Press a button!";
		String actualalerttext=driver.switchTo().alert().getText();
		System.out.println(actualalerttext);
	Assert.assertEquals(actualalerttext, expectedalerttext);
		
		
}
//	@Test
//	public void verifythecheckboxisselected() {
//	driver.get("https://selenium.obsqurazone.com/check-box-demo.php");
//		WebElement checkbox=driver.findElement(By.xpath("//input[@id='gridCheck']"));
//		checkbox.click();
//		boolean status=checkbox.isSelected();
//	
//		if(!checkbox.isSelected()) {
//		checkbox.click();
//		}
//		Assert.assertTrue(status,"Box is not selected");
//	
//	}
//	@Test
//	public void verifytheconfirmationmessageisdisplayed() {
//		driver.get("https://selenium.obsqurazone.com/ajax-form-submit.php ");
//		WebElement subjectfield = driver.findElement(By.xpath("//input[@id='subject']"));
//		subjectfield.sendKeys("Selenium");
//		WebElement description = driver.findElement(By.xpath("//textarea[@class='form-control']"));
//		description.sendKeys("Obsqura");
//		WebElement submit = driver.findElement(By.xpath("//input[@class='btn btn-primar']"));
//		submit.click();
//		WebElement msg = driver.findElement(By.xpath("//div[@id='message-one']"));
//		boolean status = msg.isDisplayed();
//		Assert.assertTrue(status, "Msg is not displayed");
//		System.out.println("Confirmation Message");
//	}
//
}
