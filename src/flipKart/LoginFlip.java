package flipKart;

import guru99banking.Util;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginFlip {

	WebDriver driver;
	
	@BeforeTest
	public void openBrowser()
	{
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		
	}

	
	@Test(dataProvider="fKartLogin") 
	public void login(String username,String password) throws Exception
	{
		driver.get("http://newtours.demoaut.com/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//driver.findElement(By.linkText("Log In")).click();
		driver.findElement(By.name("userName")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.name("login")).click();
		String title = driver.getTitle();
		System.out.println(title);		
	}
	
	@DataProvider(name="fKartLogin")
	public static Object[][] testDataProvider() throws Exception
	{
		/*String pathExcel = System.getProperty("user.dir")+"/testData.xls";
		 return Util.getTableArray(pathExcel,"Data");
		 
        //return (testObjArray);Object[][] testObjArray =*/
        
		return new Object[][] {
				{"Faiz0009","popop"}, 				
				{"mngr33054","uhuvyre"}};
			
	}
			
}
