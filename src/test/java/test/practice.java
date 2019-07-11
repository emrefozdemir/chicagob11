package test;

import com.github.javafaker.Faker;

public class practice {
    public static void main(String[] args) {
        Faker faker = new Faker();
        String str = faker.business().creditCardNumber();
        System.out.println(faker.business().creditCardExpiry().substring(5).replace("-",""));

    }
}
