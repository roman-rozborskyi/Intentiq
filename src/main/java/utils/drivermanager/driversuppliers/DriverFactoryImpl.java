package utils.drivermanager.driversuppliers;

import enums.Browsers;
import org.openqa.selenium.WebDriver;
import utils.drivermanager.DriverFactory;
import utils.propertiesmanager.ProjectProperties;


public class DriverFactoryImpl implements DriverFactory {

    @Override
    public WebDriver getDriver() {
        Browsers browserName = getBrowserName();
        DriverSupplier driverSupplier = new ChromeSupplier();

        if (browserName == Browsers.EDGE) {
            driverSupplier = new EdgeSupplier();
        } else if (browserName == Browsers.FIREFOX){
            driverSupplier = new FirefoxSupplier();
        }

        return driverSupplier.getDriver();
    }

    private Browsers getBrowserName() {
        String browserNameProperty = ProjectProperties.getProperty("browser");

        if (!browserNameProperty.isEmpty()) {
            return Browsers.getBrowserName(browserNameProperty);
        } else {
            return Browsers.CHROME;
        }
    }
}
