package training.selenium.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import training.selenium.base.BasePage;

public class ConfirmationPage extends BasePage{
	
	public ConfirmationPage(WebDriver driver) {
		super(driver);
	}
	
	public String getConfirmationTitleText() {
		return getElement(By.cssSelector("body:nth-child(2) "
				+ "div.container:nth-child(2) "
				+ "div.container.hero-unit > h1:nth-child(1)"),3).getText();
	}
}
