package BaseClass;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import FileUtility.PropertyUtil;
import POM_DWSVtiger.Home;
import POM_DWSVtiger.Login;

public class BaseClass_Vtiger {

    PropertyUtil putil = new PropertyUtil();
	public static WebDriver driver;
    
	@BeforeClass
	public void preCondition() throws IOException
	{
		String browser = putil.getInputData("Browser");
		String url = putil.getInputData("Url_Vtiger");
		
		if(browser.equalsIgnoreCase("chrome"))
		{
			driver = new ChromeDriver();
		}else if(browser.equalsIgnoreCase("edge"))
		{
			driver = new EdgeDriver();
		}else {
			driver = new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get(url);
	}
	 
	@BeforeMethod
	public void login() throws IOException
	{
		Login l = new Login(driver);
		l.login();
	}
	
	@AfterMethod
	public void logout()
	{
		Home h = new Home(driver);
		h.logout(driver);
	}
	
	@AfterClass
	public void postCondition()
	{
		driver.quit();
	}
}
