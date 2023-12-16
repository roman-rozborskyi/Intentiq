package steps;

import pageobjects.SectionContentPage;

public class ProductsSectionSteps {
    private SectionContentPage sectionContentPage = new SectionContentPage();

    /**
     * clicks on button "Add to cart" in the second product in the first row
     */
    public ProductsSectionSteps addSecondProductToCart() {
        sectionContentPage
                .waitUntilPageReady()
                .addSecondProductToCart();
        return this;
    }
}
