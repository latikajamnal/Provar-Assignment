package provarTest;

import java.util.HashMap;
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
	
	@BeforeClass
	public void Initial()
	{
			
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromeDriver\\chromedriver.exe");
		driver=new ChromeDriver();
		System.out.println("contact");
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
		String fname=fromExcel.substring(10);
		home.clickContactsTab();
		contactsHome.clickGo();
		driver.findElement(By.xpath("//table[@class='x-grid3-row-table']/tbody/tr/td[4]//span[contains(text(),'"+fname+"')]")).click();	
		
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
	
	@AfterClass
	public void Quit()
	{
		driver.close();
	}
	
}
