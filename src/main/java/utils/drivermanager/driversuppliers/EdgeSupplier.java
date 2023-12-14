package utils.drivermanager.driversuppliers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class EdgeSupplier extends DriverSupplier {
    public WebDriver getDriver() {
        //WebDriverManager.edgedriver().setup(); TODO
        WebDriver webDriver  = new EdgeDriver();
        adjustDriver(webDriver);

        return webDriver;
    }
}
