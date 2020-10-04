package trendyolPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyOrdersPage extends CommonPageActions {

	public MyOrdersPage(WebDriver driver, String driverType) {
		super(driver, driverType);
	}

	public static By myOrdersButton = By.xpath("//*[contains(@class,'account-menu-button')]//*[text()='Sipariþlerim']");

	
	
	public static By getMyOrdersButton() {
		return myOrdersButton;
	}
}
