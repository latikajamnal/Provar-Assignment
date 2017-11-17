package provarAssignment;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

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
	
	String filePath=System.getProperty("user.dir")+"\\src\\main\\resources";
	public String getcontactName()
	{
		String conName=driver.findElement(ObjectRepository.name).getText();
		return conName;
	}
	
	public String getContactNameLight()
	{
		String conNameLight=driver.findElement(ObjectRepository.nameLight).getText();
		//System.out.println("Here I am with Name: "+conNameLight);
		return conNameLight;
	}
	
	public String getObjectId()
	{
		String viewScreenUrl = driver.getCurrentUrl();
		String id = viewScreenUrl.substring(27);
		return id;
	}
	
	public String getObjectIdLight()
	{
		String viewScreenUrlLight=driver.getCurrentUrl();
		String id = viewScreenUrlLight.substring(66, 84);
		//System.out.println("Here I am with obj ID: "+id);
		return id;
	}
	
	public void inlineEditMobile(String mobile)
	{
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(ObjectRepository.mobile)).doubleClick().build().perform();
		driver.findElement(ObjectRepository.mobileafterInlineEdit).sendKeys(mobile);
		driver.findElement(ObjectRepository.inlineEditSave).click();
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	public void inlineEditMobileLight(String mobile) throws InterruptedException
	{
		driver.findElement(ObjectRepository.detailsTabLight).click();
		driver.findElement(ObjectRepository.mobileLight).click();
		driver.findElement(ObjectRepository.mobileAfterInlineEditLight).sendKeys(mobile);
		driver.findElement(ObjectRepository.inlineEditSaveLight).click();
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	public String assertMobile()
	{
		String mobileText=driver.findElement(ObjectRepository.mobile).getText();
		return mobileText;
	}
	
	public String assertMobileLight()
	{
		String mobileText=driver.findElement(ObjectRepository.mobileLight).getText();
		return mobileText;
	}
	public void clickEdit() throws InterruptedException
	{
		//driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		Thread.sleep(3000);
		driver.findElement(ObjectRepository.editButton).click();
	}
	
	public void clickEditLight() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.findElement(ObjectRepository.editButtonLight).click();
	}
	
	public void clickAttachFile() 
	{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,1000)", "");
		driver.findElement(ObjectRepository.attachFile).click();
	}
	
	public void clickAttachFileLight() throws InterruptedException 
	{
		driver.findElement(ObjectRepository.relatedTabLight).click();
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,1000)", "");
		Thread.sleep(3000);
		driver.findElement(ObjectRepository.attachfileLight).click();
		//Thread.sleep(3000);

	}
	
	public void clickDoneLight() throws InterruptedException
	{
		Thread.sleep(5000);
		driver.findElement(ObjectRepository.doneLight).click();
	}
	
	
	public void setClipboard(String path)
	{
		//String fileLocation=filePath+"\\provar.jpg";
		StringSelection stringSelect = new StringSelection(path);
		Clipboard clip = Toolkit.getDefaultToolkit().getSystemClipboard();
		clip.setContents(stringSelect, null);
	}
	public void uploadFileLight(String path) throws AWTException
	{
		setClipboard(path);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		   robot.keyPress(KeyEvent.VK_V);
		   robot.keyRelease(KeyEvent.VK_V);
		   robot.keyRelease(KeyEvent.VK_CONTROL);
		   robot.keyPress(KeyEvent.VK_ENTER);
		   robot.keyRelease(KeyEvent.VK_ENTER);
	}
	
}
