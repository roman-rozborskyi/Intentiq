package pageelements.header;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pageelements.PageElement;
import pageelements.header.sections.HeaderMenu;
import pageelements.header.sections.HeaderMenuSections;
import pageelements.header.sections.subsections.GearSubsections;
import utils.Waiter;

public class HeaderPageElement extends PageElement {
    private static final String CART_SPINNER_XPATH = "//div[@data-role='loader']";
    private HeaderMenu headerMenu = new HeaderMenu();

    public void goToSection(HeaderMenuSections section, GearSubsections subsection) {
        headerMenu.goToSection(section, subsection);
    }

    public void clickOnCart() {
        WebElement miniCart = webDriver.findElement(By.className("minicart-wrapper"));
        miniCart.click();
    }

    public void waitSpinnerNotPresent() {
        new Waiter().waitInvisibility(By.xpath(CART_SPINNER_XPATH));
    }
}
