package provarAssignment;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class ContactsNewPage 
{
	WebDriver driver;
	public ContactsNewPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public static final String CHARACTERS = "abcdefghijklmnopqrstuvwxyz";
	// Generate random characters of given size
		public String generateRandomCharacters(int size) 
		{
		Random randomGenerator = new Random();
			StringBuffer randStr = new StringBuffer();
			for (int i = 0; i < size; i++) 
			{
				int number = randomGenerator.nextInt(CHARACTERS.length() - 1);
				char ch = CHARACTERS.charAt(number);
				randStr.append(ch);
			}
			return randStr.toString();
		}
		
	
	public void setSalutation(String Salutation)
	{
		Select salutation = new Select(driver.findElement(ObjectRepository.salutation));
		salutation.selectByVisibleText(Salutation);
	}
	
	public void setSalutationLight(String Salutation)
	{
		driver.findElement(ObjectRepository.salutationLight).sendKeys(Salutation);
		driver.findElement(ObjectRepository.lookupFirstElementLight).click();
		
	}
	
	public void setFirstName(String FirstName)
	{
		driver.findElement(ObjectRepository.firstName).sendKeys(FirstName);
	}
	
	public void setFirstNameLight(String FirstName)
	{
		driver.findElement(ObjectRepository.firstNameLight).sendKeys(FirstName);
	}
	
	public void setLastName(String LastName)
	{
		driver.findElement(ObjectRepository.lastName).sendKeys(LastName);;
	}
	
	public void setLastNameLight(String LastName)
	{
		driver.findElement(ObjectRepository.lastNameLight).sendKeys(LastName);
	}
	
	public void clickLookUp()
	{
		driver.findElement(ObjectRepository.lookup).click();
	}
	
	public void setLookupLight(String name) throws InterruptedException
	{		
		driver.findElement(ObjectRepository.lookupLight).sendKeys(name);
		Thread.sleep(3000);
		driver.findElement(ObjectRepository.lookupFirstElementLight).click(); 
	}
	
	public void setValueInsideLookup()
	{
		List<String> winHan= new ArrayList<String>();
		for (String handle : driver.getWindowHandles()) 
		 {
				winHan.add(handle);
		 }
		driver.switchTo().window(winHan.get(1));
		//driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.switchTo().frame(driver.findElement(ObjectRepository.frame));
		//driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.findElement(ObjectRepository.firstTableElement).click();
		driver.switchTo().window(winHan.get(0));
	}
	
	public void clickSaveButtton()
	{
		//driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.findElement(ObjectRepository.save).click();;
	}
	
	public void clickSaveButtonLight()
	{
		driver.findElement(ObjectRepository.saveLight).click();
	}
	
	public void verifyErrors()
	{
		String textOfErrors=driver.findElement(ObjectRepository.errors).getText();
		System.out.println("Error Text: "+textOfErrors);
		boolean isErrorsDisplayed = driver.findElement(ObjectRepository.errors).isDisplayed();
		System.out.println("Is Error displayed on screen: "+isErrorsDisplayed);
	}
	
	public void verifyErrorsLight()
	{
		String textOfErrorsLight=driver.findElement(ObjectRepository.errorsLight).getText();
		System.out.println("Error Text: "+textOfErrorsLight);
		boolean isErrorsDisplayed = driver.findElement(ObjectRepository.errorsLight).isDisplayed();
		System.out.println("Is Error displayed on screen: "+isErrorsDisplayed);
	}
	
	public void setFieldValuesAndClickSave(String Salutation, String FirstName, String LastName )
	{
		setSalutation(Salutation);
		setFirstName(FirstName);
		setLastName(LastName);
		clickLookUp();
		setValueInsideLookup();
		clickSaveButtton();
	}
	public void setFieldValuesAndClickSaveLight(String Salutation, String FirstName, String LastName, String name ) throws InterruptedException
	{
		setFirstNameLight(FirstName);
		setLastNameLight(LastName);
		setLookupLight(name);
		clickSaveButtonLight();
	}
}
