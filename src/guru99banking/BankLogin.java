package guru99banking;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

public class BankLogin {
	
	static WebDriver driver;
	
	@BeforeMethod
	public void openBrowser()
	{
		//ProfilesIni profile = new ProfilesIni();
		//FirefoxProfile myProfile = profile.getProfile("selenium");
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);
		driver = new FirefoxDriver(dc);
		driver.manage().window().maximize();
		driver.get("http://www.demo.guru99.com/V4/");
		driver.get("http://www.demo.guru99.com/V4/");
	}
	/*
	@BeforeMethod
	public void openWebsite()
	{
		driver.get("http://www.demo.guru99.com/V4/");
	}
	*/
	@Test(dataProvider="guruLogin")
	//@Parameters({"username1","password1"})
	public void testLogin(String username,String password)
	{
		
		String expres = "Welcome To Manager's Page of Guru99 Bank";						
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.name("uid")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.name("btnLogin")).submit();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		try
		{ 		    
	       	Alert alt = driver.switchTo().alert();
	       	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			String actualBoxtitle = alt.getText();
			System.out.println(actualBoxtitle);
			alt.accept();
			if (actualBoxtitle.contains(Util.EXPECT_ERROR)) { 
			    System.out.println("Test case SS: Passed"); 
			} else {
			    System.out.println("Test case SS: Failed");
			}
		}    
	    catch (NoAlertPresentException Ex){ 
	    	String actualTitle = driver.getTitle();
			// On Successful login compare Actual Page Title with Expected Title
			if (actualTitle.contains(expres)) {
			    System.out.println("Test case SS: Passed");
			} else {
			    System.out.println("Test case SS: Failed");
			}		
		
		//String actres = driver.findElement(By.className("heading3")).getText();
		
		//Assert.assertEquals(actres, expres,"Login Failed");
		
		
		//System.out.println("Login Successful");
		//driver.findElement(By.linkText("Log out")).click();
		//driver.switchTo().alert().accept();		
	}
	}
	
	@DataProvider(name="guruLogin")
	public Object[][] testDataProvider()
	{
		return new Object[][] {
				{"mngr33084","uvuvyre"}, 
				{"mngr33084","uvuvygs"},
				{"mngr33034","uvuvyre"},
				{"mngr33054","uhuvyre"}};
		
	}
	
}
