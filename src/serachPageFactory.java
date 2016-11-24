import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.Select;

import com.google.common.base.Verify;

public class serachPageFactory {

	private WebDriver driver;
	AjaxElementLocatorFactory ac = new AjaxElementLocatorFactory(driver, 100);

	@FindBy(id = "ddDestinations")
	private WebElement destinationDropdown;

	@FindBy(id = "calIcon")
	private WebElement clickCalIcon;

	@FindBy(how = How.ID, using = ("btnSearch"))
	private WebElement clickSearchtBtn;
	
	@FindBy(how = How.XPATH,using =(""))
	private WebElement serach;
	
	public serachPageFactory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(ac, this);
	}
	
	
	
	public void selectDestination(int index) {
		Select select = new Select(destinationDropdown);
		select.selectByIndex(index);
	}
}
