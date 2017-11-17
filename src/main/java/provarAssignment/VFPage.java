package provarAssignment;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebDriver;

public class VFPage 
{
	WebDriver driver;
	
	public VFPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void clickNewVF()
	{
		driver.findElement(ObjectRepository.newVF).click();;
	}
	
	public void clickNewVFLight()
	{
		driver.findElement(ObjectRepository.newVFLight).click();
	}
	
	public void setNewVFName(String VFName)
	{
		driver.findElement(ObjectRepository.newVFName).sendKeys(VFName);
	}
	
	public void setNewVFNameLight(String name)
	{
		driver.findElement(ObjectRepository.newVFNameLight).sendKeys(name);
	}
	
	public void clickLookup()
	{
		driver.findElement(ObjectRepository.accLookup).click();
	}
	
	public void setlookupValue(String AcName)
	{
		List<String> winHan= new ArrayList<String>();
		for (String handle : driver.getWindowHandles()) 
		 {
				winHan.add(handle);
		 }
		driver.switchTo().window(winHan.get(1));
		driver.switchTo().frame(driver.findElement(ObjectRepository.iframe));
		driver.findElement(ObjectRepository.newInLookup).click();
		driver.switchTo().parentFrame();
		driver.switchTo().frame(driver.findElement(ObjectRepository.iframe2));
		driver.findElement(ObjectRepository.accName).sendKeys(AcName);
		driver.findElement(ObjectRepository.saveInLookup).click();
		driver.switchTo().window(winHan.get(0));
	}
	
	public void setLookupLight() throws InterruptedException
	{
		driver.findElement(ObjectRepository.accLookupLight).click();
		Thread.sleep(5000);
		driver.findElement(ObjectRepository.newAccountVFLight).click();
	}
	
	public void clickSave()
	{
		driver.findElement(ObjectRepository.saveVF).click();
	}
	
	public void setAccountNameLight(String name)
	{
		driver.findElement(ObjectRepository.accountNameVFLight).sendKeys(name);
	}
	
	public void clickSaveAccountLight()
	{
		driver.findElement(ObjectRepository.accountSaveLight).click();
	}
	public void clickSaveLight()
	{
		driver.findElement(ObjectRepository.saveVfLight).click();
	}
	
	public void setAndSaveVF(String VFName, String AcName)
	{
		clickNewVF();
		setNewVFName(VFName);
		clickLookup();
		setlookupValue(AcName);
		clickSave();
	}
}
