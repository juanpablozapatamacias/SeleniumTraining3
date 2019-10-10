package training.selenium.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import training.selenium.base.BasePage;
import training.selenium.utilities.CommonUtilities;

public class PurchasePage extends BasePage{
	
	public PurchasePage(WebDriver driver) {
		super(driver);
	}
	
	public String getPurchaseTitleText() {
		return getElement(By.cssSelector("body:nth-child(2) "
				+ "div.container:nth-child(2) > h2:nth-child(1)"),3).getText();
	}
	
	public void fillPurchaseName(String value) {
		System.out.println("Fill Purchase Name: " + value);
		ele = getElement(By.cssSelector("#inputName"),3);
		ele.sendKeys(value);
		CommonUtilities.sleepByNSeconds(1);
	}
	
	public void fillPurchaseAddress(String value) {
		System.out.println("Fill Purchase Address: " + value);
		ele = getElement(By.cssSelector("#address"),3);
		ele.sendKeys(value);
		CommonUtilities.sleepByNSeconds(1);
	}
	
	public void fillPurchaseCity(String value) {
		System.out.println("Fill Purchase City " + value);
		ele = getElement(By.cssSelector("#city"),3);
		ele.sendKeys(value);
		CommonUtilities.sleepByNSeconds(1);
	}
	
	public void fillPurchaseState(String value) {
		System.out.println("Fill Purchase State " + value);
		ele = getElement(By.cssSelector("#state"),3);
		ele.sendKeys(value);
		CommonUtilities.sleepByNSeconds(1);
	}
	
	public void fillPurchaseZIP(String value) {
		System.out.println("Fill Purchase ZIP code " + value);
		ele = getElement(By.cssSelector("#zipCode"),3);
		ele.sendKeys(value);
		CommonUtilities.sleepByNSeconds(1);
	}
	
	public void selectCardType(String value) {
		System.out.println("Select Card Type " + value);
		Select sel = super.getSelectElement(By.cssSelector("#cardType"),3);
		sel.selectByVisibleText(value);
		CommonUtilities.sleepByNSeconds(1);
	}
	
	public void fillCreditCardNumber(String value) {
		System.out.println("Fill Credit Card Number " + value);
		ele = getElement(By.cssSelector("#creditCardNumber"),3);
		ele.sendKeys(value);
		CommonUtilities.sleepByNSeconds(1);
	}

	public void fillCreditCardMonth(String value) {
		System.out.println("Fill Credit Card Month " + value);
		ele = getElement(By.cssSelector("#creditCardMonth"),3);
		ele.sendKeys(value);
		CommonUtilities.sleepByNSeconds(1);
	}
	
	public void fillCreditCardYear(String value) {
		System.out.println("Fill Credit Card Year " + value);
		ele = getElement(By.cssSelector("#creditCardYear"),3);
		ele.clear();
		ele.sendKeys(value);
		CommonUtilities.sleepByNSeconds(1);
	}
	
	public void fillNameOnCard(String value) {
		System.out.println("Fill Credit Card Name " + value);
		ele = getElement(By.cssSelector("#nameOnCard"),3);
		ele.sendKeys(value);
		CommonUtilities.sleepByNSeconds(1);
	}
	
	public void checkRememberMe() {
		System.out.println("Check on Remember Me");
		ele = getElement(By.cssSelector("#rememberMe"),3);
		ele.click();
		CommonUtilities.sleepByNSeconds(1);
	}
	
	public ConfirmationPage clickPurchaseFlightButton() {
		System.out.println("Click on Purchase Flight Button");
		ele = getElement(By.cssSelector("div.container:nth-child(2) "
				+ "form:nth-child(9) "
				+ "div.control-group:nth-child(12) "
				+ "div.controls > input.btn.btn-primary"),3);
		ele.click();
		CommonUtilities.sleepByNSeconds(1);
		return new ConfirmationPage(driver);
	}
	
	
}
