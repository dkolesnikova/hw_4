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

    private SelenideElement firstNamePath = $x("//input[@id='firstName']");
    private SelenideElement secondNamePath = $x("//input[@id='lastName']");
    private SelenideElement emailPath = $x("//input[@id='userEmail']");
    private SelenideElement numberPath = $x("//input[@id='userNumber']");
    private SelenideElement subjectPath = $x("//input[@id='subjectsInput']");
    private SelenideElement pictureInput =    $x("//input[@id='uploadPicture']");
    private SelenideElement addressPath = $x("//textarea[@id='currentAddress']");
    private SelenideElement statePath = $x("//input[@id='react-select-3-input']");
    private SelenideElement cityPath = $x("//input[@id='react-select-4-input']");
    private SelenideElement saveButtonPath = $x("//div[contains(@class,'text-right col-md-2 col-sm-12')]");
//    private SelenideElement expectedName = $x("//*[contains(text(),'Student Name')]//following-sibling::td");
//    private SelenideElement expectedEmail = $x("//*[contains(text(),'Student Email')]//following-sibling::td");
//    private SelenideElement expectedGender = $x("//*[contains(text(),'Gender')]//following-sibling::td");
//    private SelenideElement expectedNumber = $x("//*[contains(text(),'Mobile')]//following-sibling::td");
//    private SelenideElement expectedSubject = $x("//*[contains(text(),'Subjects')]//following-sibling::td");
//    private SelenideElement expectedHobbies = $x("//*[contains(text(),'Hobbies')]//following-sibling::td");
//    private SelenideElement expectedPicture = $x("//*[contains(text(),'Picture')]//following-sibling::td");
//    private SelenideElement expectedAddress = $x("//*[contains(text(),'Address')]//following-sibling::td");
//    private SelenideElement expectedStateAndCity = $x("//*[contains(text(),'State and City')]//following-sibling::td");
//    private SelenideElement expectedBirthDate = $x("//*[contains(text(),'Date of Birth')]//following-sibling::td");


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
        $("#dateOfBirthInput").click();
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
        $x("//label[contains(text(),'" + hobbie + "')]").click();
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

//    public RegistrationPage assertEmail(String mail) {
//        expectedEmail.shouldHave(text(mail));
//        return this;
//    }
//
//    public RegistrationPage assertGender(String gender) {
//        expectedGender.shouldHave(text(gender));
//        return this;
//    }
//
//    public RegistrationPage assertNumber(String number) {
//        expectedNumber.shouldHave(text(number));
//        return this;
//    }
//
//    public RegistrationPage assertBirthDate(String birthDate) {
//        expectedBirthDate.shouldHave(text(birthDate));
//        return this;
//    }
//
//    public RegistrationPage assertSubject(String subject) {
//        expectedSubject.shouldHave(text(subject));
//        return this;
//    }
//
//    public RegistrationPage assertHobbies(String hobbies) {
//        expectedHobbies.shouldHave(text(hobbies));
//        return this;
//    }
//
//    public RegistrationPage assertPicture(String picture) {
//        expectedPicture.shouldHave(text(picture));
//        return this;
//    }
//
//    public RegistrationPage assertAddress(String address) {
//        expectedAddress.shouldHave(text(address));
//        return this;
//    }
//
//    public RegistrationPage assertStateAndCity(String stateAndCity) {
//        expectedStateAndCity.shouldHave(text(stateAndCity));
//        return this;
    }

