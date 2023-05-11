package TestNGBasics;

import java.util.Iterator;
import java.util.Set;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowExample {
	public class TestNGBasic {
		WebDriver driver;

		@BeforeMethod
		public void BrowserLaunch1() {
			ChromeOptions co = new ChromeOptions();
			co.addArguments("--remote-allow-origins=*");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(co);
			driver.manage().window().maximize();
			driver.get("https://the-internet.herokuapp.com/windows");
		}

		@Test
		public void verifywindow() {
			WebElement clickhere = driver.findElement(By.xpath("//a[text()='Click Here']"));
			clickhere.click();
			clickhere.click();
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
			WebElement newwindow = driver.findElement(By.xpath("//h3[text()='New Window']"));
			newwindow.getText();
			System.out.println(newwindow);
			driver.switchTo().window(parentwindow);
			
		}
	}
}
