package tests;

import dto.ShippingDataDto;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BuyingTest extends BaseTest{

    @Test(groups = "chrome", description = "Order creation test. Checking data sent to the backend")
    public void buyingTest() {
        headerSteps.goToBagsSection();
        productsSectionSteps.addSecondProductToCart();
        headerSteps.goToCheckout();

        ShippingDataDto shippingDataInserted = shippingSteps.fillAllFieldsUkraine();
        ShippingDataDto shippingDataSent = shippingSteps.goToNextPage();
        reviewAndPaymentsSteps.placeOrder();
        orderInfoSteps.writeOrderIdToFile();

        Assert.assertEquals(shippingDataInserted, shippingDataSent, "Incorrect shipping data is sent to the server");
    }
}
