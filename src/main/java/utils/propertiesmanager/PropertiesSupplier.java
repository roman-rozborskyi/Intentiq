package utils.propertiesmanager;

public interface PropertiesSupplier {
    boolean isPropertyPresent(String propertyName);

    String getProperty(String propertyName);
}
