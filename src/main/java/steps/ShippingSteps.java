package steps;

import dto.ShippingDataDto;
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
                 .selectCountry(shippingAddress)
                 .fillEmailInput(shippingAddress)
                 .fillFirstNameInput(shippingAddress)
                 .fillLastNameInput(shippingAddress)
                 .fillCompanyInput(shippingAddress)
                 .fillStreetAddressInput(shippingAddress)
                 .fillCityInput(shippingAddress)
                 .fillStateInput(shippingAddress)
                 .fillZipInput(shippingAddress)
                 .fillPhoneNumberInput(shippingAddress);
        return shippingAddress;
    }

    public ShippingDataDto goToNextPage() {
        return shippingPage.clickNextButton();
    }
}
