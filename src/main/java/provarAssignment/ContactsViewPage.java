package provarAssignment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class ContactsViewPage 
{
	WebDriver driver;
	
	public ContactsViewPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public String getcontactName()
	{
		String conName=driver.findElement(ObjectRepository.name).getText();
		return conName;
	}
	
	public String getObjectId()
	{
		String viewScreenUrl = driver.getCurrentUrl();
		String id = viewScreenUrl.substring(27);
		return id;
	}
	
	public void inlineEditMobile(String mobile)
	{
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(ObjectRepository.mobile)).doubleClick().build().perform();
		driver.findElement(ObjectRepository.mobileafterInlineEdit).sendKeys(mobile);
		driver.findElement(ObjectRepository.inlineEditSave).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	public String assertMobile()
	{
		String mobileText=driver.findElement(ObjectRepository.mobile).getText();
		return mobileText;
	}
	
	public void clickEdit()
	{
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.findElement(ObjectRepository.editButton).click();
	}
	
	public void clickAttachFile() 
	{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,1000)", "");
		driver.findElement(ObjectRepository.attachFile).click();
	}
	
	
}
