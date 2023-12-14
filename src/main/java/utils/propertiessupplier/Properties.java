package utils.propertiessupplier;

public interface Properties {
    boolean isPropertyPresent(String propertyName);

    String getProperty(String propertyName);
}
