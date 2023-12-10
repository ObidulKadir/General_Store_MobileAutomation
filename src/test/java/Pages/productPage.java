package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;

import static BaseFolder.driverSetup.getDriver;

import java.net.MalformedURLException;
public class productPage {
	
	public productPage() throws MalformedURLException {
		PageFactory.initElements(getDriver(), this);
	}
	
	@FindBy(xpath="(//android.widget.TextView[@resource-id=\"com.androidsample.generalstore:id/productAddCart\"])[2]")
	WebElement productAddToCart;
	
	@FindBy(xpath="//android.widget.ImageButton[@resource-id=\"com.androidsample.generalstore:id/appbar_btn_cart\"]")
	WebElement cartBtn;
	
	//product add to cart.
	public void adddedAproductToCart() {
		try {
			Thread.sleep(3000);
			productAddToCart.click();
			System.out.println("The selected product successfully added to a cart.");
		} catch (Exception e) {
			System.out.println("The element of productAddToCart is unable to locate");
		}
	}
	
	//click on the cart icon to go cart page.
	public void clickOnCartPage() {
		try {
			cartBtn.click();
			Thread.sleep(2000);
			System.out.println("Succesfully clicked on the cart button.");
		} catch (Exception e) {
			System.out.println("The element of cartBtn is unable to locate");
		}
	}

}
