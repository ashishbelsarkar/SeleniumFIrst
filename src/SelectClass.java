import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SelectClass {

	public void selectDropdown(String elementName, int selectIndex, WebDriver md) {

		WebElement dropdownSelect = md.findElement(By.id(elementName));
		Select select = new Select(dropdownSelect);
		select.selectByIndex(selectIndex);
		select.isMultiple();

	}

}
