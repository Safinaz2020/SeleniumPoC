package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {
    // ThreadLocal isolates the driver instances completely
    private static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        if (tlDriver.get() == null) {
            tlDriver.set(new ChromeDriver());
        }
        return tlDriver.get();
    }

    public static void removeDriver() {
        if (tlDriver.get() != null) {
            tlDriver.get().quit(); // Quits the browser session
            tlDriver.remove();    // Clears the thread storage reference completely
        }
    }
}
