package utils.drivermanager.driversuppliers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class DriverSupplier {
    private static final Logger LOGGER = LoggerFactory.getLogger(DriverSupplier.class);

    protected void adjustDriver(WebDriver webDriver) {
        webDriver.manage().window().maximize();
    }

    protected void logDriverInfo(WebDriver webDriver, ChromeOptions options) {
        LOGGER.info(webDriver.manage().window().getSize().toString());
        LOGGER.info(options.getCapability("goog:chromeOptions").toString());
    }

    public abstract WebDriver getDriver();
}
