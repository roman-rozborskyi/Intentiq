package pageobjects;

import dto.ShippingDataDto;
import enums.Countries;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import pageelements.dropdowns.Dropdown;
import pageelements.dropdowns.DropdownRegular;
import pageelements.inputs.Input;
import pageelements.inputs.InputRegular;
import utils.drivermanager.DevToolsService;
import utils.drivermanager.DevToolsServiceChrome;

public class ShippingPage extends PageObject {
    private Input emailInput = InputRegular.initByInputName("username");
    private Input firstNameInput = InputRegular.initByInputName("firstname");
    private Input lastNameInput = InputRegular.initByInputName("lastname");
    private Input companylInput = InputRegular.initByInputName("company");
    private Input streetInput = InputRegular.initByInputName("street[0]");
    private Input cityInput = InputRegular.initByInputName("city");
    private Input zipInput = InputRegular.initByInputName("postcode");
    private Input phoneInput = InputRegular.initByInputName("telephone");
    private Input regionInput = InputRegular.initByInputName("region");
    private Dropdown countryDropdown = DropdownRegular.initBySelectName("country_id");

    public ShippingPage fillEmailInput(ShippingDataDto shippingAddress) {
        String email = shippingAddress.getEMail();
        emailInput.fill(email);
        return this;
    }

    public ShippingPage fillFirstNameInput(ShippingDataDto shippingAddress) {
        String firstName = shippingAddress.getFirstName();
        firstNameInput.fill(firstName);
        return this;
    }

    public ShippingPage fillLastNameInput(ShippingDataDto shippingAddress) {
        String lastName = shippingAddress.getLastName();
        lastNameInput.fill(lastName);
        return this;
    }

    public ShippingPage fillCompanyInput(ShippingDataDto shippingAddress) {
        String company = shippingAddress.getCompany();
        companylInput.fill(company);
        return this;
    }

    public ShippingPage fillStreetAddressInput(ShippingDataDto shippingAddress) {
        String address = shippingAddress.getStreetAddress();
        streetInput.fill(address);
        return this;
    }

    public ShippingPage fillCityInput(ShippingDataDto shippingAddress) {
        String city = shippingAddress.getCity();
        cityInput.fill(city);
        return this;
    }

    public ShippingPage fillStateInput(ShippingDataDto shippingAddress) {
        String state = shippingAddress.getRegion();
        regionInput.fill(state);
        return this;
    }

    public ShippingPage fillZipInput(ShippingDataDto shippingAddress) {
        String zip = shippingAddress.getZip();
        zipInput.fill(zip);
        return this;
    }

    public ShippingPage selectCountry(ShippingDataDto shippingAddress) {
        Countries country = shippingAddress.getCountry();
        countryDropdown.openAndSelect(country.getName());
        return this;
    }

    public ShippingPage fillPhoneNumberInput(ShippingDataDto shippingAddress) {
        String phone = shippingAddress.getPhoneNumber();
        phoneInput.fill(phone);
        return this;
    }

    public ShippingDataDto clickNextButton() {
        DevToolsService devToolsService = new DevToolsServiceChrome();
        ChromeDriver driver = (ChromeDriver) webDriver;
        DevTools devTools = driver.getDevTools();
        devTools.createSession();
        devTools.addListener(Network);

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
                .build();;
    }
}