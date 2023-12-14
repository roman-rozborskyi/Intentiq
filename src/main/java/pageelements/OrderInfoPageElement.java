package pageelements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class OrderInfoPageElement extends PageElement {
    private String orderIdXpath = "";

    public String getOrderId() {
        WebElement webElement = webDriver.findElement(By.xpath(orderIdXpath));
        return webElement.getText();
    }
}
