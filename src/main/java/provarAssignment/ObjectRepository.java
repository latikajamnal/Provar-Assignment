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
	static By vF=By.xpath("//a[@title='NewVF Tab']");
	
	//Contacts Home
	static By newButton=By.xpath("//input[@name='new']");
	static By go=By.xpath("//input[@name='go']");
	
	//Contacts New
	static By salutation=By.xpath("//select[@id='name_salutationcon2']");
	static By firstName=By.xpath("//input[@id='name_firstcon2']");
	static By lastName=By.xpath("//input[@id='name_lastcon2']");
	static By save=By.xpath("//td[@class='pbButton']//input[@name = 'save']");
	static By errors=By.xpath("//div[@class='pbError']");
	static By lookup=By.xpath("//a[@id='con4_lkwgt']");
	static By frame=By.xpath("//frame[@name='resultsFrame']");
	static By firstTableElement=By.xpath("//table[@class='list']/tbody/tr[2]/th/a");
	
	//Contacts View
	static By name=By.xpath("//td[text()='Name']/following-sibling::td[1]/div");
	static By editButton=By.xpath("//h2[text()='Contact Detail']/../following-sibling::td/input[@name='edit']");
	static By mobile=By.xpath("//td[text()='Mobile']/following-sibling::td/div");
	static By mobileafterInlineEdit=By.xpath("//td[text()='Mobile']/following-sibling::td//input");
	static By inlineEditSave=By.xpath("//h2[text()='Contact Detail']/../following-sibling::td/input[@name='inlineEditSave']");
	static By attachFile=By.xpath("//input[@name='attachFile']");
	
	//Contacts Edit
	static By saveEdit=By.xpath("//h2[text()='Contact Edit']/../following-sibling::td/input[@name='save']");
	static By phone=By.xpath("//label[text()='Phone']/../following-sibling::td/input");
	static By description=By.xpath("//label[text()='Description']/../following-sibling::td/textarea");
	
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
	
}
