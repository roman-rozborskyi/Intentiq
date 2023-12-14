package utils.drivermanager.driversuppliers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeSupplier extends DriverSupplier {

    public WebDriver getDriver() {
//        WebDriverManager.chromedriver().setup(); TODO
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver webDriver = new ChromeDriver(options);
        adjustDriver(webDriver);
        logDriverInfo(webDriver, options);

        return webDriver;
    }
}
