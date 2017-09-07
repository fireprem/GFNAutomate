package pages;

import java.util.Properties;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import wrappers.ProjectWrapper;

public class PHColcoHomePageClass extends ProjectWrapper{
	public PHColcoHomePageClass(RemoteWebDriver driver, ExtentTest test, Properties prop, Actions builder) {
		this.driver = driver;
		this.test = test;
		this.prop = prop;
		this.builder=builder;
	}
	public CreateTopLevelAccountPageClass PHColcoHomePage() throws InterruptedException {
		moveToElement(prop.getProperty("HomePage.Start"));
		Thread.sleep(1500);
		moveToElement(prop.getProperty("HomePage.Customer"));
		Thread.sleep(1500);
		moveToElement(prop.getProperty("HomePage.CreateCustomer"));
		clickByXpath(prop.getProperty("HomePage.CreateTopLevelCustomer"));
		Thread.sleep(1500);
		return new CreateTopLevelAccountPageClass(driver, test, prop,builder);
	}

}
