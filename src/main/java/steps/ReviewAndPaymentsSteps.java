package steps;

import pageobjects.ReviewAndPaymentPage;

public class ReviewAndPaymentsSteps {
    private ReviewAndPaymentPage reviewandPaymentPage = new ReviewAndPaymentPage();

    public ReviewAndPaymentsSteps placeOrder() {
        reviewandPaymentPage
                .waitPageReady()
                .clickOnPlaceOrderButton();
        return this;
    }
}
