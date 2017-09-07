package pages;

import java.util.Properties;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.ProjectWrapper;

public class HomePageClass extends ProjectWrapper{
	public HomePageClass(RemoteWebDriver driver, ExtentTest test, Properties prop, Actions builder) {
		this.driver = driver;
		this.test = test;
		this.prop = prop;
		this.builder=builder;
	}
	public PHColcoHomePageClass HomePage() {
		clickByClass(prop.getProperty("ColcoList.Colco"));
		switchWindows();
		return new PHColcoHomePageClass(driver,test,prop,builder);
	}

}
