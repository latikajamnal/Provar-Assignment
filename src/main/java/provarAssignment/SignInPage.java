package provarAssignment;

import org.openqa.selenium.WebDriver;
public class SignInPage
{
	WebDriver driver;
	
	public SignInPage(WebDriver driver)
	{	
		this.driver=driver;
	}
		
	public void email(String UserName)
	{
		driver.findElement(ObjectRepository.username).sendKeys(UserName);
	}
	
	public void pass(String Password)
	{
		driver.findElement(ObjectRepository.password).sendKeys(Password);
	}
	
	public void signIn()
	{
		driver.findElement(ObjectRepository.login).click();
	}
	
	public void signInToOrg(String UserName,String Password)
	{
		email(UserName);
		pass(Password);
		signIn();
	}
}
