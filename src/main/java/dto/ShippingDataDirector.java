package dto;

import enums.Countries;
import utils.randomdatagenerators.*;

public class ShippingDataDirector {
    public ShippingDataDto getInstanceRandomValuesUkraine() {
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
