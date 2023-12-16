package pageelements.header;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pageelements.PageElement;
import pageelements.header.sections.HeaderMenuSections;
import pageelements.header.sections.subsections.GearSubsections;
import utils.Waiter;

import java.time.Duration;

public class HeaderPageElement extends PageElement {
    private String sectionsMenuXpath = "//div[contains(@class, 'section-item-content')]";
    private String sectionItemXpath = ".//li[.//span[text()=\"%s\"]]";
    private String subSectionItemXpath = ".//li[.//span[text()=\"%s\"]]";

    public HeaderPageElement goToSection(HeaderMenuSections section, GearSubsections subsection) {
        WebElement sectionElement = getSectionWebElement(section);
        openSubSectionsMenu(sectionElement);
        selectSubSection(sectionElement, subsection);
        return null;
    }

    public HeaderPageElement openSubSectionsMenu(WebElement sectionElement) {
        new Actions(webDriver)
                .moveToElement(sectionElement)
                .pause(Duration.ofMillis(500))
                .perform();
        return null;
    }

    private WebElement getSectionWebElement(HeaderMenuSections section) {
        String sectionItemFullXpath = String.format(sectionItemXpath, section.getName());
        By sectionItemLocator = By.xpath(sectionsMenuXpath);
        isElementReady(sectionItemLocator);
        return webDriver
                .findElement(sectionItemLocator)
                .findElement(By.xpath(sectionItemFullXpath));
    }

    public HeaderPageElement selectSubSection(WebElement sectionElement, HeaderMenuSubsections subsection) {
        String sectionItemFullXpath = String.format(subSectionItemXpath, subsection.getName());
        WebElement subSectionElement = sectionElement.findElement(By.xpath(sectionItemFullXpath));
        subSectionElement.click();
        return null;
    }

    public HeaderPageElement clickOnCart() {
        WebElement miniCart = webDriver.findElement(By.className("minicart-wrapper"));
        miniCart.click();
        return null;
    }

    private HeaderPageElement isElementReady(By locator) {
        new Waiter()
                .waitVisibility(locator)
                .wait(250);
        return this;
    }
}
