package steps;

import dto.ShippingDataDto;
import pageelements.ShippingPageElement;

public class ShippingSteps {
    private ShippingPageElement shippingPageElement = new ShippingPageElement();

    public ShippingSteps fillAllFields(ShippingDataDto shippingAddress) {

        return this;
    }

    public ShippingDataDto goToNextPage() {

        return new ShippingDataDto();
    }
}
