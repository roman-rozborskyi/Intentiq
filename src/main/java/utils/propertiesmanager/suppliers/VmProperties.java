package utils.propertiesmanager.suppliers;

import utils.propertiesmanager.PropertiesSupplier;

public class VmProperties implements PropertiesSupplier {
    @Override
    public boolean isPropertyPresent(String propertyName) {
        return getProperty(propertyName) != null;
    }

    @Override
    public String getProperty(String propertyName) {
        return System.getProperty(propertyName);
    }
}
