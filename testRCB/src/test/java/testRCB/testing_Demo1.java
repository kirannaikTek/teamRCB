package testRCB;

import org.testng.annotations.Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class testing_Demo1 {
	
	private WebDriver driver; 
	String appURL = "http://google.com";

	@BeforeClass
	public void testSetUp() {
		
		driver = new FirefoxDriver();
	}
	
	@Test
	public void verifyGooglePageTittle() {
		driver.navigate().to(appURL);
		String getTitle = driver.getTitle();
		Assert.assertEquals(getTitle, "Google");
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
		//adding
	}
	
}
