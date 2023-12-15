package pageelements.inputs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pageelements.PageElement;

import java.util.List;

public class InputRegular extends PageElement implements Input{
    private static final String INPUT_CONTAINER_XPATH = "//div[.//input[@%s=\"%s\" and @class='input-text'] and contains(@class, 'field')]";
    private static final String INPUT_XPATH = ".//input";
    private WebElement inputContainer;

    private InputRegular(String attributeName, String attributeValue) {
        String inputContainerXpathFull = String.format(INPUT_CONTAINER_XPATH, attributeName, attributeValue);
        inputContainer = webDriver.findElement(By.xpath(inputContainerXpathFull));
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
}
