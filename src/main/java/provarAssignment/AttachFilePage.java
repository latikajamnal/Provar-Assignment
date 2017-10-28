package provarAssignment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

public class AttachFilePage 
{
	WebDriver driver;
	
	public AttachFilePage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void chooseFile(String path)
	{
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.findElement(ObjectRepository.chooseFile).sendKeys(path);
	}
	
	public void clickAttach()
	{
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.findElement(ObjectRepository.attach).click();
	}
	
	public void clickDone()
	{
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.findElement(ObjectRepository.done).click();
	}
}
