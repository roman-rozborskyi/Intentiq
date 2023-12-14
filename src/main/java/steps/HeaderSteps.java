package steps;

import pageelements.header.HeaderPageElement;
import pageelements.header.MiniCartPageElement;
import pageelements.header.sections.HeaderMenuSections;

public class HeaderSteps {
    private HeaderPageElement headerPageElement = new HeaderPageElement();
    private MiniCartPageElement miniCartPageElement = new MiniCartPageElement();

    public HeaderSteps goToBagsSection() {
        headerPageElement.openSubSectionsMenu(HeaderMenuSections.GEAR);
        headerPageElement.selectSubSection(HeaderMenuSections.GEAR.getSubsections());
        return this;
    }

    public HeaderSteps proceedToCheckout() {
        headerPageElement.clickOnCart();
        miniCartPageElement.clickOnProceedToCheckoutButton();
        return null;
    }
}
