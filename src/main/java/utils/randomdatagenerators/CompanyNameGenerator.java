package utils.randomdatagenerators;

public class CompanyNameGenerator extends Generator{

    public static String getName() {
        return faker.company().name();
    }
}
