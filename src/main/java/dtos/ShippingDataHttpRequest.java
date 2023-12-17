package dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
public class ShippingDataHttpRequest {
    private AddressInformation addressInformation;
    @Getter
    @Setter
    public class AddressInformation {
        private ShippingAddress shippingAddress;
        private BillingAddress billingAddress;
        private String shippingMethodCode;
        private String shippingCarrierCode;
        private ExtensionAttributes extensionAttributes;
    }

    @Getter
    @Setter
    public class BillingAddress {
        private String countryId;
        private String region;
        private List<String> street = new ArrayList<>();
        private String company;
        private String telephone;
        private String postcode;
        private String city;
        private String firstname;
        private String lastname;
        private Object saveInAddressBook;
    }

    @Getter
    @Setter
    public class ExtensionAttributes {
    }

    @Getter
    @Setter
    public class ShippingAddress {
        private String countryId;
        private String region;
        private List<String> street = new ArrayList<>();
        private String company;
        private String telephone;
        private String postcode;
        private String city;
        private String firstname;
        private String lastname;
    }
}
