package pageobjects;

import org.openqa.selenium.WebDriver;
import utils.drivermanager.DriverManager;

public abstract class PageObject {
    protected WebDriver webDriver;

    {
        DriverManager driverManager = DriverManager.getInstance();
        webDriver  = driverManager.getDriver();
    }
}
