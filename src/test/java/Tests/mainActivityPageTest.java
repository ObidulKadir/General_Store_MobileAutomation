package Tests;

import java.io.IOException;

import org.testng.annotations.Test;

import BaseFolder.driverSetup;
import Pages.mainActivityPage;
 class mainActivityPageTest extends driverSetup{
	
	 
	@Test(priority = 0)
	public void clickOnDropdownTest() throws IOException, InterruptedException {
		mainActivityPage map = new mainActivityPage();
		map.clickOnDropdown();
		map.enterName();
		map.clickOnButton();
	}
}
