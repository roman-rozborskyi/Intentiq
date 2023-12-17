package pageobjects;

import dtos.ShippingDataDto;
import enums.Countries;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pageelements.LoadingMaskElement;
import pageelements.dropdowns.DropdownRegular;
import pageelements.inputs.InputRegular;
import utils.Waiter;
import utils.drivermanager.DevToolsServiceChrome;

public class ShippingPage extends PageObject {
    private static final By SPINNER_LOCATOR = By.id("checkout-loader");
    private static final By NEXT_BUTTON_LOCATOR = By.xpath("//button[.//span[text()='Next']]");
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
        new LoadingMaskElement().waitLoading();
        return this;
    }

    public ShippingPage selectCountry(ShippingDataDto shippingAddress) {
        Countries country = shippingAddress.getCountry();
        new DropdownRegular("country_id")
                .select(country.getName());
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
        DevToolsServiceChrome devToolsServiceChrome = new DevToolsServiceChrome();
        devToolsServiceChrome.createSession();
        devToolsServiceChrome.requestToObject();

        new Waiter().waitClickable(NEXT_BUTTON_LOCATOR);
        WebElement button = webDriver.findElement(NEXT_BUTTON_LOCATOR);
        button.click();

        return (ShippingDataDto) devToolsServiceChrome.requestToObject();
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