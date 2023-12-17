package pageelements.header;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pageelements.PageElement;
import utils.Waiter;

public class MiniCartPageElement extends PageElement {
    private static final By MINI_CART_LOCATOR = By.xpath("//div[contains(@class, 'minicart') and @data-role='dropdownDialog']");
    private static final By PROCEED_TO_CHECKOUT_BUTTON_LOCATOR = By.xpath(".//button[text()='Proceed to Checkout']");

    public void clickOnProceedToCheckoutButton() {
        new Waiter()
                .waitVisibility(MINI_CART_LOCATOR)
                .wait(250);
        WebElement button =
                webDriver
                        .findElement(MINI_CART_LOCATOR)
                        .findElement(PROCEED_TO_CHECKOUT_BUTTON_LOCATOR);
        button.click();
    }
}
