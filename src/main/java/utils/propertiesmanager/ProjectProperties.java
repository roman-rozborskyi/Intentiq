package utils.propertiesmanager;

import utils.propertiesmanager.suppliers.EnvironmentProperties;
import utils.propertiesmanager.suppliers.FileProperties;
import utils.propertiesmanager.suppliers.VmProperties;

import java.util.List;

public class ProjectProperties {

    static List<PropertiesSupplier> properties = List.of(
            new VmProperties(),
            new FileProperties("ui"),
            new EnvironmentProperties()
    );

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
