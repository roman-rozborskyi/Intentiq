package utils.randomdatagenerators;

public class PhoneNumberGenerator extends Generator{

    public static String getNumber() {
        return faker.phoneNumber().cellPhone();
    }
}
