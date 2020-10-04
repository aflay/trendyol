package testCases;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import frameworkOptions.BrowserOptions;
import trendyolPages.BoutiquesPage;
import trendyolPages.CommonPageActions;
import trendyolPages.HomePage;
import trendyolPages.MyOrdersPage;
import trendyolPages.ProductPage;
import trendyolPages.TabbarBoutiques;
import trendyolPages.Users;

public class CaseSet1 {

	
		

	@Test
	    public void case1(){
			//parametrik olarak chrome yada firefox browser'larýnda baþlatýlabilir.
			//HomePage homePage = new HomePage(HomePage.driver,"firefox");
	        HomePage homePage = new HomePage(HomePage.driver,"chrome");
	        
	        homePage.openURL("https://www.trendyol.com/");
	        homePage.verifyCurrentURL("https://www.trendyol.com/");
	        
	        homePage.clickElement(homePage.getPopupCloseButton());
	        homePage.staticWait(2);
	        homePage.clickElement(homePage.getAccountButton());
	        
	        homePage.seeElementInSeconds(20, homePage.getLoginTrendyolTitle());
	        homePage.fillElementWith(homePage.getLoginMailInputArea(), Users.otomasyonUsername1);
	        homePage.fillElementWith(homePage.getLoginPasswordInputArea(), Users.otomasyonPassword1);
	        homePage.clickElement(homePage.getLoginSubmitButton());
	        homePage.staticWait(3);
	        homePage.clickElement(homePage.getAccountButton());
	        
	        homePage.seeElementInSeconds(20,MyOrdersPage.getMyOrdersButton());
	        homePage.verifyCurrentURL("https://www.trendyol.com/hesabim/siparislerim");
	        homePage.cleanBasket();
	        
	        TabbarBoutiques.checkBoutiquePages(9);
	        TabbarBoutiques.clickRandomTabbar(9);
	        BoutiquesPage.clickRandomBoutiqueImage();
	        ProductPage.clickRandomProductAndCheckExpectedURL();
	        ProductPage.clickElement(ProductPage.getAddToBasket());
	        ProductPage.clickElement(homePage.getBasketIcon());
	        ProductPage.seeElementInSeconds(20,homePage.getTrashIcon());
	        
	 }
	
	@After
	public void quitDriver() {
		
		driver.quit();
	}
}
		