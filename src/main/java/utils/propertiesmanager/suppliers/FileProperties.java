package utils.propertiesmanager.suppliers;

import utils.propertiesmanager.PropertiesSupplier;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class FileProperties implements PropertiesSupplier {
    private final java.util.Properties PROPERTIES = new java.util.Properties();
    private boolean isFileExists;

    public FileProperties(String fileName) {
        String filePath = "./src/main/resources/ui.properties";

        try (InputStream inputStream = new FileInputStream(filePath)) {
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
