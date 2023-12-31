package steps;

import pageelements.header.HeaderPageElement;
import pageelements.header.MiniCartPageElement;
import pageelements.header.sections.subsections.GearSubsections;
import pageelements.header.sections.HeaderMenuSections;
import utils.Waiter;

public class HeaderSteps {
    private HeaderPageElement headerPageElement = new HeaderPageElement();
    private MiniCartPageElement miniCartPageElement = new MiniCartPageElement();

    public HeaderSteps goToBagsSection() {
        headerPageElement.goToSection(HeaderMenuSections.GEAR, GearSubsections.BAGS);
        return this;
    }

    public HeaderSteps goToCheckout() {
        headerPageElement.waitSpinnerNotPresent();
        new Waiter().wait(250);
        headerPageElement.clickOnCart();
        miniCartPageElement.clickOnProceedToCheckoutButton();
        return null;
    }
}
