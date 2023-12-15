package steps;

import pageobjects.ReviewAndPaymentPage;

public class ReviewAndPaymentsSteps {
    private ReviewAndPaymentPage reviewandPaymentPage = new ReviewAndPaymentPage();

    public ReviewAndPaymentsSteps placeOrder() {
        reviewandPaymentPage.clickOnPlaceOrderButton();
        return this;
    }
}
