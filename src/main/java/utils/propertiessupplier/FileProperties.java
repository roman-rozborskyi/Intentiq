package utils.propertiessupplier;

import java.io.IOException;
import java.io.InputStream;

public class FileProperties implements Properties {
    private final java.util.Properties PROPERTIES = new java.util.Properties();
    private boolean isFileExists;

    public FileProperties(String fileName) {
        String filePath = String.format("%s.properties",  fileName);

        try (InputStream inputStream = getClass().getResourceAsStream(filePath)) {
            PROPERTIES.load(inputStream);
            isFileExists = true;
        } catch (NullPointerException | IOException e) {
            //If file doesn't it will be processed in the ProjectProperties class
        }
    }

    @Override
    public boolean isPropertyPresent(String propertyName) {
        return isFileExists && PROPERTIES.getProperty(propertyName) != null;
    }

    @Override
    public String getProperty(String propertyName) {
        return PROPERTIES.getProperty(propertyName);
    }
}
