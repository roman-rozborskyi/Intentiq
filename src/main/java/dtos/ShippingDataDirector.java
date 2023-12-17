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

    public ShippingDataDto getInstance(ShippingDataHttpRequest request) {
        ShippingDataHttpRequest.ShippingAddress shippingAddress = request.getAddressInformation().getShippingAddress();
        ShippingDataHttpRequest.BillingAddress billingAddress = request.getAddressInformation().getBillingAddress();
        return ShippingDataDto
                .builder()
//                .eMail(billingAddress.)
                .firstName(shippingAddress.getFirstname())
                .lastName(shippingAddress.getLastname())
                .company(shippingAddress.getCompany())
                .streetAddress(shippingAddress.getStreet().get(0))
                .city(shippingAddress.getCity())
                .region(shippingAddress.getRegion())
                .zip(shippingAddress.getPostcode())
                .country(Countries.valueOf(shippingAddress.getCountryId()))
                .phoneNumber(shippingAddress.getTelephone())
                .shippingMethod(ShippingMethods.FIVE)
                .build();
    }
}
