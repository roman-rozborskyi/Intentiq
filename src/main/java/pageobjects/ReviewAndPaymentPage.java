package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pageelements.LoadingMaskElement;
import utils.Waiter;

public class ReviewAndPaymentPage extends PageObject {
    private static final By PLACE_ORDER_BUTTON_LOCATOR = By.xpath("//button[.//span[text()='Place Order']]");

    public ReviewAndPaymentPage clickOnPlaceOrderButton() {
        WebElement button = webDriver.findElement(PLACE_ORDER_BUTTON_LOCATOR);
        button.click();
        return null;
    }

    public ReviewAndPaymentPage waitPageReady() {
        Waiter waiter = new Waiter();
        waiter.waitVisibility(PLACE_ORDER_BUTTON_LOCATOR);
        new LoadingMaskElement().waitLoading();
        waiter.wait(500);
        return this;
    }
}
