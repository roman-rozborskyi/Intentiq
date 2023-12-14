package utils.randomdatagenerators;

import utils.propertiesmanager.ProjectProperties;

public class EmailGenerator extends AbstractRandomDataGenerator {
    protected static final String COMPANY_NAME = ProjectProperties.getProperty("companyName");

    public static String getEmail() {
        String word = faker.lorem().word();
        String number = faker.number().digits(10);
        return String.format("%s.%s.%s@%s.com", AUTOMATION_PREFIX, word, number, COMPANY_NAME);
    }
}
