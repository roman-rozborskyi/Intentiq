package utils.propertiessupplier;

public class VmProperties implements Properties{
    @Override
    public boolean isPropertyPresent(String propertyName) {
        return getProperty(propertyName) != null;
    }

    @Override
    public String getProperty(String propertyName) {
        return System.getProperty(propertyName);
    }
}
