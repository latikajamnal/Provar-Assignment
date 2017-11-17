package provarAssignment;

import org.openqa.selenium.WebDriver;

public class HomePage
{
	WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void clickContactsTab()
	{
		driver.findElement(ObjectRepository.contacts).click();
	}
	
	public void clickContactsTabLight()
	{
		driver.findElement(ObjectRepository.contactsLight).click();
	}
	
	public void clickVFTab()
	{
		driver.findElement(ObjectRepository.vF).click();
	}
	
	public void clickAppLaucherLight()
	{
		driver.findElement(ObjectRepository.appLauncherLight).click();
	}
	public void clickVFTabLight()
	{
		driver.findElement(ObjectRepository.vFLight).click();
	}
}
