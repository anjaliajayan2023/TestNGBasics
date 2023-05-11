package TestNGAssignments;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowSwitchingExample {
	public class TestNGBasic {
		WebDriver driver;

		@BeforeMethod
		public void BrowserLaunch1() {
			ChromeOptions co = new ChromeOptions();
			co.addArguments("--remote-allow-origins=*");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(co);
			driver.manage().window().maximize();
		}
		@Test
		public void verifywindow() {
			driver.get(" https://selenium.obsqurazone.com/window-popup.php");
			WebElement likeusonfb=driver.findElement(By.xpath("//a[@class='btn btn-primary windowSingle']"));
	likeusonfb.click();
	String parentwindow = driver.getWindowHandle();// to switch from parent to child
	System.out.println(parentwindow);
	Set<String> windows = driver.getWindowHandles();// it will return id's of current open windows
	System.out.println(windows.size());
	Iterator<String> iterate = windows.iterator();
	while (iterate.hasNext()) {
		String windowidinset = iterate.next();
		if (!parentwindow.equals(windowidinset)) {
			driver.switchTo().window(windowidinset);
		}
	}
	WebElement text=driver.findElement(By.xpath("//div[@class='x1xka2u1 xqfms19']"));
	System.out.println(text);
		}
		@Test
		public void verifyloginbutton() {
		WebElement followall=driver.findElement(By.xpath("//a[@id='windowMulti']"));
		followall.click();
}
		
}
}
