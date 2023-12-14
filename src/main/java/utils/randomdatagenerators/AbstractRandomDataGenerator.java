package utils.randomdatagenerators;

import com.github.javafaker.Faker;
import utils.propertiesmanager.ProjectProperties;

public abstract class AbstractRandomDataGenerator {
    protected static final String AUTOMATION_PREFIX = ProjectProperties.getProperty("automationPrefix");
    protected static Faker faker = new Faker();
}
