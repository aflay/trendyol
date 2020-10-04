package trendyolPages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends CommonPageActions {

	public HomePage(WebDriver driver, String driverType) {
		super(driver, driverType);
		// TODO Auto-generated constructor stub
	}

	private static By accountButton = By.id("accountBtn");
	private static By popupCloseButton = By.xpath("//*[contains(@class,'fancybox-close')]");
	public static By loginButton = By.className("account-button login");
	private static By loginTrendyolTitle = By.xpath("//*[contains(text(),'Giriþ Yapýn')]");
	private static By loginMailInputArea = By.xpath("//*[contains(@class,'input email')]");
	private static By loginPasswordInputArea = By.xpath("//*[contains(@class,'input password')]");
	private static By loginSubmitButton = By.id("loginSubmit");
	private static By trashIcon = By.xpath("//*[@class='i-trash']");

	public static By getPopupCloseButton() {
		return popupCloseButton;
	}


	public static By getAccountButton() {
		return accountButton;
	}


	public static By getLoginTrendyolTitle() {
		return loginTrendyolTitle;
	}


	public static By getLoginMailInputArea() {
		return loginMailInputArea;
	}


	public static By getLoginPasswordInputArea() {
		return loginPasswordInputArea;
	}

	public static By getLoginSubmitButton() {
		return loginSubmitButton;
	}
	
	public void cleanBasket() {
		
		List<WebElement> trashIconList= driver.findElements(trashIcon);
		trashIconList.size();
			
	}


}
