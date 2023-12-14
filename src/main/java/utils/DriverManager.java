package utils;

import org.openqa.selenium.WebDriver;

public class DriverManager {
    private static DriverManager instance;
    private static final ThreadLocal<WebDriver> DRIVER_THREAD_LOCAL = new ThreadLocal<>();

    private DriverManager() {

    }

    public static synchronized DriverManager getInstance() {
        if (instance == null) {
            instance = new DriverManager();
        }
        return instance;
    }

    public void launchDriver(WebDriver driver) {
        DRIVER_THREAD_LOCAL.set(driver);
    }

    public void stopDriver() {
        WebDriver webDriver = getDriver();
        webDriver.quit();
    }

    public WebDriver getDriver() {
        return DRIVER_THREAD_LOCAL.get();
    }
}
