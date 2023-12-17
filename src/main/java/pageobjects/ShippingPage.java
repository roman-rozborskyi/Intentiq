package pageobjects;

import dto.ShippingDataDto;
import enums.Countries;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import pageelements.dropdowns.DropdownRegular;
import pageelements.inputs.InputRegular;
import utils.Waiter;
import utils.drivermanager.DevToolsService;
import utils.drivermanager.DevToolsServiceChrome;

public class ShippingPage extends PageObject {
    private static final By SPINNER_LOCATOR = By.id("checkout-loader");
    private static final String EMAIL_INPUT_NAME = "username";

    public ShippingPage fillEmailInput(ShippingDataDto shippingAddress) {
        String email = shippingAddress.getEMail();
        InputRegular
                .initByInputName(EMAIL_INPUT_NAME)
                .fill(email);
        return this;
    }

    public ShippingPage fillFirstNameInput(ShippingDataDto shippingAddress) {
        String firstName = shippingAddress.getFirstName();
        InputRegular
                .initByInputName("firstname")
                .fill(firstName);
        return this;
    }

    public ShippingPage fillLastNameInput(ShippingDataDto shippingAddress) {
        String lastName = shippingAddress.getLastName();
        InputRegular
                .initByInputName("lastname")
                .fill(lastName);
        return this;
    }

    public ShippingPage fillCompanyInput(ShippingDataDto shippingAddress) {
        String company = shippingAddress.getCompany();
        InputRegular
                .initByInputName("company")
                .fill(company);
        return this;
    }

    public ShippingPage fillStreetAddressInput(ShippingDataDto shippingAddress) {
        String address = shippingAddress.getStreetAddress();
        InputRegular
                .initByInputName("street[0]")
                .fill(address);
        return this;
    }

    public ShippingPage fillCityInput(ShippingDataDto shippingAddress) {
        String city = shippingAddress.getCity();
        InputRegular
                .initByInputName("city")
                .fill(city);
        return this;
    }

    public ShippingPage fillStateInput(ShippingDataDto shippingAddress) {
        String state = shippingAddress.getRegion();
        InputRegular
                .initByInputName("region")
                .fill(state);
        return this;
    }

    public ShippingPage fillZipInput(ShippingDataDto shippingAddress) {
        String zip = shippingAddress.getZip();
        InputRegular
                .initByInputName("postcode")
                .fill(zip);
        return this;
    }

    public ShippingPage selectCountry(ShippingDataDto shippingAddress) {
        Countries country = shippingAddress.getCountry();
        DropdownRegular
                .initBySelectName("country_id")
                .openAndSelect(country.getName());
        return this;
    }

    public ShippingPage fillPhoneNumberInput(ShippingDataDto shippingAddress) {
        String phone = shippingAddress.getPhoneNumber();
        InputRegular
                .initByInputName("telephone")
                .fill(phone);
        return this;
    }

    public ShippingDataDto clickNextButton() {
        DevToolsService devToolsService = new DevToolsServiceChrome();
        ChromeDriver driver = (ChromeDriver) webDriver;
        DevTools devTools = driver.getDevTools();
        devTools.createSession();
//        devTools.addListener(Network);

        return ShippingDataDto
                .builder()
                .eMail("")
                .firstName("")
                .lastName("")
                .company("")
                .streetAddress("")
                .city("")
                .region("")
                .zip("")
                .country(Countries.US)
                .phoneNumber("")
                .build();
    }

    public ShippingPage waitPageReady() {
        new Waiter()
                .waitVisibility(SPINNER_LOCATOR)
                .waitInvisibility(SPINNER_LOCATOR)
                .wait(250);
        InputRegular
                .initByInputName(EMAIL_INPUT_NAME)
                .waitVisibility();
        return this;
    }
}