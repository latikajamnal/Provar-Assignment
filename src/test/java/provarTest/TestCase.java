package provarTest;

import java.awt.AWTException;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import provarAssignment.AttachFilePage;
import provarAssignment.ContactsEditPage;
import provarAssignment.ContactsHomePage;
import provarAssignment.ContactsNewPage;
import provarAssignment.ContactsViewPage;
import provarAssignment.HomePage;
import provarAssignment.ReadFromExcel;
import provarAssignment.SignInPage;
import provarAssignment.VFPage;
import provarAssignment.WriteInExcel;

public class TestCase 
{
	WebDriver driver;
	public SignInPage signIn;
	public HomePage home;
	public ContactsHomePage contactsHome;
	public ContactsNewPage contactsNew;
	public ContactsViewPage contactsView ;
	public WriteInExcel writeExcel;
	public ReadFromExcel readExcel;
	public ContactsEditPage contactsEdit;
	public AttachFilePage attachFile;
	public VFPage vf;
	String filepath=System.getProperty("user.dir")+"\\src\\main\\resources";
	public String currentURL;
	
	@BeforeClass
	public void Initial()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromeDriver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		String url = "https://login.salesforce.com"; 
		driver.get(url);
		driver.manage().window().maximize();
		signIn = new SignInPage(driver);
		home = new HomePage(driver);
		contactsHome = new ContactsHomePage(driver);
		contactsNew = new ContactsNewPage(driver);
		contactsView = new ContactsViewPage(driver);
		writeExcel = new WriteInExcel(driver);
		readExcel = new ReadFromExcel(driver);
		contactsEdit = new ContactsEditPage(driver);
		attachFile = new AttachFilePage(driver);
		vf = new VFPage(driver);
	}
	
	
	@Test(priority=1)
	public void Scenario1() throws Exception
	{	
		signIn.signInToOrg("latika@testing.com", "Provar02"); 
		currentURL=driver.getCurrentUrl();
		//System.out.println("url: "+currentURL);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//Thread.sleep(10000);
		if (currentURL.contains("lightning"))
		{
			driver.findElement(By.xpath("//img[@title='User']")).click();
			driver.findElement(By.xpath("//a[contains(text(),'Switch to Salesforce')]")).click();
		}
		home.clickContactsTab();
		contactsHome.clickNewButton();
		contactsNew.clickSaveButtton();
		contactsNew.verifyErrors();
		String fname = contactsNew.generateRandomCharacters(5);
		String lname = contactsNew.generateRandomCharacters(5);
		contactsNew.setFieldValuesAndClickSave("Mr.", fname, lname);
		String contactName=contactsView.getcontactName();
		String objectId=contactsView.getObjectId();
		HashMap<String, String> data=new HashMap<String, String>();
		data.put(contactName, objectId);
		writeExcel.write(filepath, "Book1.xlsx", data);
		
	}
	
	@Test(priority=2)
	public void Scenario2() throws Exception
	{
		readExcel.read(driver, filepath,  "Book1.xlsx",  "Sheet0");
		String fromExcel =readExcel.read(driver, filepath,  "Book1.xlsx",  "Sheet0");
		//System.out.println("Scenario2: "+fromExcel);
		String fname=fromExcel.substring(4,9);
		//System.out.println("Scenario 2: "+fname);
		home.clickContactsTab();
		//contactsHome.clickGo();
		driver.findElement(By.xpath("//table[@class='list']/tbody/tr/th/a[contains(text(),'"+fname+"')]")).click();	
		
	}
	
	@Test(priority=3)
	public void Scenario3() throws Exception
	{
		readExcel.read(driver, filepath,  "Book1.xlsx",  "Sheet0");
		contactsView.clickEdit();
		contactsEdit.setPhone("73787578345");
		contactsEdit.setDescription("Automated Test");
		contactsEdit.assertDescription();
		contactsEdit.clickSave();
		contactsView.inlineEditMobile("8762903748");
		contactsView.assertMobile();
	}
	
	@Test(priority=4)
	public void Scenario4() 
	{
		driver.navigate().refresh();
		contactsView.clickAttachFile();
		attachFile.chooseFile(filepath+"\\provar.jpg");
		attachFile.clickAttach();
		attachFile.clickDone();
	}
	
	@Test(priority=5)
	public void Scenario5()
	{
		home.clickVFTab();
		vf.setAndSaveVF("Test", "Test");
	}
	
  //Lightning
	@Test(priority =6)
	public void Scenario6() throws IOException, InterruptedException
	{
		driver.findElement(By.xpath("//span[@id='userNavLabel']")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Switch to Lightning')]")).click();
		home.clickContactsTabLight();
		contactsHome.clickNewButtonLight();
		contactsNew.clickSaveButtonLight();
		contactsNew.verifyErrorsLight();
		String fname = contactsNew.generateRandomCharacters(5);
		String lname = contactsNew.generateRandomCharacters(5);
		contactsNew.setFieldValuesAndClickSaveLight("Mr.", fname, lname, "Test");
		String contactNameLight=contactsView.getContactNameLight();
		String objectIdLight=contactsView.getObjectIdLight();
		HashMap<String, String> data=new HashMap<String, String>();
		data.put(contactNameLight, objectIdLight);
		writeExcel.write(filepath, "Book1.xlsx", data);
	}
	
	
	@Test(priority=7)
	public void Scenario7() throws Exception
	{
		readExcel.read(driver, filepath,  "Book1.xlsx",  "Sheet0");
		String fromExcel =readExcel.read(driver, filepath,  "Book1.xlsx",  "Sheet0");
		String fname=fromExcel.substring(10);
		//System.out.println("String from excel: "+fromExcel);
		home.clickContactsTabLight();
		//System.out.println("done till home tab");
		Thread.sleep(5000);
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//div[@class='listViewContent slds-table--header-fixed_container']//table/tbody/tr[1]/th//a[contains(text(),'"+fname+"')]")).click();	
		
		
	}
	
	@Test(priority=8)
	public void Scenario8() throws Exception
	{
		readExcel.read(driver, filepath,  "Book1.xlsx",  "Sheet0");
		contactsView.clickEditLight();
		contactsEdit.setPhoneLight("73787578345");
		contactsEdit.setDescriptionLight("Automated Test");
		contactsEdit.assertDescriptionLight();
		contactsEdit.clickSaveLight();
		Thread.sleep(5000);
		contactsView.inlineEditMobileLight("8762903748");
		contactsView.assertMobileLight();
	}
	
	@Test(priority=9)
	public void Scenario9() throws InterruptedException, AWTException 
	{
		
		contactsView.clickAttachFileLight();
		Thread.sleep(3000);
		contactsView.setClipboard(filepath+"\\provar.jpg");
		contactsView.uploadFileLight(filepath+"\\provar.jpg");
		Thread.sleep(5000);
		contactsView.clickDoneLight();
		Thread.sleep(3000);
		
	}
	
	@Test(priority=10)
	public void Scenario10() throws InterruptedException
	{
		home.clickAppLaucherLight();
		home.clickVFTabLight();
		Thread.sleep(3000);
		vf.clickNewVFLight();
		vf.setNewVFNameLight("Test");
		vf.setLookupLight();
		vf.setAccountNameLight("Test");
		vf.clickSaveAccountLight();
		Thread.sleep(5000);
		vf.clickSaveLight();
	}
	
	/*
	@AfterClass
	public void Quit()
	{
		driver.close();
	}*/
	
}
