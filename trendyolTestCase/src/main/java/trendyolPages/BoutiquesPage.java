package trendyolPages;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BoutiquesPage extends CommonPageActions {

	public BoutiquesPage(WebDriver driver, String driverType) {
		super(driver, driverType);
	}

	public static void clickRandomBoutiqueImage() {

		List<WebElement> boutiqueImagesList = driver.findElements(TabbarBoutiques.boutiqueImages);

		Random r = new Random();

		int randomNum = r.nextInt(boutiqueImagesList.size()) + 1;

		clickElement(By.xpath("(//a[contains(@href,'butik')]//img[@src])[" + randomNum + "]"));

	}

}
