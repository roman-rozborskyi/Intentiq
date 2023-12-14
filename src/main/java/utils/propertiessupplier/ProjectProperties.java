package utils.propertiessupplier;

import java.util.List;

public class ProjectProperties {

    static List<Properties> properties = List.of(
            new VmProperties(),
            new FileProperties("local"),
            new EnvironmentProperties(),
            new FileProperties("general"));

    public static String getProperty(String propertyName) {
        return properties.stream()
                .filter(p -> p.isPropertyPresent(propertyName))
                .findFirst()
                .orElseThrow(() -> {
                    String errorMessage = String.format("Property \"%s\" isn't defined", propertyName);
                    return new RuntimeException(errorMessage);
                })
                .getProperty(propertyName);
    }
}
