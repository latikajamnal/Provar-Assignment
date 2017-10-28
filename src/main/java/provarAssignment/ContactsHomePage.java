package provarAssignment;

import org.openqa.selenium.WebDriver;

public class ContactsHomePage 
{
	WebDriver driver;
	
	public ContactsHomePage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void clickNewButton()
	{
		driver.findElement(ObjectRepository.newButton).click();
	}
	
	public void clickGo()
	{
		driver.findElement(ObjectRepository.go).click();
		
	}
}
