package trendyolPages;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TabbarBoutiques extends CommonPageActions {

	public TabbarBoutiques(WebDriver driver, String driverType) {
		super(driver, driverType);
	}

	static By boutiqueImages = By.xpath("//a[contains(@href,'butik')]//img[@src]");
	By categoryTabbars = By.xpath("//*[@id='browsing-gw-navigation']//*[contains(@class,'tab-link')]");

	public static void clickRandomTabbar(int tabbarCount) {

		Random r = new Random();
		int randomNum = r.nextInt(tabbarCount) + 1;
		clickElement(
				By.xpath("(//*[@id='browsing-gw-navigation']//*[contains(@class,'tab-link')])[" + randomNum + "]"));
		System.out.println("Randomly clicked " + randomNum + ". tabbar");

		switch (randomNum) {
		case 1:
			verifyCurrentURL("https://www.trendyol.com/butik/liste/kadin");
			break;
		case 2:
			verifyCurrentURL("https://www.trendyol.com/butik/liste/erkek");
			break;
		case 3:
			verifyCurrentURL("https://www.trendyol.com/butik/liste/cocuk");
			break;
		case 4:
			verifyCurrentURL("https://www.trendyol.com/butik/liste/ev--yasam");
			break;
		case 5:
			verifyCurrentURL("https://www.trendyol.com/butik/liste/supermarket");
			break;
		case 6:
			verifyCurrentURL("https://www.trendyol.com/butik/liste/kozmetik");
			break;
		case 7:
			verifyCurrentURL("https://www.trendyol.com/butik/liste/ayakkabi--canta");
			break;
		case 8:
			verifyCurrentURL("https://www.trendyol.com/butik/liste/saat--aksesuar");
			break;
		case 9:
			verifyCurrentURL("https://www.trendyol.com/butik/liste/elektronik");
			break;
		default:
			System.out.println("input is given bigger than the tabbar length");
			break;
		}

	}

	public static void checkBoutiquePages(int tabbarCount) {

		for (int i = 1; i < tabbarCount + 1; i++) {
			By tabbarToClick = By
					.xpath("(//*[@id='browsing-gw-navigation']//*[contains(@class,'tab-link')])[" + i + "]");
			staticWait(1);
			clickElement(tabbarToClick);
			switch (i) {
			case 1:
				verifyCurrentURL("https://www.trendyol.com/butik/liste/kadin");
				break;
			case 2:
				verifyCurrentURL("https://www.trendyol.com/butik/liste/erkek");
				break;
			case 3:
				verifyCurrentURL("https://www.trendyol.com/butik/liste/cocuk");
				break;
			case 4:
				verifyCurrentURL("https://www.trendyol.com/butik/liste/ev--yasam");
				break;
			case 5:
				verifyCurrentURL("https://www.trendyol.com/butik/liste/supermarket");
				break;
			case 6:
				verifyCurrentURL("https://www.trendyol.com/butik/liste/kozmetik");
				break;
			case 7:
				verifyCurrentURL("https://www.trendyol.com/butik/liste/ayakkabi--canta");
				break;
			case 8:
				verifyCurrentURL("https://www.trendyol.com/butik/liste/saat--aksesuar");
				break;
			case 9:
				verifyCurrentURL("https://www.trendyol.com/butik/liste/elektronik");
				break;
			default:
				System.out.println("input is given bigger than the tabbar length");
				break;
			}

			List<WebElement> boutiqueImagesList = driver.findElements(boutiqueImages);
			verifyAllImagesLoaded(boutiqueImagesList);
			System.out.println("All images are loaded at " + i + ". tabbar");
		}
	}
}
