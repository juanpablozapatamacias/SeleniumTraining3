package training.selenium.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import training.selenium.base.BasePage;
import training.selenium.utilities.CommonUtilities;

public class ReservePage extends BasePage{
	public ReservePage(WebDriver driver) {
		super(driver);
	}
	
	public PurchasePage clickChooseFlight() {
		System.out.println("Flight # " + getElement(By.cssSelector("div.container table.table:nth-child(2) tbody:nth-child(2) tr:nth-child(1) > td:nth-child(3)"),3).getText());
		System.out.println("Airline " + getElement(By.cssSelector("div.container table.table:nth-child(2) tbody:nth-child(2) tr:nth-child(1) > td:nth-child(4)") , 3));
		System.out.println("Departs " + getElement(By.cssSelector("div.container table.table:nth-child(2) tbody:nth-child(2) tr:nth-child(1) > td:nth-child(5)") , 3));
		System.out.println("Arrives " + getElement(By.cssSelector("div.container table.table:nth-child(2) tbody:nth-child(2) tr:nth-child(1) > td:nth-child(6)") , 3));
		System.out.println("Price " + getElement(By.cssSelector("div.container table.table:nth-child(2) tbody:nth-child(2) tr:nth-child(1) > td:nth-child(7)"), 3));
		
		ele = getElement(By.cssSelector
				("div.container "
						+ "table.table:nth-child(2) "
						+ "tbody:nth-child(2) "
						+ "tr:nth-child(1) "
						+ "td:nth-child(2) > input.btn.btn-small"),3);
		ele.click();
		CommonUtilities.sleepByNSeconds(1);
		
		return new PurchasePage(driver);
	}

	public String getReservationTitleText() {
		return getElement(By.xpath("//div//h3"),3).getText();
	}
}
