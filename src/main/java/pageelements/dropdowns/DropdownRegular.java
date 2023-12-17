package pageelements.dropdowns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pageelements.PageElement;
import org.openqa.selenium.support.ui.Select;

public class DropdownRegular extends PageElement implements Dropdown {
    private final String selectName;

    public DropdownRegular(String name) {
        selectName = name;
    }

    public DropdownRegular select(String value) {
        WebElement selectElement = webDriver.findElement(By.name(selectName));
        new Select(selectElement).selectByVisibleText(value);
        return this;
    }
}
