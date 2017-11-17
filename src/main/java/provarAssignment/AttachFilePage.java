package provarAssignment;


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
		driver.findElement(ObjectRepository.chooseFile).sendKeys(path);
	}
	
	public void clickAttach()
	{
		driver.findElement(ObjectRepository.attach).click();
	}
	
	public void clickDone()
	{
		driver.findElement(ObjectRepository.done).click();
	}
}
