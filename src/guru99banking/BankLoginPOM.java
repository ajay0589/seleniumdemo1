package guru99banking;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.testng.annotations.Test;

public class BankLoginPOM {

	WebDriver driver;

	@Test
	public void testLogin()
	{
		
		String expres = "Welcome To Manager's Page of Guru99 Bank";
		//WebDriver driver = new FirefoxDriver();
		//openBrowser();
		driver.manage().window().maximize();
		driver.get(Util.BASE_URL);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.name("uid")).sendKeys();
		driver.findElement(By.name("password")).sendKeys();
		driver.findElement(By.name("btnLogin")).submit();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		System.out.println(driver.findElement(By.className("heading3")).getText());
		
		String actres = driver.findElement(By.className("heading3")).getText();
		
		Assert.assertEquals(actres, expres,"Login Failed");
		
		System.out.println("Login Successful");
		driver.close();
		//driver.findElement(By.linkText("Log out")).click();
		//driver.switchTo().alert().accept();		
	}
	
	@BeforeMethod
	public void openBrowser()
	{
		ProfilesIni profile = new ProfilesIni();
		FirefoxProfile myProfile = profile.getProfile("selenium");
		driver = new FirefoxDriver(myProfile);
	}
	
	/*public static void main(String args[])
	{
		BankLoginPOM login = new BankLoginPOM();
		login.testLogin();
	}
	*/
}
