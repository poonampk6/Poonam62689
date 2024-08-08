package POM_DWSVtiger;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import FileUtility.PropertyUtil;

public class Login 
{

	PropertyUtil putil = new PropertyUtil();
	public Login(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	private @FindBy(name = "user_name")
	WebElement uName;
	
	public WebElement getUsername()
	{
		return uName;
	}
	
	private @FindBy(name = "user_password")
	WebElement pass;
	
	public WebElement getPassword()
	{
		return pass;
	}
	
	private @FindBy(id = "submitButton")
	WebElement loginBtn;
	
	public WebElement getLogin()
	{
		return loginBtn;
	}
	
	public void login() throws IOException
	{
		getUsername().sendKeys(putil.getInputData("Username"));
		getPassword().sendKeys(putil.getInputData("Password_Vtiger"));
		getLogin().click();
	}
}
