package dtos;

import enums.Countries;
import enums.ShippingMethods;
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
                .country(Countries.UKRAINE)
                .phoneNumber(PhoneNumberGenerator.getNumber())
                .shippingMethod(ShippingMethods.FIVE)
                .build();
    }
}
