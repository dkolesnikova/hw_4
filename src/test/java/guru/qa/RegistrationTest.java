package guru.qa;

import org.junit.jupiter.api.*;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationTest extends TestBase{


    @Test
    void checkTheFormCanBeFilledInWithAllFields() {
        //Arrange
        String firstName = "Ilya";
        String secondName = "Ivanov";
        String expectedName = firstName+ " "+ secondName;
        String expectedMail = "mail@mail.ru";
        String expectedGender = "Male";
        String expectedNumber = "8800555353";
        String expectedBirthDate = "08 January,2012";
        String expectedAddress = "Smolensk";
        String expectedSubject = "English";
        String expectedHobbie1 = "Sports";
        String expectedHobbie2 = "Reading";
        String expectedHobbie3 = "Music";
        String expectedPicture = "images.jfif";
        String expectedState = "NCR";
        String expectedCity = "Delhi";
        String expectedStateAndCity = expectedState+ " " +expectedCity;
        String studentName = "Student name";
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
                .setBirthDate("08", "January", "2012" )
                .setSubject(expectedSubject)
                .pressEnterSubject()
                .clickToHobbie(expectedHobbie1)
                .clickToHobbie(expectedHobbie2)
                .clickToHobbie(expectedHobbie3)
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
                .assertValue(hobbies,expectedHobbie1)
                .assertValue(hobbies,expectedHobbie2)
                .assertValue(hobbies,expectedHobbie3)
                .assertValue(picture,expectedPicture)
                .assertValue(stateAndCity,expectedStateAndCity)
                .assertValue(dateOfBirth,expectedBirthDate);




    }
}

