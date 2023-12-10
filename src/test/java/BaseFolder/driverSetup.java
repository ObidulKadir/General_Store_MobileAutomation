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
	
	public static void setDriver(AndroidDriver driver) {
		driverSetup.LOCAL_DRIVER.set(driver);
	}
	
	
	public static AndroidDriver getDriver() throws MalformedURLException {
	    return LOCAL_DRIVER.get();
	}

	
	public static AndroidDriver setCap() throws MalformedURLException{
		DesiredCapabilities cap = new DesiredCapabilities();
		File file = new File("./resources/General-Store.apk");
		cap.setCapability("platformName", "android");
		cap.setCapability("automationName", "UiAutomator2");
		cap.setCapability("deviceName", "HP");
		cap.setCapability("udid", "emulator-5556");
		cap.setCapability("app", file.getAbsolutePath());
		return new AndroidDriver(new URL("http://192.168.0.191:4723/"), cap);
	}
	
	@BeforeSuite
	public static synchronized void setAndroiDriver() throws MalformedURLException {
		AndroidDriver driver = setCap();
	    LOCAL_DRIVER.set(driver);
	}
	
	@AfterSuite
	public void removeApp() throws MalformedURLException {
		getDriver().removeApp("com.androidsample.generalstore");
	}

}
