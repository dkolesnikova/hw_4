package pages;

import com.codeborne.selenide.ClickMethod;
import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class RegistrationPage {
    CalendarComponent calendarComponent = new CalendarComponent();

    private SelenideElement firstNamePath = $("#firstName");
    private SelenideElement secondNamePath = $("#lastName");
    private SelenideElement emailPath = $("#userEmail");
    private SelenideElement dateOdBirthInput = $("#dateOfBirthInput");
    private SelenideElement numberPath = $("#userNumber");
    private SelenideElement subjectPath = $("#subjectsInput");
    private SelenideElement pictureInput =    $("#uploadPicture");
    private SelenideElement addressPath = $("#currentAddress");
    private SelenideElement statePath = $("#react-select-3-input");
    private SelenideElement cityPath = $("#react-select-4-input");
    private SelenideElement saveButtonPath = $("#text-right col-md-2 col-sm-12");


    public RegistrationPage setFirstName(String firstName) {
        firstNamePath.setValue(firstName);
        return this;
    }

    public RegistrationPage setSecondName(String secondName) {
        secondNamePath.setValue(secondName);
        return this;
    }

    public RegistrationPage setEmail(String email) {
        emailPath.setValue(email);
        return this;
    }

    public RegistrationPage setGender(String gender) {
        $x("//label[contains(text(),'"+ gender +"')]").click();
        return this;
    }

    public RegistrationPage setNumber(String number) {
        numberPath.setValue(number);
        return this;
    }
    public RegistrationPage setBirthDate(String day, String month, String year) {
        dateOdBirthInput.click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    public RegistrationPage setSubject(String subject) {
        subjectPath.setValue(subject);
        return this;
    }

    public RegistrationPage pressEnterSubject() {
        subjectPath.pressEnter();
        return this;
    }

    public RegistrationPage clickToHobbie(String hobbie) {
        $("#hobbiesWrapper").$(byText(hobbie)).click();
        return this;
    }

    public RegistrationPage setPicture() {
        pictureInput.uploadFile(new File("src/test/resources/images.jfif"));
        return this;

    }
    public RegistrationPage setAddress(String address) {
        addressPath.setValue(address);
        return this;
    }

    public RegistrationPage setState(String state) {
        statePath.setValue(state);
        return this;
    }

    public RegistrationPage pressEnterState() {
        statePath.pressEnter();
        return this;
    }

    public RegistrationPage setCity(String city) {
        cityPath.setValue(city);
        return this;
    }

    public RegistrationPage pressEnterCity() {
        cityPath.pressEnter();
        return this;
    }

    public RegistrationPage clickToSaveButton() {
        saveButtonPath.click();
        return this;
    }

//Assert

    public RegistrationPage assertValue(String path, String value) {
        $x("//*[contains(text(),'"+ path +"')]//following-sibling::td").shouldHave(text(value));
        return this;
    }
}

