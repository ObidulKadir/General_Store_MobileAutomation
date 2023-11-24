package Pages;

import java.io.IOException;
import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import BaseFolder.driverSetup;
import io.appium.java_client.android.AndroidDriver;

public class mainActivityPage{
	
//		driverSetup driver = new driverSetup();
		AndroidDriver driver;
		public mainActivityPage(AndroidDriver driver) {
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}
		
		@FindBy(xpath="//android.widget.Spinner[@resource-id=\"com.androidsample.generalstore:id/spinnerCountry\"]")
		WebElement clickOnDropdown;
		
		@FindBy(xpath="//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Albania\"]")
		WebElement selectCountry;
		
		@FindBy(xpath="//android.widget.EditText[@resource-id='com.androidsample.generalstore:id/nameField']")
		WebElement name;
		
		@FindBy(xpath="//android.widget.Button[@resource-id=\"com.androidsample.generalstore:id/btnLetsShop\"]")
		WebElement clickOnbtn;
		
		public void clickOnDropdown() throws IOException, InterruptedException {
			Thread.sleep(10000);
			try {
				clickOnDropdown.click();
				Thread.sleep(2000);
				try {
					selectCountry.click();
					Thread.sleep(2000);
				} catch (Exception e) {
					System.out.println("The locate of selectCountry is fail.");
				}
			} catch (Exception e) {
				System.out.println("The locate of clickOnDropdown is fail.");
			}
		}
		public void enterName() {
			
			try {
				name.sendKeys("kadir");
			} catch (Exception e) {
				System.out.println("The locate of name is fail.");
			}
		}
		public void clickOnButton() throws IOException, InterruptedException {
			Thread.sleep(10000);
			try {
				clickOnbtn.click();
			} catch (Exception e) {
				System.out.println("The locate of element is fail.");
			}
		}
}
