import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class searchTest {

	WebDriver driver;
	serachPageFactory spf;

	@Before
	public void beforeTest() {
		System.setProperty("webdriver.chrome.driver", "//Users/ashishbelsarkar/Downloads/chromedriver");
		driver = new ChromeDriver();
		spf = new serachPageFactory(driver);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);
		driver.get("http://www.villaplus.com");
		// tagname[@attribute=value]
	}

	@Test
	public void test() throws Exception {
		spf.selectDestination(2);
		Thread.sleep(5000);
	}

	@After
	public void afterTest() {
		driver.quit();
	}
}
