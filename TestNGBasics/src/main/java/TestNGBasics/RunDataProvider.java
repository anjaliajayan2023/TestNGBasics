package TestNGBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RunDataProvider {
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
		@Test(dataProvider ="amazontestdata",dataProviderClass=DataProviders.class)
		public void verifyproductinsearchfield(String product) {
			
			driver.get("https://www.amazon.in/");
			WebElement searchfield=driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
			searchfield.sendKeys(product);
			WebElement searchbutton=driver.findElement(By.xpath("//input[@id='nav-search-submit-button']"));
		    searchbutton.click();
		    System.out.println(product);
		}
		
		@Test(dataProvider="facebooktestdata",dataProviderClass=DataProviders.class)
public void verifylogin(String email,String passwrd) {
			driver.get("https://www.facebook.com/login/");
			WebElement username=driver.findElement(By.xpath("//input[@id='email']"));
			username.sendKeys(email);
			WebElement password=driver.findElement(By.xpath("//input[@id='pass']"));
			password.sendKeys(passwrd);
			 System.out.println(email);
			 System.out.println(passwrd);
			
		}
	}
}
