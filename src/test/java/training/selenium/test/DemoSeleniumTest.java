package training.selenium.test;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import training.selenium.base.BasePage;
import training.selenium.pageobjects.PurchasePage;
import training.selenium.pageobjects.ConfirmationPage;
import training.selenium.pageobjects.HomePage;
import training.selenium.pageobjects.ReservePage;

public class DemoSeleniumTest extends BasePage {
	HomePage homePage;
	ReservePage reservePage;
	PurchasePage purchasePage;
	ConfirmationPage confirmationPage;
	
	@BeforeClass
	public void setup() {
		driver = getDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
		driver.navigate().to("http://blazedemo.com/");
	}
	
	@Test
	public void destinationTest() {
		System.out.println("Demo test 1");
		homePage = new HomePage(driver);
		homePage.selectDepartureCity("Boston");
		homePage.selectDestinationCity("New York");
		
		reservePage = homePage.getReservePage();
		Assert.assertTrue(reservePage.getReservationTitleText().contains("Boston"));
		Assert.assertTrue(reservePage.getReservationTitleText().contains("New York"));
	}
	
	@Test(dependsOnMethods = "destinationTest")
	public void reservationTest() {
		purchasePage = reservePage.clickChooseFlight();
		Assert.assertTrue(purchasePage.getPurchaseTitleText().contains("Boston"));
		Assert.assertTrue(purchasePage.getPurchaseTitleText().contains("New York"));
	}
	
	@Test(dependsOnMethods = "reservationTest")
	public void purchaseTest() {
		purchasePage.fillPurchaseName("Pablo");
		purchasePage.fillPurchaseAddress("Conocida");
		purchasePage.fillPurchaseCity("Ags");
		purchasePage.fillPurchaseState("Ags");
		purchasePage.fillPurchaseZIP("0");
		
		purchasePage.selectCardType("Visa");
		purchasePage.fillCreditCardNumber("1111111");
		purchasePage.fillCreditCardMonth("11");
		purchasePage.fillCreditCardYear("2024");
		purchasePage.fillNameOnCard("Pablo");
		
		purchasePage.checkRememberMe();
		
		
		confirmationPage = purchasePage.clickPurchaseFlightButton();
		Assert.assertTrue(confirmationPage.getConfirmationTitleText().contains("Thank"));
	}
	
	
	@AfterClass
	public void teardown() {
		
		try {
			System.out.println("Test executed");
		}
		catch(Exception e) {
			
		}
		finally {
			driver.quit();
			driver = null;
		}
	}

}
