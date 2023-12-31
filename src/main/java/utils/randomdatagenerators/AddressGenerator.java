package utils.randomdatagenerators;

public class AddressGenerator extends AbstractRandomDataGenerator {

    public static String getStreet() {
        return AUTOMATION_PREFIX + faker.address().streetAddress();
    }

    public static String getCity() {
        return AUTOMATION_PREFIX + faker.address().city();
    }

    public static String getRegion() {
        return AUTOMATION_PREFIX + faker.address().state();
    }

    public static String getZip() {
        return faker.number().digits(5);
    }
}
