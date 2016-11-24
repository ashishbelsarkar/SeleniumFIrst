import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.server.handler.FindElement;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public abstract class FirstTest {

	public static WebDriver md;

	public abstract void ad();

	String sgr[] = { "2", "2" };

	@Test
	public void performSearch() throws Exception {

		String s1 = new String("Hello");
		String s2 = new String("there");
		String s3 = new String();

		System.setProperty("webdriver.chrome.driver", "//Users/ashishbelsarkar/Downloads/chromedriver");
		WebDriver md = new ChromeDriver();
		SelectClass sc = new SelectClass();
		// md = new SafariDriver();
		// md = new FirefoxDriver();
		md.manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);
		md.manage().window().maximize();
		md.get("http://www.villaplus.com");
		md.navigate().to(s3);

		DesiredCapabilities dc = new DesiredCapabilities();

		//
		// Thread.sleep(5000);

		Actions act = new Actions(md);

		WebElement ele1 = md.findElement(By.id("ddDestinations"));
		WebDriverWait wait = new WebDriverWait(md, 10);
		wait.until(ExpectedConditions.visibilityOf(ele1));
		String text = ele1.getText();
		System.out.println(text);

		String destinationid = "ddDestinations";

		sc.selectDropdown(destinationid, 3, md);

		WebElement calClick = md.findElement(By.id("calIcon"));
		wait.until(ExpectedConditions.visibilityOf(calClick));
		calClick.click();
		Thread.sleep(5000);

		WebElement calDropdown = md.findElement(By.className("ui-datepicker-month"));

		Select select = new Select(calDropdown);
		List<WebElement> monthOptlist = select.getOptions();
		for (WebElement listiterator : monthOptlist) {
			System.out.println(listiterator.getText());
			if (listiterator.getText().equals("August 2016")) {
				listiterator.click();
				break;
			}
		}

		List<WebElement> dateList = md.findElements(By.xpath("//div[@id='ui-datepicker-div']/table/tbody/tr/td/a"));
		for (WebElement dateElement : dateList) {
			System.out.println(dateElement.getText());
			if (dateElement.getText().equals("31")) {
				dateElement.click();
				break;
			}
		}

		String durationId = "ddDuration";
		String adultPax = "ddAdults";
		String childPax = "ddChildren";
		String infantPax = "ddInfants";
		String airportId = "ddAirports";

		sc.selectDropdown(durationId, 1, md);
		sc.selectDropdown(adultPax, 1, md);
		sc.selectDropdown(childPax, 1, md);
		sc.selectDropdown(infantPax, 1, md);
		sc.selectDropdown(airportId, 3, md);

		md.findElement(By.id("btnSearch")).click();
		Thread.sleep(5000);

		WebElement alert = md.findElement(By.xpath("//div[@class='AlertInner']/div[@class='aButtons']/span/button"));
		wait.until(ExpectedConditions.visibilityOf(alert));
		alert.click();

		// WebDriverWait wait = new WebDriverWait(driver, 2);
		// wait.until(ExpectedConditions.alertIsPresent());
		// Alert alert = md.switchTo().alert();
		// alert.accept();
		Thread.sleep(5000);
		md.quit();

	}
}
