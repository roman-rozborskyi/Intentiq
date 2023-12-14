package utils;

import org.openqa.selenium.WebDriver;
import utils.drivermanager.DriverFactory;
import utils.drivermanager.DriverFactoryImpl;

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

    public WebDriver getDriver() {
        if(isDriverIsntExist()) {
            DriverFactory driverFactory = new DriverFactoryImpl();
            WebDriver driver = driverFactory.getDriver();
            DRIVER_THREAD_LOCAL.set(driver);
        }

        return DRIVER_THREAD_LOCAL.get();
    }

    private static boolean isDriverIsntExist() {
        return DRIVER_THREAD_LOCAL.get() == null;
    }

    public void stopDriver() {
        WebDriver webDriver = DRIVER_THREAD_LOCAL.get();
        webDriver.quit();
    }
}
