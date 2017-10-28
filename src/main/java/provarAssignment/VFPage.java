package provarAssignment;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

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
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(ObjectRepository.newVF).click();;
	}
	
	public void setNewVFName(String VFName)
	{
		driver.findElement(ObjectRepository.newVFName).sendKeys(VFName);
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
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.switchTo().frame(driver.findElement(ObjectRepository.iframe));
		driver.findElement(ObjectRepository.newInLookup).click();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.switchTo().parentFrame();
		driver.switchTo().frame(driver.findElement(ObjectRepository.iframe2));
		driver.findElement(ObjectRepository.accName).sendKeys(AcName);
		driver.findElement(ObjectRepository.saveInLookup).click();
		driver.switchTo().window(winHan.get(0));
	}
	
	public void clickSave()
	{
		driver.findElement(ObjectRepository.saveVF).click();
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
