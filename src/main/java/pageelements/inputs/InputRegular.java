package pageelements.inputs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pageelements.PageElement;
import utils.Waiter;

import java.util.List;

public class InputRegular extends PageElement implements Input{
    private static final String INPUT_CONTAINER_XPATH = "//input[@class='input-text' and @%s='%s']/ancestor::div[contains(@class, 'field')][1]";
    private static final String INPUT_XPATH = ".//input";
    private WebElement inputContainer;

    private InputRegular(String attributeName, String attributeValue) {
        String inputContainerXpathFull = String.format(INPUT_CONTAINER_XPATH, attributeName, attributeValue);
        inputContainer =
                webDriver
                        .findElements(By.xpath(inputContainerXpathFull))
                        .stream()
                        .filter(WebElement::isDisplayed)
                        .findFirst()
                        .orElseThrow(() -> new RuntimeException(String.format("Input \"%s\" isn't displayed on the page", inputContainerXpathFull)));
    }

    public static InputRegular initByInputName(String name) {
        return new InputRegular("name", name);
    }

    public InputRegular fill(String value) {
        List<WebElement> inputs = inputContainer.findElements(By.xpath(INPUT_XPATH));
        WebElement input =
                inputs
                        .stream()
                        .filter(WebElement::isDisplayed)
                        .findFirst()
                        .orElseThrow(() -> new RuntimeException("Input isn't displayed on the page"));
        input.sendKeys(value);
        return this;
    }

    public InputRegular waitVisibility() {
        new Waiter().waitVisibility(inputContainer);
        return this;
    }
}
