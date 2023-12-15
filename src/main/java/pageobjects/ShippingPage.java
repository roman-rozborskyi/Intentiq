package pageobjects;

import dto.ShippingDataDto;
import enums.Countries;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import utils.drivermanager.DevToolsService;
import utils.drivermanager.DevToolsServiceChrome;

public class ShippingPage extends PageObject {
    private By emailInputLocator = By.xpath("//input[@name='username']");
    private By firstNameInputLocator = By.xpath("//input[@name='firstname']");
    private By lastNameInputLocator = By.xpath("//input[@name='lastname']");
    private By companyInputLocator = By.xpath("//input[@name='company']");
    private By streetInputLocator = By.xpath("//input[@name='street[0]']");
    private By cityInputLocator = By.xpath("//input[@name='city']");
    private By regionInputLocator = By.xpath("//input[@name='region']");
    private By zipInputLocator = By.xpath("//input[@name='postcode']");
    private By phoneInputLocator = By.xpath("//input[@name='telephone']");

    public ShippingPage fillEmailInput(ShippingDataDto shippingAddress) {
        String email = shippingAddress.getEMail();
        WebElement input = webDriver.findElement(emailInputLocator);
        input.sendKeys(email);
        return this;
    }

    public ShippingPage fillFirstNameInput(ShippingDataDto shippingAddress) {
        String firstName = shippingAddress.getFirstName();
        WebElement input = webDriver.findElement(emailInputLocator);
        input.sendKeys(firstName);
        return this;
    }

    public ShippingPage fillLastNameInput(ShippingDataDto shippingAddress) {
        String lastName = shippingAddress.getLastName();
        WebElement input = webDriver.findElement(emailInputLocator);
        input.sendKeys(lastName);
        return this;
    }

    public ShippingPage fillCompanyInput(ShippingDataDto shippingAddress) {
        String company = shippingAddress.getCompany();
        WebElement input = webDriver.findElement(emailInputLocator);
        input.sendKeys(company);
        return this;
    }

    public ShippingPage fillStreetAddressInput(ShippingDataDto shippingAddress) {
        String address = shippingAddress.getStreetAddress();
        WebElement input = webDriver.findElement(emailInputLocator);
        input.sendKeys(address);
        return this;
    }

    public ShippingPage fillCityInput(ShippingDataDto shippingAddress) {
        String city = shippingAddress.getCity();
        WebElement input = webDriver.findElement(emailInputLocator);
        input.sendKeys(city);
        return this;
    }

    public ShippingPage fillStateInput(ShippingDataDto shippingAddress) {
        String state = shippingAddress.getRegion();
        WebElement input = webDriver.findElement(emailInputLocator);
        input.sendKeys(state);
        return this;
    }

    public ShippingPage fillZipInput(ShippingDataDto shippingAddress) {
        String zip = shippingAddress.getZip();
        WebElement input = webDriver.findElement(emailInputLocator);
        input.sendKeys(zip);
        return this;
    }

    public ShippingPage selectCountry(ShippingDataDto shippingAddress) {
        Countries country = shippingAddress.getCountry();
        WebElement input = webDriver.findElement(emailInputLocator);
        input.sendKeys(country);
        return this;
    }

    public ShippingPage fillPhoneNumberInput(ShippingDataDto shippingAddress) {
        String phone = shippingAddress.getPhoneNumber();
        WebElement input = webDriver.findElement(emailInputLocator);
        input.sendKeys(phone);
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