package enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Countries {
    US("United States"), UKRAINE("Ukraine");

    private final String name;
}
