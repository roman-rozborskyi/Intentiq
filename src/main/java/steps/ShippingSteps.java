package steps;

import dtos.ShippingDataDto;
import pageobjects.ShippingPage;

public class ShippingSteps {
    private ShippingPage shippingPage = new ShippingPage();

    /**
     * Ukraine is selected from the "Country" list
     * all other fields filled with random values
     */
    public ShippingDataDto fillAllFieldsUkraine() {
        ShippingDataDto shippingAddress = ShippingDataDto.getDirector().getInstanceRandomValuesUkraine();

         shippingPage
                 .waitPageReady()
                 .selectCountry(shippingAddress)
                 .fillEmailInput(shippingAddress)
                 .fillFirstNameInput(shippingAddress)
                 .fillLastNameInput(shippingAddress)
                 .fillCompanyInput(shippingAddress)
                 .fillStreetAddressInput(shippingAddress)
                 .fillCityInput(shippingAddress)
                 .fillStateInput(shippingAddress)
                 .fillPhoneNumberInput(shippingAddress)
                 .fillZipInput(shippingAddress);
         return shippingAddress;
    }

    public ShippingDataDto goToNextPage() {
        return shippingPage.clickNextButton();
    }
}
