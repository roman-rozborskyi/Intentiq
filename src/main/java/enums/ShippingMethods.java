package enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ShippingMethods {
    FIVE("$5.00");

    private String text;
}
