package tests;

import dto.ShippingDataDto;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BuyingTest extends BaseTest{

    @Test(description = "Order creation test. Checking data sent to the backend")
    public void buyingTest() {
        ShippingDataDto shippingDataInserted = ShippingDataDto.getInstanceRandomValues();

        headerSteps.goToBagsSection();
        productsSectionSteps.addSecondProductToCart();
        headerSteps.proceedToCheckout();

        shippingSteps.fillAllFields(shippingDataInserted);
        ShippingDataDto shippingDataSent = shippingSteps.goToNextPage();
        reviewAndPaymentsSteps.placeOrder();
        orderInfoSteps.writeOrderIdToFile();

        Assert.assertEquals(shippingDataInserted, shippingDataSent, "Incorrect shipping data is sent to the server");
    }
}
