package Tests;

import java.io.IOException;

import org.testng.annotations.Test;

import BaseFolder.driverSetup;
import Pages.productPage;

public class productPageTest extends driverSetup{
	
	@Test
	public void clickOnDropdownTest() throws IOException, InterruptedException {
		productPage ppt = new productPage();
		ppt.adddedAproductToCart();
		ppt.clickOnCartPage();
	}
}
