package package1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Class2 {

	
	@Test
	public void test1()
	{
		//String baseUrl = "http://newtours.demoaut.com";
	/*WebDriver driver = new FirefoxDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.get("http://www.calculator.net/");*/
	int expres = 10;
	int actres = 10;
	Assert.assertEquals(actres, expres);
	System.out.println("passed test1");
	}
	
	@Test
	public void test2()
	{
		int expres = 10;
		int actres = 9;
		Assert.assertEquals(actres, expres,"failed ajay test2");
		System.out.println("passed test2");
	}
	
}
