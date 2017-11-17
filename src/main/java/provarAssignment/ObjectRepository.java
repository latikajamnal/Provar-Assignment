package provarAssignment;

import org.openqa.selenium.By;

public class ObjectRepository 
{
	//SingIn
	static By username=By.xpath("//input[@id='username']");
	static By password=By.xpath("//input[@id='password']");
	static By login=By.xpath("//input[@id='Login']");
	
	//Home Screen
	static By contacts=By.xpath("//a[contains(text(),'Contacts')]");
	static By contactsLight=By.xpath("//span[text()='Contacts']/..");
	static By vF=By.xpath("//a[@title='NewVF Tab']");
	static By vfLight=By.xpath("");
	static By appLauncherLight=By.xpath("//div[@class='slds-icon-waffle']");
	static By vFLight=By.xpath("//span[text()='NewVF']");
	
	//Contacts Home
	static By newButton=By.xpath("//input[@name='new']");
	static By go=By.xpath("//input[@name='go']");
	static By newButtonLight=By.xpath("//div[text()='New']/..");

	
	//Contacts New
	static By salutation=By.xpath("//select[@id='name_salutationcon2']");
	static By firstName=By.xpath("//input[@id='name_firstcon2']");
	static By lastName=By.xpath("//input[@id='name_lastcon2']");
	static By save=By.xpath("//td[@class='pbButton']//input[@name = 'save']");
	static By errors=By.xpath("//div[@class='pbError']");
	static By lookup=By.xpath("//a[@id='con4_lkwgt']");
	static By frame=By.xpath("//frame[@name='resultsFrame']");
	static By firstTableElement=By.xpath("//table[@class='list']/tbody/tr[2]/th/a");
	static By salutationLight=By.xpath("//span[text()='Name']/../following-sibling::div//a[@class='select']");
	static By firstNameLight=By.xpath("//span[text()='First Name']/../following-sibling::input");
	static By lastNameLight=By.xpath("//span[text()='Last Name']/../following-sibling::input");
	static By saveLight=By.xpath("//button[@title='Save']");
	static By errorsLight=By.xpath("//div[@class='genericNotification']");
	static By lookupLight=By.xpath("//span[text()='Account Name']/../following-sibling::div//input[@title='Search Accounts']");
	static By lookupFirstElementLight=By.xpath("//ul[@class='lookup__list  visible']/li[1]//mark");
	
	
	//Contacts View
	static By name=By.xpath("//td[text()='Name']/following-sibling::td[1]/div");
	static By editButton=By.xpath("//h2[text()='Contact Detail']/../following-sibling::td/input[@name='edit']");
	static By mobile=By.xpath("//td[text()='Mobile']/following-sibling::td/div");
	static By mobileafterInlineEdit=By.xpath("//td[text()='Mobile']/following-sibling::td//input");
	static By inlineEditSave=By.xpath("//h2[text()='Contact Detail']/../following-sibling::td/input[@name='inlineEditSave']");
	static By attachFile=By.xpath("//input[@name='attachFile']");
	static By nameLight=By.xpath("//p[text()='Contact']/following-sibling::h1//span");
	static By editButtonLight=By.xpath("//a[@title='Edit']");
	static By detailsTabLight=By.xpath("//a[@title='Details']");
	static By relatedTabLight=By.xpath("//a[@title='Related']");
	static By mobileLight=By.xpath("//span[text()='Mobile']/../following-sibling::div//button");
	static By mobileAfterInlineEditLight=By.xpath("//span[text()='Mobile']/../following-sibling::input");
	static By inlineEditSaveLight=By.xpath("//button[@title='Save']");
	static By attachfileLight=By.xpath("//div[text()='Upload Files']"); 
	static By doneLight=By.xpath("//span[text()='Done']");
	
	//Contacts Edit
	static By saveEdit=By.xpath("//h2[text()='Contact Edit']/../following-sibling::td/input[@name='save']");
	static By phone=By.xpath("//label[text()='Phone']/../following-sibling::td/input");
	static By description=By.xpath("//label[text()='Description']/../following-sibling::td/textarea");
	static By saveEditLight=By.xpath("//button[@title='Save']");
	static By phoneLight=By.xpath("//span[text()='Phone']/../following-sibling::input");
	static By descriptionLight=By.xpath("//span[text()='Description']/../following-sibling::textarea");
	
	//AttachFile
	static By chooseFile=By.xpath("//input[@id='file']");
	static By attach=By.xpath("//input[@name='Attach']");
	static By done=By.xpath("//input[@title='Done']");
	
	//VF
	static By newVF=By.xpath("//h3[text()='Recent NewVF']/../following-sibling::td//input");
	static By newVFName=By.xpath("//input[@id='Name']");
	static By accLookup=By.xpath("//label[text()='Account']/../following-sibling::td//a");
	static By iframe=By.xpath("//frame[@name='searchFrame']");
	static By newInLookup=By.xpath("//input[@name='new']");
	static By iframe2=By.xpath("//frame[@name='resultsFrame']");
	static By accName=By.xpath("//label[text()='Account Name']/../following-sibling::td//input");
	static By saveInLookup=By.xpath("//td[@class='pbButtonb']/input[@value=' Save ']");
	static By saveVF=By.xpath("//h2[text()='NewVF Edit']/../following-sibling::td//input[@name='save']");
	static By newVFLight=By.xpath("//div[@class='slds-grid'][1]//a[@title='New']");
	static By newVFNameLight=By.xpath("//span[text()='NewVF Name']/../following-sibling::input");
	static By accLookupLight=By.xpath("//*[text()='Account']/../following-sibling::div//input");
	static By newAccountVFLight=By.xpath("//*[text()='New Account123']");
	static By accountNameVFLight=By.xpath("//*[text()='Account Name']/../following-sibling::input");
	static By accountSaveLight=By.xpath("//div[@class='DESKTOP uiModal--medium uiModal forceModal open active']//div[@class='modal-footer slds-modal__footer']//button[@title='Save']");
	static By saveVfLight=By.xpath("//div[@class='modal-footer slds-modal__footer']//button[@title='Save']");
}
