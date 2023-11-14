package BaseFolder;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.android.AndroidDriver;

public class BaseDriver {
	
	
	AndroidDriver driver;
	
	@BeforeTest
	public void start() throws MalformedURLException {
		DesiredCapabilities cap = new DesiredCapabilities();
		File file = new File("./resources/General-Store.apk");
		cap.setCapability("platformName", "android");
		cap.setCapability("automationName", "UiAutomator2");
		cap.setCapability("deviceName", "Pixel");
		cap.setCapability("udid", "emulator-5554");
		cap.setCapability("app", file.getAbsolutePath());
		driver = new AndroidDriver(new URL("http://192.168.0.191:4723/"), cap);
		
		PageDriver.getInstance().setDriver(driver);
	}
	
	@AfterTest
	public void removeApp() {
		driver.removeApp("com.androidsample.generalstore");
	}

}
