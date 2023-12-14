package utils.randomdatagenerators;

public class EmailGenerator extends Generator{

    public static String getEmail() {
        String word = faker.lorem().word();
        String number = faker.number().digits(10);
        return String.format("%s.%s.%s@softwaretestingboard.com", AUTOMATION_PREFIX, word, number);
    }
}
