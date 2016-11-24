import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class appDTest {

	// FirefoxDriver driver = new FirefoxDriver();
	WebDriver driver;

	@Test
	public void rndAppDirect() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "//Users/ashishbelsarkar/Downloads/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://marketplace.appdirect.com/signup?1875094949");
		WebElement btnSignup = driver.findElement(By.name("userSignupButton"));
		btnSignup.click();
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// js.executeScript("return jQuery.active;");
		Object numberOfAjaxConnections = js.executeScript("return jQuery.active");
		System.out.println(numberOfAjaxConnections.toString());

	}

	@After
	public void afterTest() {
		driver.quit();
	}

}
