import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class LearnHtmlUnitD {

	@Test
	public void mytest() {

		//System.out.println(HttpClientBuilder.class.getProtectionDomain().getCodeSource().getLocation());
		WebDriver driver = new HtmlUnitDriver();
		driver.get("http://www.villaplus.com");
		System.out.println(driver.getTitle());
	}
}
