package utils.randomdatagenerators;

import com.github.javafaker.Faker;
import utils.propertiessupplier.ProjectProperties;

public abstract class Generator {
    protected static final String AUTOMATION_PREFIX = ProjectProperties.getProperty("automationPrefix");
    protected static Faker faker = new Faker();
}
