package utils.drivermanager.driversuppliers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxSupplier extends DriverSupplier {
    public WebDriver getDriver() {
//        WebDriverManager.firefoxdriver().setup(); TODO
        WebDriver webDriver  = new FirefoxDriver();
        adjustDriver(webDriver);

        return webDriver;
    }
}
