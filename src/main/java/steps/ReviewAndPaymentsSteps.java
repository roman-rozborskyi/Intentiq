package steps;

import pageelements.ReviewandPaymentPageElement;

public class ReviewAndPaymentsSteps {
    private ReviewandPaymentPageElement reviewandPaymentPageElement = new ReviewandPaymentPageElement();

    public ReviewAndPaymentsSteps placeOrder() {
        reviewandPaymentPageElement.clickOnPlaceOrder();
        return this;
    }
}
