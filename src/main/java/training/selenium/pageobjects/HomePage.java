package training.selenium.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import training.selenium.base.BasePage;
import training.selenium.utilities.CommonUtilities;

public class HomePage extends BasePage{
	
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	public void selectDepartureCity(String value) {
		System.out.println(getElement(By.xpath
				("//h2[contains(text(),'Choose your departure city:')]"),3).getText() + " " + value );
		Select selectOptionDep = getSelectElement(By.xpath("//select[@name='fromPort']"), 3);
		selectOptionDep.selectByValue(value);
		CommonUtilities.sleepByNSeconds(1);
	}
	
	public void selectDestinationCity(String value) {
		System.out.println(getElement(By.xpath
				("//h2[contains(text(),'Choose your destination city:')]"),3).getText() + " " + value);
		Select selectOptionDest = getSelectElement(By.xpath("//select[@name='toPort']"), 3);
		selectOptionDest.selectByValue(value);
		CommonUtilities.sleepByNSeconds(1);
	}
	
	public ReservePage getReservePage() {
		System.out.println("Move to Reserve Page home");
		ele = super.getElement(By.xpath("//input[@class='btn btn-primary']"), 3);
		ele.click();
		CommonUtilities.sleepByNSeconds(1);
		
		return new ReservePage(driver);
	}
	
	

}
