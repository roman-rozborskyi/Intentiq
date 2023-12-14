package enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum Browsers {
    CHROME("Chrome"), EDGE("Edge"), FIREFOX("Firefox");

    private final String name;

    public static Browsers getBrowserName(String browserName) {
        String errorMessage = String.format("\"%s\" is a wrong browser name", browserName);

        return Arrays.stream(Browsers.values())
                .filter(n -> n.getName().equalsIgnoreCase(browserName))
                .findFirst()
                .orElseThrow(() -> new RuntimeException(errorMessage));
    }
}
