package trendyolPages;

import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductPage extends CommonPageActions {

	public ProductPage(WebDriver driver, String driverType) {
		super(driver, driverType);
	}

	static By productImages = By.xpath("//img[contains(@class,'short-product-image')]");
	public static By addToBasket = By.xpath("//button[contains(@class,'add-to-bs')]");
	static By expectedURLAfterClicked = By
			.xpath("//img[contains(@class,'short-product-image')]/parent::div/parent::a[@href]");

	public static void clickRandomProductAndCheckExpectedURL() {

		Random r = new Random();
		// sayfa üstündeki ürünlerin sayýsý alýnýr
		List<WebElement> productList = driver
				.findElements(By.xpath("//img[contains(@class,'img')]//ancestor::a[@href]"));

		int randomNum = r.nextInt(productList.size()) + 1;

		By randomElement = By.xpath("(//img[contains(@class,'img')]" + "//ancestor::a[@href])[" + randomNum + "]");

		String expectedURL = driver
				.findElement(By.xpath("(//img[contains(@class,'img')]" + "//ancestor::a[@href])[" + randomNum + "]"))
				.getAttribute("href");

		System.out.println("Expected URL after a product clicked: " + expectedURL);

		clickElement(randomElement);
		staticWait(2);

		verifyCurrentURL(expectedURL);
	}
}
