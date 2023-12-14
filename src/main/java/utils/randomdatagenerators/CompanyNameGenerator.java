package utils.randomdatagenerators;

public class CompanyNameGenerator extends AbstractRandomDataGenerator {

    public static String getName() {
        return faker.company().name();
    }
}
