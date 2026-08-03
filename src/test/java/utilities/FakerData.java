package utilities;

import net.datafaker.Faker;

public class FakerData {

   public static Faker faker = new Faker();



    public static String userName(){
        return faker.name().fullName();
    }
    public static String emailAddress(){
        return faker.internet().emailAddress();
    }
    public static String password(){
        return faker.credentials().password(8,11);
    }
}
