package dtos;

import enums.Countries;
import enums.ShippingMethods;
import lombok.Builder;
import lombok.Getter;
import utils.drivermanager.CheckableInRequest;

@Getter
@Builder
public class ShippingDataDto implements CheckableInRequest {
    private String eMail;
    private String firstName;
    private String lastName;
    private String company;
    private String streetAddress;
    private String city;
    private String region;
    private String zip;
    private Countries country;
    private String phoneNumber;
    private ShippingMethods shippingMethod;

    public static ShippingDataDirector getDirector() {
        return new ShippingDataDirector();
    }
}
