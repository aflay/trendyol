package trendyolPages;

import java.util.List;

import org.junit.After;
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
	private static By basketIcon = By.xpath("//*[@id='myBasketListItem']");
	private static By removeButton = By.xpath("//button[contains(@class,'btn-remove')]");
	private static By emptyBasketText = By.xpath("//*[contains(text(),'Sepetinizde ürün bulunmamaktadýr.')]");

	public static By getPopupCloseButton() {
		return popupCloseButton;
	}

	public static By getBasketIcon() {
		return basketIcon;
	}

	public static By getTrashIcon() {
		return trashIcon;
	}

	public static By getRemoveButton() {
		return removeButton;
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

	// senaryo öncesi sepet temizlenir.
	public void cleanBasket() {

		clickElement(basketIcon);
		staticWait(2);
		verifyCurrentURL("https://www.trendyol.com/sepetim#/basket");
		List<WebElement> trashIconList = driver.findElements(trashIcon);
		if (trashIconList.size() >= 1) {
			for (int i = 1; i < trashIconList.size() + 1; i++) {
				staticWait(1);
				clickElement(By.xpath("(//*[@class='i-trash'])[" + i + "]"));
				staticWait(1);
				clickElement(removeButton);
				seeElementInSeconds(20, emptyBasketText);
			}

		}

	}
	
	
}
