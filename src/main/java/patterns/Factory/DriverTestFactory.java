package patterns.Factory;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import lombok.SneakyThrows;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

import static com.codeborne.selenide.Selenide.open;

public class DriverTestFactory {

    @SneakyThrows
    public static WebDriver getTestDriver(String platform) {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        switch (platform.toLowerCase()) {
            case "android":
                capabilities.setCapability(CapabilityType.PLATFORM_NAME, "android");
                AndroidDriver androidDriver = new AndroidDriver(new URL("http://127.0.0.1:4808/wd/hub"), capabilities);
                WebDriverRunner.setWebDriver(androidDriver);
                return androidDriver;
            case "ios":
                capabilities.setCapability(CapabilityType.PLATFORM_NAME, "ios");
                IOSDriver iosDriver = new IOSDriver(new URL("http://127.0.0.1:4808/wd/hub"), capabilities);
                WebDriverRunner.setWebDriver(iosDriver);
                return iosDriver;
            case "windows":
                Configuration.browserSize = "1920x1080";
                Configuration.screenshots = true;
                open("https://www.google.pl/");
                return WebDriverRunner.getWebDriver();
            default:
                throw new IllegalArgumentException("Unknown platform: " + platform);
        }
    }
}
