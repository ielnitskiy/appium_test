import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

import static java.lang.Thread.sleep;

public class TestApp {

    public AndroidDriver driver;


    @BeforeClass
    public void getAndroidDriversCollection() throws MalformedURLException {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("platformName", "Android");
        cap.setCapability("deviceName", "emulator-5554");
        cap.setCapability("platformVersion", "10");
        cap.setCapability("appPackage", "io.selendroid.testapp");
        cap.setCapability("appActivity", "io.selendroid.testapp.HomeScreenActivity");
        cap.setCapability("autoLaunch", "false");
        cap.setCapability("automationName", "UiAutomator2");
//        cap.setCapability("waitForSelectorTimeout", "400");
        cap.setCapability("noReset", "true");
        driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), cap);
    }


    @Test
    public void testApp() throws Exception {

        driver.launchApp();
        MobileElement el1 = (MobileElement) driver.findElementByAccessibilityId("startUserRegistrationCD");
        el1.click();
        sleep(1000);
        MobileElement el2 = (MobileElement) driver.findElementById("io.selendroid.testapp:id/inputUsername");
        el2.sendKeys("hello world");
        MobileElement el3 = (MobileElement) driver.findElementById("io.selendroid.testapp:id/inputPassword");
        el3.sendKeys("hello world");
        MobileElement el4 = (MobileElement) driver.findElementById("io.selendroid.testapp:id/inputName");
        el4.clear();
        el2.click();
        sleep(10000);
    }


//"//*[@text='Mr. Burns']"
}
