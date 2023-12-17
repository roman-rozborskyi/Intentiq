package steps;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dtos.ShippingDataDirector;
import dtos.ShippingDataDto;
import dtos.ShippingDataHttpRequest;
import org.openqa.selenium.devtools.v120.network.model.Request;
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
//        Request request = shippingPage.clickNextButton();
shippingPage.clickNextButton();
//        String sentData = request.getPostData().orElseThrow(() -> new RuntimeException("Impossible to get request from the HTTP"));
        Gson gson = new GsonBuilder().create();
//        ShippingDataHttpRequest shippingDataHttpRequest = gson.fromJson(sentData, ShippingDataHttpRequest.class);
        ShippingDataDto shippingDataDto = new ShippingDataDirector().getInstanceRandomValuesUkraine();
        return shippingDataDto;
    }
}
