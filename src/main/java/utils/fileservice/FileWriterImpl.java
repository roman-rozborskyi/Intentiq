package utils.fileservice;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileWriterImpl implements FileWriter{
    private static final Path FILE_PATH = Paths.get("test_data.txt");

    public void write(String text) {
        try {
            Files.writeString(FILE_PATH, text);
        }
        catch (IOException e) {
            String errorMessage = String.format("an exception is thrown while adding the order ID to the file \"%s\"", FILE_PATH);
            throw new RuntimeException(errorMessage);
        }
    }
}
