package wrappers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Driver;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class GeneralWrapper {
	public RemoteWebDriver driver;
	public Actions builder;
	public Properties prop = null;
	public void launchUrl(String URL) {
		try {
			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			driver = new ChromeDriver();
			driver.get(URL);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			builder = new Actions(driver);
			logStatus("pass","URL "+ URL + " is launched successfully");
		} catch (Exception e) {
			logStatus("fail","URL "+ URL + " is not launched successfully");
		}
	}
	public void clickByClass(String className) {
		try {
			driver.findElementByClassName(className).click();
			logStatus("pass","Element "+ className + " is clicked successfully");
		} catch (Exception e) {
			logStatus("fail","Element "+ className + " is not clicked successfully");
		}
	}
	public void switchWindows() {
		try {
			Set<String> win =driver.getWindowHandles();
			for (String string : win) {driver.switchTo().window(string);}
			driver.manage().window().maximize();
			logStatus("pass","Windows Switch successful");
		} catch (Exception e) {
			logStatus("fail","Windows Switch not successful");
		}

	}
	public void moveToElement(String xPath) {
		try {
			WebElement start = driver.findElementByXPath(xPath);
			builder.moveToElement(start).build().perform();
			logStatus("pass","Move to Element "+ xPath + " is successfully");	
		} catch (Exception e) {
			logStatus("fail","Move to Element "+ xPath + " is not successfully");
		}

	}
	public void clickByXpath(String xPath) {
		try {
			driver.findElementByXPath(xPath).click();
			logStatus("pass","Element "+ xPath + " is clicked successfully");
		} catch (Exception e) {
			logStatus("fail","Element "+ xPath + " is not clicked successfully");
		}
	}
	public void selectByXpath(String xPath, int index) {
		try {
			new Select(driver.findElementByXPath(xPath)).selectByIndex(index);
			logStatus("pass","DropDown "+ xPath + " is selected successfully");
		} catch (Exception e) {
			logStatus("fail","DropDown "+ xPath + " is not selected successfully");
		}
	}
	public void enterByXpath(String xPath, String value) {
		try {
			driver.findElementByXPath(xPath).sendKeys(value);
			logStatus("pass","Value "+ value + " is entered in the Element " + xPath + " is selected successfully");
		} catch (Exception e) {
			logStatus("fail","Value "+ value + " is not entered in the Element " + xPath + " is selected successfully");
		}
	}
	public void clickById(String id) {
		try {
			driver.findElementById(id).click();
			logStatus("pass","Element "+ id + " is clicked successfully");
		} catch (Exception e) {
			logStatus("fail","Element "+ id + " is clicked successfully");
		}
	}
	public void verifyTextByXpathUsingSplit(String Xpath, int split) {
		try {
			String[] customerERP = ((driver.findElementByXPath(Xpath).getText()).split(" "));
			logStatus("pass","Account created : "+ customerERP[split]);
		} catch (Exception e) {
			logStatus("fail","Account not created");
		}
	}

	public String takeSnap() {
		String timestam = new SimpleDateFormat("yyyyMMddHHmmss").format(System.currentTimeMillis()); 
		try {
			File screenshot = driver.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshot, new File("./report/snaps/snap"+timestam+".png"));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return timestam;	
	}
	public ExtentReports report;
	public ExtentTest test;
	public void createReport() {
		report = new ExtentReports("./report/GFNReport.html");
	}
	public void startTest(String testCaseName, String testCaseDescription) {
		test = report.startTest(testCaseName, testCaseDescription);
	}
	public void logStatus(String status, String stepDescription) {
		switch (status) {
		case "pass":
			test.log(LogStatus.PASS, stepDescription+test.addScreenCapture("../report/snaps/snap"+takeSnap()+".png"));	
			break;
		case "fail":
			test.log(LogStatus.FAIL, stepDescription+test.addScreenCapture("../report/snaps/snap"+takeSnap()+".png"));	
			break;
		}

	}
	public void generateReport() {
		report.endTest(test);
		report.flush();
		report.close();
	}

	public void loadProperty(String path) {
		try {
			prop = new Properties();
			prop.load(new FileInputStream(new File(path)));
		} catch (IOException e) {

		}
	}

}
