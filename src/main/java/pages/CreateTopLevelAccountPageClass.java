package pages;

import java.util.Properties;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.ProjectWrapper;

public class CreateTopLevelAccountPageClass extends ProjectWrapper{
	public CreateTopLevelAccountPageClass(RemoteWebDriver driver, ExtentTest test, Properties prop, Actions builder){
		this.driver = driver;
		this.test = test;
		this.prop = prop;
		this.builder=builder;
		}
	public void CreateTopLevelAccountPage(String FullName, String ShortName, String TradingName, String VATRegNumber, String CreditLimit) throws InterruptedException {
		selectByXpath(prop.getProperty("CreateCustomer.lineOfBusiness"),1);
		enterByXpath(prop.getProperty("CreateCustomer.txtFullName"),FullName);
		enterByXpath(prop.getProperty("CreateCustomer.txtShortName"),ShortName);
		enterByXpath(prop.getProperty("CreateCustomer.txtTradingName"),TradingName);
		selectByXpath(prop.getProperty("CreateCustomer.LegalEntityID"),1);
		enterByXpath(prop.getProperty("CreateCustomer.txtVATRegNumber"),VATRegNumber);
		selectByXpath(prop.getProperty("CreateCustomer.CustomerBand"),1);
		selectByXpath(prop.getProperty("CreateCustomer.MarketingSegmentation"),1);
		selectByXpath(prop.getProperty("CreateCustomer.PriceProfileID"),1);
		selectByXpath(prop.getProperty("CreateCustomer.FeeGroupID"),1);
		selectByXpath(prop.getProperty("CreateCustomer.BillingLanguage"),1);
		selectByXpath(prop.getProperty("CreateCustomer.AcquisitionChannel"),1);
		selectByXpath(prop.getProperty("CreateCustomer.CustomerClassificationID"),1);
		enterByXpath(prop.getProperty("CreateCustomer.txtCreditLimit"),CreditLimit.substring(0, 3));
		clickById(prop.getProperty("CreateCustomer.lnkSave"));
		verifyTextByXpathUsingSplit(prop.getProperty("CreateCustomer.title"),9);
		 
	}

}
