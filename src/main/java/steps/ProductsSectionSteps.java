package steps;

import pageelements.SectionContentPageElement;

public class ProductsSectionSteps {
    private SectionContentPageElement sectionContentPageElement = new SectionContentPageElement();

    public ProductsSectionSteps addSecondProductToCart() {
        sectionContentPageElement.addSecondProductToCart();
        return this;
    }
}
