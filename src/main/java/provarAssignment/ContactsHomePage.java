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
	
	public void clickNewButtonLight() throws InterruptedException
	{
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(3000);
		driver.findElement(ObjectRepository.newButtonLight).click();
	}
	
	public void clickGo()
	{
		driver.findElement(ObjectRepository.go).click();
		
	}
}
