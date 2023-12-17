package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class OrderInfoPage extends PageObject {
    private static final By ORDER_ID_LOCATOR = By.xpath("//div[@class='checkout-success']//span");

    public String getOrderId() {
        WebElement webElement = webDriver.findElement(ORDER_ID_LOCATOR);
        return webElement.getText();
    }
}
