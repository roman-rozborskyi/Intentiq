package utils.randomdatagenerators;

public class PhoneNumberGenerator extends AbstractRandomDataGenerator {

    public static String getNumber() {
        return faker.phoneNumber().cellPhone();
    }
}
