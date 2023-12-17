package pageelements.dropdowns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pageelements.PageElement;

import java.util.List;

public class DropdownRegular extends PageElement implements Dropdown {
    private static final String SELECT_CONTAINER_XPATH = "//select[@class='select' and @%s=\"%s\"]/ancestor::div[contains(@class, 'field')][1]";
    private static final String INTERACTABLE_WEBELEMENT_XPATH = ".//div[@class='control']";
    private static final String OPTION_XPATH = ".//option[text()=\"%s\"]";
    private WebElement dropdownContainer;

    private DropdownRegular(String attributeName, String attributeValue) {
        String inputContainerXpathFull = String.format(SELECT_CONTAINER_XPATH, attributeName, attributeValue);
        dropdownContainer = webDriver.findElement(By.xpath(inputContainerXpathFull));
    }

    public static DropdownRegular initBySelectName(String name) {
        return new DropdownRegular("name", name);
    }

    public DropdownRegular openAndSelect(String value) {
        open();
        scrollTo(value);
        select(value);
        return this;
    }

    public DropdownRegular open() {
        List<WebElement> inputs = dropdownContainer.findElements(By.xpath(INTERACTABLE_WEBELEMENT_XPATH));
        WebElement interactableWebElement =
                inputs
                        .stream()
                        .filter(WebElement::isDisplayed)
                        .findFirst()
                        .orElseThrow(() -> new RuntimeException("Dropdown isn't displayed on the page"));
        interactableWebElement.click();
        return this;
    }

    public DropdownRegular select(String value) {
        WebElement option = getOption(value);
        option.click();

        return this;
    }

    public DropdownRegular scrollTo(String value) {
        WebElement option = getOption(value);
        new Actions(webDriver)
                .scrollToElement(option)
                .perform();

        return this;
    }

    private WebElement getOption(String value) {
        String optionFullXpath = String.format(OPTION_XPATH, value);
        return dropdownContainer.findElement(By.xpath(optionFullXpath));
    }
}
