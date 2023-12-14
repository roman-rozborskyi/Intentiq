package dto;

import enums.Countries;
import enums.ShippingMethods;
import lombok.Builder;
import utils.randomdatagenerators.*;

@Builder
public class ShippingDataDto {
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

    public static ShippingDataDto getInstanceRandomValues() {

        return ShippingDataDto
                .builder()
                .eMail(EmailGenerator.getEmail())
                .firstName(NameGenerator.getFirstName())
                .lastName(NameGenerator.getLastName())
                .company(CompanyNameGenerator.getName())
                .streetAddress(AddressGenerator.getStreet())
                .city(AddressGenerator.getCity())
                .region(AddressGenerator.getRegion())
                .zip(AddressGenerator.getZip())
                .country(Countries.US)
                .phoneNumber(PhoneNumberGenerator.getNumber())
                .shippingMethod(CompanyNameGenerator.getName());
    }
}
