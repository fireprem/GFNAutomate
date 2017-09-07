package testCase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;
import org.testng.annotations.Test;

import pages.CreateTopLevelAccountPageClass;
import pages.HomePageClass;
import pages.PHColcoHomePageClass;
import wrappers.ProjectWrapper;


public class CreateAccount extends ProjectWrapper{
	
		@Test(dataProvider = "CreateAccountData")
		public void cAccount(String FullName, String ShortName, String TradingName, String VATRegNumber, String CreditLimit) throws InterruptedException  {
			startTest("Create Account", "Creating Top level Account");
			loadProperty("./src/main/java/utils/OR");
			launchUrl("http://ukwalshellqa02/gfnlaunch/");
			new HomePageClass(driver, test, prop,builder).HomePage()
			.PHColcoHomePage()
			.CreateTopLevelAccountPage(FullName, ShortName, TradingName, VATRegNumber, CreditLimit);
			
		}

}
