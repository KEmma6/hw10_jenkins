package homework10.pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.interactions.Actions;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {

    //элементы
    SelenideElement name = $("#firstName"),
            lastName = $("#lastName"),
            email = $x("//input[@id='userEmail']"),
            checkBoxFemale = $("div.custom-radio > input[value = 'Female']"),
            phone = $("#userNumber"),
            checkBoxHobbies = $("#hobbies-checkbox-3"),
            upLoadPictures =  $("input#uploadPicture"),
            address = $("textarea#currentAddress"),
            stateSelect = $("div#state svg"),
            stateName = $(byText("Uttar Pradesh")),
            citySelect = $("div#city svg[class='css-19bqh2r']"),
            cityName = $(byText("Agra")),
            submitButton = $("button#submit"),
            tableAfterRegistration = $("table[class*='table']"),
            submitTitle = $x("//div[contains(text(), 'Thanks for submit')]");

    //шаги
    public void openPage() {
        open("https://demoqa.com/automation-practice-form");
    }

    public RegistrationPage clickCheckBoxFemale() {
        Actions actions = new Actions(WebDriverRunner.getWebDriver());
        actions.moveToElement(checkBoxFemale).click().build().perform();
        return this;
    }

    public RegistrationPage setInputName(String firstName) {
        name.setValue(firstName);
        return this;
    }

    public RegistrationPage setInputLastName(String surname) {
        lastName.setValue(surname);
        return this;
    }

    public RegistrationPage setInputEmail(String emailAddress) {
        email.setValue(emailAddress);
        return this;
    }

    public RegistrationPage setInputPhone(String numberPhone) {
        phone.setValue(numberPhone);
        return this;
    }

    public RegistrationPage setInputDateOfBirth(String month, String year) {
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);
        $(".react-datepicker__day--030:not(.react-datepicker__day--outside-month)").click();
        return this;
    }

    public RegistrationPage chooseSubject(String subject) {
        $("div[class*='subjects-auto-complete__value']").click();
        $("input#subjectsInput").setValue(subject);
        $("div#react-select-2-option-0").click();
        return this;
    }

    public RegistrationPage clickCheckBoxHobbies() {
        Actions actions = new Actions(WebDriverRunner.getWebDriver());
        actions.moveToElement(checkBoxHobbies).click().build().perform();
        return this;
    }

    public RegistrationPage upLoadImageOnPage(String imagePath) {
        upLoadPictures.uploadFromClasspath(imagePath);
        return this;
    }

    public RegistrationPage setAddressInTextarea(String addressStreet) {
        address.setValue(addressStreet);
        return this;
    }

    public RegistrationPage chooseState() {
        stateSelect.scrollTo();
        stateSelect.click();
        stateName.click();
        return this;
    }

    public RegistrationPage chooseCity() {
        citySelect.click();
        cityName.click();
        return this;
    }

    public RegistrationPage clickButtonSubmit() {
        submitButton.click();
        return this;
    }

    //проверки
    public RegistrationPage assertSubmitTitleIsVisible() {
        Assertions.assertTrue(submitTitle.isDisplayed());
        return this;
    }

    public RegistrationPage assertTableAfterRegistrationHave(String value) {
        tableAfterRegistration.shouldHave(text(value));
        return this;
    }
}
