package TestNGBasics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataProviders {
	
	        @DataProvider(name="amazontestdata")
	    	public Object[][] testdata()
	    	{
   		return new Object [][] {{"shoe"},{"watch"},{"phone"},{"bag"}};
   	}
	        @DataProvider(name="facebooktestdata")
	        public Object[][] getdata()
	    	{
	    		 Object [][] data= {{"test@gmail.com","123@123"}};
	    	return data;
	    	}
		}
	
