package trendyolPages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import frameworkOptions.BrowserOptions;

public class CommonPageActions extends BrowserOptions {

	public CommonPageActions(WebDriver driver, String driverType) {
		driver = getDriver(driverType);
	}

	public static void staticWait(int seconds) {

		try {
			Thread.sleep(seconds * 1000);
		}

		catch (Exception e) {

			System.out.println(e.getMessage());

		}
	}
	
	

	public static void clickElement(By elementKey) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		try {
			wait.until(ExpectedConditions.elementToBeClickable(elementKey)).click();
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

	public static void seeElementInSeconds(int seconds, By elementKey) {

		try {
			WebDriverWait dynamicWait = new WebDriverWait(driver, seconds);

			dynamicWait.until(ExpectedConditions.presenceOfElementLocated(elementKey));
		} catch (Exception e) {

			Assert.fail(e.getMessage());
		}
	}

	public static void verifyCurrentURL(String expectedURL) {

		String currentURL = driver.getCurrentUrl();
		System.out.println("Current URL: " + currentURL);
		Assert.assertTrue(currentURL.equalsIgnoreCase(expectedURL));
		

	}

	public static void fillElementWith(By elementKey, String text) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(elementKey)).sendKeys(text);
	}

	public static void openURL(String URL) {

		driver.get(URL);

	}

	public static boolean verifyImageLoaded(WebElement element) {

		boolean isLoaded = false;

		Object loadStatus = ((JavascriptExecutor) driver)
				.executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != "
						+ "\"undefined\"&& arguments[0].naturalWidth > 0", element);

		isLoaded = (Boolean) loadStatus;

		return isLoaded;
	}

	public static void verifyAllImagesLoaded(List<WebElement> boutiqueImagesList) {

		boolean isLoaded = false;

		int imageCount = 0;
		for (WebElement currentImage : boutiqueImagesList) {
			imageCount++;
			Object loadStatus = ((JavascriptExecutor) driver)
					.executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != "
							+ "\"undefined\"&& arguments[0].naturalWidth > 0", currentImage);

			isLoaded = (Boolean) loadStatus;

			if (isLoaded == false) {
				// Sadece log basýlmasý istendiði için buraya Assert.fail eklenmedi.
				System.out.println(imageCount + ". Image not loaded");
			}
		}
	}
	
	

}
