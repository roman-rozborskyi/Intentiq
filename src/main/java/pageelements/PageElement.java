package pageelements;

import org.openqa.selenium.WebDriver;
import utils.DriverManager;

public abstract class PageElement {
    protected WebDriver webDriver;

    {
        DriverManager driverManager = DriverManager.getInstance();
        webDriver  = driverManager.getDriver();
    }
}
