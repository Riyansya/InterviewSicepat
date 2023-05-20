package automation.config;

import com.github.javafaker.Faker;

import java.util.Locale;

public class FakerUserProfile {

    public String fullName;
    public String firstName;
    public String lastName;
    public String username;
    public String streetAddress;
    public String cellPhone;
    public String city;
    public String nik;
    public String gender;
    public String numberAddress;
    public String fullAddress;
    public String quotes;
    public String email;

    public FakerUserProfile() {
        Faker faker = new Faker(new Locale("in-ID"));

        fullName = faker.name().fullName();
        firstName = faker.name().firstName();
        lastName = faker.name().lastName();
        username = faker.name().username();
        streetAddress = faker.address().streetAddress();
        cellPhone = "0821" + faker.phoneNumber().cellPhone().replaceAll("\\D+", "").substring(0, 8);
        city = faker.address().stateAbbr();
        gender = "male";
        numberAddress = faker.address().streetAddressNumber();
        fullAddress = faker.address().fullAddress();
        nik = faker.business().creditCardNumber();
        quotes = faker.buffy().quotes();
        email = fullName.replaceAll("\\W+", "").toLowerCase() + Faker.instance().number().digits(3) + "@example.com";
    }
}