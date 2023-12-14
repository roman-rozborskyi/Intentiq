package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import steps.*;
import utils.DriverManager;
import utils.propertiesmanager.ProjectProperties;

public class BaseTest {
    private static final DriverManager DRIVER_MANAGER = DriverManager.getInstance();
    protected HeaderSteps headerSteps;
    protected ProductsSectionSteps productsSectionSteps;
    protected ShippingSteps shippingSteps;
    protected ReviewAndPaymentsSteps reviewAndPaymentsSteps;
    protected OrderInfoSteps orderInfoSteps;

    @BeforeMethod
    public void beforeMethod() {
        WebDriver driver = DRIVER_MANAGER.getDriver();
        String url = ProjectProperties.getProperty("baseUrl");
        driver.get(url);
        initSteps();
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod() {
        DRIVER_MANAGER.stopDriver();
    }

    private void initSteps() {
        headerSteps = new HeaderSteps();
        productsSectionSteps = new ProductsSectionSteps();
        shippingSteps = new ShippingSteps();
        reviewAndPaymentsSteps = new ReviewAndPaymentsSteps();
        orderInfoSteps = new OrderInfoSteps();
    }
}
