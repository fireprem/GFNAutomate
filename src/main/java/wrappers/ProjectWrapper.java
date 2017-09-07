package wrappers;

import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import utils.ReadExcel;

public class ProjectWrapper extends GeneralWrapper{
	
	@BeforeTest
	@DataProvider(name = "CreateAccountData")
	public String[][] getdata() throws IOException{
	ReadExcel obj = new ReadExcel();
	return obj.readExcel("TC_001");	
	}
	@BeforeSuite
	public void startReport() {
		createReport();
	}
	@AfterSuite
	public void stopReport() {
		generateReport();
	}


	

}
