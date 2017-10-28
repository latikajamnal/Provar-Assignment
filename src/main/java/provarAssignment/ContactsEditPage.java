package provarAssignment;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class ContactsEditPage 
{
	WebDriver driver;
	
	public ContactsEditPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void setPhone(String phone)
	{
		driver.findElement(ObjectRepository.phone).sendKeys(phone);
	}
	
	public void setDescription(String description)
	{
		driver.findElement(ObjectRepository.description).sendKeys(description);
	}
	
	public String assertDescription()
	{
		String description=driver.findElement(ObjectRepository.description).getText();
		return description;
	}
	public void clickSave()
	{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,-1000)", "");
		driver.findElement(ObjectRepository.saveEdit).click();
	}
}
