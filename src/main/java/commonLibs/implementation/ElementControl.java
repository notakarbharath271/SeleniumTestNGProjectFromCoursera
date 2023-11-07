package commonLibs.implementation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementControl {
	
	WebDriver driver;
	public ElementControl(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickElement(WebElement ele) {
		ele.click();	
	}
	public void clearText(WebElement ele) {
		ele.clear();	
	}
	public void setText(WebElement ele ,String text) {
		ele.sendKeys(text);
	}
	public boolean isEnable(WebElement ele) {
		return ele.isEnabled();
	}
	public boolean isDisplayed(WebElement ele) {
		return ele.isDisplayed();
	}
	public String getTitle() {
		return driver.getTitle();
	}


}
