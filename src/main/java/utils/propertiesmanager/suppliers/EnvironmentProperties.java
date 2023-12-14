package utils.propertiesmanager.suppliers;

import utils.propertiesmanager.PropertiesSupplier;

public class EnvironmentProperties implements PropertiesSupplier {
    @Override
    public boolean isPropertyPresent(String propertyName) {
        return getProperty(propertyName) != null;
    }

    @Override
    public String getProperty(String propertyName) {
        return System.getenv(propertyName);
    }
}
