package utils.drivermanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;

import java.util.function.Consumer;

public class DevToolsServiceChrome implements DevToolsService{
    private DevTools devTools;

    {
        DriverManager driverManager = DriverManager.getInstance();
        WebDriver webDriver  = driverManager.getDriver();
        ChromeDriver driver = (ChromeDriver) webDriver;
        DevTools devTools = driver.getDevTools();
        devTools.createSession();
    }

    public void getRequest(Consumer consumer) {
//        devTools.addListener();
    }
}
