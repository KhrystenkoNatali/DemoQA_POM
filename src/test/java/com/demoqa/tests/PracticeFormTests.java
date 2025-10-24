package com.demoqa.tests;

import com.demoqa.core.TestBase;
import com.demoqa.pages.HomePage;
import com.demoqa.pages.PracticeFormPage;
import com.demoqa.pages.SidePanel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

public class PracticeFormTests extends TestBase {

    PracticeFormPage practiceForm;

    @BeforeEach
    public void precondition() {
        practiceForm = new PracticeFormPage(driver);
        new HomePage(driver).selectForms();
        new SidePanel(driver).selectPracticeForm();
    }

    @Test
    public void createStudentAccountPositiveTest() {
        practiceForm.enterPersonalData("Robert","Wide","wide@gm.com","1234567890")
                .selectGender("Male")
                .typeOfDate("16 Aug 1987")
                .addSubject(new String[]{"Maths","Chemistry","English"})
                .selectHobby(new String[]{"Sports","Reading"})
                .uploadFile("C:/Tools/1.jpg")
                .inputState("NCR")
                .inputCity("Delhi")
                .submitForm()
                .verifySuccess("Thanks for submitting the form")
        ;
    }

    @RepeatedTest(value = 4,name = "{displayName} {currentRepetition}/{totalRepetitions}")
    public void createStudentAccountWithSelectDatePositiveTest() {
        practiceForm.enterPersonalData("Robert","Wide","wide@gm.com","1234567890")
                .selectGender("Male")
                .selectDate("August","1987","16")
                .submitForm()
                .verifySuccess("Thanks for submitting the form")
        ;
    }
}
