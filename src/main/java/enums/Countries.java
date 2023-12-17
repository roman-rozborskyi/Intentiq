package enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Countries {
    US("United States", "US"), UKRAINE("Ukraine", "UA");

    private final String name;
    private final String id;

    public static Countries toCountry(String name) {
        return valueOf(name);
    }
}
