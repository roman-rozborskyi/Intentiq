package steps;

import pageelements.SectionContentPageElement;

public class ProductsSectionSteps {
    private SectionContentPageElement sectionContentPageElement = new SectionContentPageElement();

    /**
     * clicks on button "Add to cart" in the second product in the first row
     */
    public ProductsSectionSteps addSecondProductToCart() {
        sectionContentPageElement.addSecondProductToCart();
        return this;
    }
}
