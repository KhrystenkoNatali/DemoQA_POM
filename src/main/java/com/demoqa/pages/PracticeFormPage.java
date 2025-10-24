package com.demoqa.pages;

import com.demoqa.core.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class PracticeFormPage extends BasePage {

    public PracticeFormPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "firstName")
    WebElement firstNameInput;
    @FindBy(id = "lastName")
    WebElement lastNameInput;
    @FindBy(id = "userEmail")
    WebElement userEmailInput;
    @FindBy(id = "userNumber")
    WebElement userNumber;

    public PracticeFormPage enterPersonalData(String firstName, String lastName, String email, String phone) {
        scrollWithJS(0, 300);
        type(firstNameInput, firstName);
        type(lastNameInput, lastName);
        type(userEmailInput, email);
        type(userNumber, phone);
        return this;
    }

    @FindBy(css = "[for='gender-radio-1']")
    WebElement male;
    @FindBy(css = "[for='gender-radio-2']")
    WebElement female;
    @FindBy(css = "[for='gender-radio-3']")
    WebElement other;

    public PracticeFormPage selectGender(String gender) {
        if (gender.equals("Male")) {
            click(male);
        } else if (gender.equals("Female")) {
            click(female);
        } else {
            click(other);
        }
        return this;
    }

    @FindBy(id = "dateOfBirthInput")
    WebElement dateOfBirthInput;

    public PracticeFormPage typeOfDate(String date) {
        click(dateOfBirthInput);

        String os = System.getProperty("os.name");
        System.out.println("My OS is " + os);

        if (os.startsWith("Mas")) {
            dateOfBirthInput.sendKeys(Keys.COMMAND, "a");
        } else {
            dateOfBirthInput.sendKeys(Keys.CONTROL, "a");
        }

        dateOfBirthInput.sendKeys(date);
        dateOfBirthInput.sendKeys(Keys.ENTER);
        return this;
    }

    @FindBy(id = "subjectsInput")
    WebElement subjectsInput;

    public PracticeFormPage addSubject(String[] subjects) {
        for (int i = 0; i < subjects.length; i++) {
            if (subjects[i] != null) {
                typeWithJS(subjectsInput, subjects[i], 0, 200);
                subjectsInput.sendKeys(Keys.ENTER);
            }
        }
        return this;
    }

    @FindBy(css = "[for='hobbies-checkbox-1']")
    WebElement sports;
    @FindBy(css = "[for='hobbies-checkbox-2']")
    WebElement reading;
    @FindBy(css = "[for='hobbies-checkbox-3']")
    WebElement music;

    public PracticeFormPage selectHobby(String[] hobbies) {
        for (int i = 0; i < hobbies.length; i++) {
            if (hobbies[i].equals("Sports")) {
                click(sports);
            }
            if (hobbies[i].equals("Reading")) {
                click(reading);
            }
            if (hobbies[i].equals("Music")) {
                click(music);
            }
        }
        return this;
    }

    @FindBy(id = "uploadPicture")
    WebElement uploadPicture;

    public PracticeFormPage uploadFile(String path) {
        uploadPicture.sendKeys(path);
        return this;
    }

    @FindBy(id = "react-select-3-input")
    WebElement stateInput;

    public PracticeFormPage inputState(String state) {
        stateInput.sendKeys(state);
        stateInput.sendKeys(Keys.ENTER);
        return this;
    }

    @FindBy(id = "react-select-4-input")
    WebElement cityInput;

    public PracticeFormPage inputCity(String city) {
        cityInput.sendKeys(city);
        cityInput.sendKeys(Keys.ENTER);
        return this;
    }

    @FindBy(id = "submit")
    WebElement submit;

    public PracticeFormPage submitForm() {
        clickWithJS(submit,0,200);
        return this;
    }

    @FindBy(id = "example-modal-sizes-title-lg")
    WebElement modalTitle;

    public PracticeFormPage verifySuccess(String successTitle) {
        Assertions.assertTrue(shouldHaveText(modalTitle,successTitle,5));
        return this;
    }

    @FindBy(css = ".react-datepicker__month-select")
    WebElement selectMonth;
    @FindBy(css = ".react-datepicker__year-select")
    WebElement selectYear;

    public PracticeFormPage selectDate(String month, String year, String day) {
        click(dateOfBirthInput);

        new Select(selectMonth).selectByVisibleText(month);
        new Select(selectYear).selectByVisibleText(year);
        driver.findElement(By.xpath("//*[@class='react-datepicker__month']//div[.='"+ day + "']")).click();
        return this;
    }
}
