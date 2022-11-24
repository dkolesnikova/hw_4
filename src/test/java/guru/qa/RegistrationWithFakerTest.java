package guru.qa;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

import static com.codeborne.selenide.Selenide.open;
import static com.google.gson.internal.bind.util.ISO8601Utils.format;

public class RegistrationWithFakerTest extends TestBase{


    @Test
    void checkTheFormCanBeFilledInWithAllFields() {
        Faker faker = new Faker();


        //Arrange
        String firstName = faker.name().firstName();
        String secondName = faker.name().lastName();
        String expectedName = firstName+ " "+ secondName;
        String expectedMail = faker.internet().emailAddress();
        String expectedGender = "Male";
        String expectedNumber = faker.phoneNumber().subscriberNumber(10);
        Integer expectedBirthDay = faker.number().numberBetween(1,30);
        String expectedBirthDay1 = expectedBirthDay.toString();
        Integer expectedBirthMonth = faker.number().numberBetween(1,12);
        String expectedBirthMonth1 = expectedBirthMonth.toString();
        Integer expectedBirthYear = faker.number().numberBetween(1900,2021);
        String expectedBirthYear1 = expectedBirthYear.toString();
        String expectedBirthDate = expectedBirthDay1 + " "+ expectedBirthMonth1 + "," + expectedBirthYear1;
        String expectedAddress = faker.address().fullAddress();
        String expectedSubject = "English";
        String expectedSports = "Sports";
        String expectedReading = "Reading";
        String expectedMusic = "Music";
        String expectedPicture = "images.jfif";
        String expectedState = "NCR";
        String expectedCity = "Delhi";
        String expectedStateAndCity = expectedState+ " " +expectedCity;
        String studentName = "Student Name";
        String gender = "Gender";
        String studentEmail = "Student Email";
        String mobile = "Mobile";
        String subjects = "Subjects";
        String hobbies = "Hobbies";
        String picture = "Picture";
        String address = "Address";
        String stateAndCity = "State and City";
        String dateOfBirth = "Date of Birth";

        //Act
        open("https://demoqa.com/automation-practice-form");
        registrationPage
                .setFirstName(firstName)
                .setSecondName(secondName)
                .setEmail(expectedMail)
                .setGender(expectedGender)
                .setNumber(expectedNumber)
                .setBirthDate(expectedBirthDay1, expectedBirthMonth1, expectedBirthYear1)
                .setSubject(expectedSubject)
                .pressEnterSubject()
                .clickToHobbie(expectedSports)
                .clickToHobbie(expectedReading)
                .clickToHobbie(expectedMusic)
                .setPicture()
                .setAddress(expectedAddress)
                .setState(expectedState)
                .pressEnterState()
                .setCity(expectedCity)
                .pressEnterCity()
                .clickToSaveButton()
                .assertValue(studentName,expectedName)
                .assertValue(gender,expectedGender)
                .assertValue(studentEmail,expectedMail)
                .assertValue(mobile,expectedNumber)
                .assertValue(address,expectedAddress)
                .assertValue(subjects,expectedSubject)
                .assertValue(hobbies,expectedSports)
                .assertValue(hobbies,expectedReading)
                .assertValue(hobbies,expectedMusic)
                .assertValue(picture,expectedPicture)
                .assertValue(stateAndCity,expectedStateAndCity)
                .assertValue(dateOfBirth, expectedBirthDate);
    }
}

