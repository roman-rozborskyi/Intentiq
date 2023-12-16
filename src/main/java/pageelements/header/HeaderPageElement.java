package pageelements.header;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pageelements.PageElement;
import pageelements.header.sections.HeaderMenuSections;

public class HeaderPageElement extends PageElement {
    private String sectionsMenuXpath = "//div[contains(@class, 'section-item-content')]";
    private String sectionItemXpath = ".//li[.//span[text()=\"%s\"]]";
    private String subSectionItemXpath = ".//li[.//span[text()=\"%s\"]]";

    public HeaderPageElement openSubSectionsMenu(HeaderMenuSections section) {
        String sectionItemFullXpath = String.format(sectionItemXpath, section.getName());
        WebElement sectionElement =
                webDriver
                        .findElement(By.xpath(sectionsMenuXpath))
                        .findElement(By.xpath(sectionItemFullXpath));
        new Actions(webDriver)
                .moveToElement(sectionElement)
                .perform();
        return null;
    }

    public HeaderPageElement selectSubSection(HeaderMenuSubsections subsection) {
        String subSectionItemFullXpath = String.format(subSectionItemXpath, subsection.getName());
        WebElement subSectionElement = webDriver
                .findElement(By.xpath(sectionsMenuXpath))
                .findElement(By.xpath(subSectionItemFullXpath));
        subSectionElement.click();
        return null;
    }

    public HeaderPageElement clickOnCart() {
        WebElement miniCart = webDriver.findElement(By.className("minicart-wrapper"));
        miniCart.click();
        return null;
    }
}
