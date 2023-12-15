package pageelements.header;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageelements.PageElement;

public class MiniCartPageElement extends PageElement {
    @FindBy(xpath = "//div[contains, 'minicart']")
    private WebElement miniCartContainer;
    private By proceedToCheckoutButtonLocator = By.xpath(".//button[text()='Proceed to Checkout']");

    public MiniCartPageElement clickOnProceedToCheckoutButton() {
        WebElement button = miniCartContainer.findElement(proceedToCheckoutButtonLocator);
        button.click();
        return this;
    }
}
