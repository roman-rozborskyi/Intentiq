package pageelements.header.sections;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pageelements.PageElement;
import pageelements.header.HeaderMenuSubsections;
import pageelements.header.sections.subsections.GearSubsections;
import utils.Waiter;

import java.time.Duration;

public class HeaderMenu extends PageElement {
    private static final By SECTIONS_MENU_XPATH = By.xpath("//div[contains(@class, 'section-item-content')]");
    private static final By SECTION_ARROW_XPATH = By.xpath(".//span[contains(@class, 'ui-menu-icon')]");
    private static final String SECTION_ITEM_XPATH = ".//li[.//span[text()=\"%s\"]]";
    private static final String SUB_SECTION_ITEM_XPATH = ".//li[.//span[text()=\"%s\"]]";

    public void goToSection(HeaderMenuSections section, GearSubsections subsection) {
        WebElement sectionElement = getSectionWebElement(section);
        isMenuReady(sectionElement);
        openSubSectionsMenu(sectionElement);
        selectSubSection(sectionElement, subsection);
    }

    private void openSubSectionsMenu(WebElement sectionElement) {
        new Actions(webDriver)
                .moveToElement(sectionElement)
                .pause(Duration.ofMillis(500))
                .perform();
    }

    private WebElement getSectionWebElement(HeaderMenuSections section) {
        String sectionItemFullXpath = String.format(SECTION_ITEM_XPATH, section.getName());
        return webDriver
                .findElement(SECTIONS_MENU_XPATH)
                .findElement(By.xpath(sectionItemFullXpath));
    }

    private void selectSubSection(WebElement sectionElement, HeaderMenuSubsections subsection) {
        String sectionItemFullXpath = String.format(SUB_SECTION_ITEM_XPATH, subsection.getName());
        WebElement subSectionElement = sectionElement.findElement(By.xpath(sectionItemFullXpath));
        subSectionElement.click();
    }

    private void isMenuReady(WebElement sectionElement) {
        WebElement arrow = sectionElement.findElement(SECTION_ARROW_XPATH);
        new Waiter().waitVisibility(arrow);
    }
}
