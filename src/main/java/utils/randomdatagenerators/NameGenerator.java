package utils.randomdatagenerators;

public class NameGenerator extends AbstractRandomDataGenerator {

    public static String getFirstName() {
        String fullName = faker.name().firstName();
        return AUTOMATION_PREFIX + fullName;
    }

    public static String getLastName() {
        String fullName = faker.name().lastName();
        return AUTOMATION_PREFIX + fullName;
    }
}
