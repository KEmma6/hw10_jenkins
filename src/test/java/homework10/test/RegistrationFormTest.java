package homework10.test;

import TestBase.TestBase;
import com.github.javafaker.Faker;
import homework10.pages.RegistrationPage;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class RegistrationFormTest extends TestBase {

    @Test
    @Tag("properties")
    void checkStudentRegistration() {
        Faker faker = new Faker();
        RegistrationPage registrationPage = new RegistrationPage();

        String name = faker.name().firstName();
        String lastName = faker.name().lastName();
        String email = faker.internet().emailAddress("com");
        String phone = faker.number().digits(10);
        String address = faker.address().streetAddress();
        String subject = "Biology";
        String gender = "Female";
        String year = "1992";
        String month = "November";
        String image = "images/imgForTestRegistration.png";

        registrationPage
                .openPage();

        registrationPage
                .setInputName(name)
                .setInputLastName(lastName)
                .clickCheckBoxFemale()
                .setInputEmail(email)
                .setInputPhone(phone)
                .setInputDateOfBirth(month, year)
                .chooseSubject(subject)
                .clickCheckBoxHobbies()
                .upLoadImageOnPage(image)
                .setAddressInTextarea(address)
                .chooseState()
                .chooseCity()
                .clickButtonSubmit();

        registrationPage
                .assertSubmitTitleIsVisible()
                .assertTableAfterRegistrationHave(name)
                .assertTableAfterRegistrationHave(lastName)
                .assertTableAfterRegistrationHave(email)
                .assertTableAfterRegistrationHave(gender)
                .assertTableAfterRegistrationHave(phone)
                .assertTableAfterRegistrationHave(month)
                .assertTableAfterRegistrationHave(year)
                .assertTableAfterRegistrationHave(subject)
                .assertTableAfterRegistrationHave(address)
                .assertTableAfterRegistrationHave(image);
    }
}
