package provarAssignment;

import java.util.concurrent.TimeUnit;
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
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.findElement(ObjectRepository.contacts).click();
	}
	
	public void clickVFTab()
	{
		driver.findElement(ObjectRepository.vF).click();
	}
}
