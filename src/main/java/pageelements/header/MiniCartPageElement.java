package pageelements.header;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pageelements.PageElement;

public class MiniCartPageElement extends PageElement {
    private By cartInfoContainerLocator = By.xpath("//div[contains, 'minicart']");
    private By proceedToCheckoutButtonLocator = By.xpath(".//button[text()='Proceed to Checkout']");
    private WebElement miniCartContainer;

    {
        miniCartContainer = webDriver.findElement(cartInfoContainerLocator);
    }

    public MiniCartPageElement clickOnProceedToCheckoutButton() {
        WebElement button = miniCartContainer.findElement(proceedToCheckoutButtonLocator);
        button.click();
        return this;
    }
}
