import java.util.concurrent.TimeUnit;

//import com.google.common.base.Function;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Mouse;
import org.openqa.selenium.interactions.MoveMouseAction;
import org.openqa.selenium.interactions.internal.MouseAction;
import org.openqa.selenium.remote.server.handler.interactions.MouseMoveToLocation;
import org.openqa.selenium.support.ui.*;

import com.google.common.base.Function;

public class FluentWaitDemo {

	WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new FirefoxDriver();
		driver.get("http://toolsqa.com/automation-practice-switch-windows/");

		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
		wait.pollingEvery(250, TimeUnit.MILLISECONDS);
		wait.withTimeout(2, TimeUnit.MINUTES);


		
		
		
		Function<WebDriver, Boolean> function = new Function<WebDriver, Boolean>() {
			public Boolean apply(WebDriver arg0) {
				WebElement element = arg0.findElement(By.id("colorVar"));
				String color = element.getAttribute("color");
				System.out.println("The color of the button is " + color);
				if (color.equals("red")) {
					return true;
				}
				return false;
			}
		};

		wait.until(function);
	}

}
