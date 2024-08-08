package BaseClass;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import FileUtility.PropertyUtil;
import POM_DWSVtiger.DwsLogin;
import POM_DWSVtiger.HomePage;

public class BaseClass_DWS {

	PropertyUtil pUtil = new PropertyUtil();
	public static WebDriver driver;
	
	@BeforeClass
	public void preCondition() throws IOException
	{
		String browser = pUtil.getInputData("Browser");
		String url = pUtil.getInputData("Url_Dws");

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
		DwsLogin l = new DwsLogin(driver);
		l.Login();
	}
	
	@AfterMethod
	public void logout()
	{
//		driver.findElement(By.partialLinkText("Log out")).click();
		HomePage hPage = new HomePage(driver);
		hPage.logOut();
	}
	
	@AfterClass
	public void postCondition()
	{
		driver.quit();
	}
}
