package BaseFolder;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import io.appium.java_client.android.AndroidDriver;

public class driverSetup {
	
	private static final ThreadLocal<AndroidDriver>  LOCAL_DRIVER = new ThreadLocal<>();
	
	public void setDriver(AndroidDriver driver) {
		driverSetup.LOCAL_DRIVER.set(driver);
	}
	
	@BeforeSuite
	public AndroidDriver getDriver() throws MalformedURLException {
	    AndroidDriver driver = new AndroidDriver(new URL("http://192.168.0.191:4723/"), setCap());
	    LOCAL_DRIVER.set(driver);
	    return LOCAL_DRIVER.get();
	}

	
	public  DesiredCapabilities setCap() throws MalformedURLException {
		DesiredCapabilities cap = new DesiredCapabilities();
		File file = new File("./resources/General-Store.apk");
		cap.setCapability("platformName", "android");
		cap.setCapability("automationName", "UiAutomator2");
		cap.setCapability("deviceName", "Pixel34");
		cap.setCapability("udid", "emulator-5554");
		cap.setCapability("app", file.getAbsolutePath());
//		driver = new AndroidDriver(new URL("http://192.168.0.191:4723/"), cap);
		return cap;
	}
	
	@AfterSuite
	public void removeApp() throws MalformedURLException {
		getDriver().removeApp("com.androidsample.generalstore");
	}

}
