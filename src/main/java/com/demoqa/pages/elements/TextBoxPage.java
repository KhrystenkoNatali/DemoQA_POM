package com.demoqa.pages.elements;

import com.demoqa.core.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TextBoxPage extends BasePage {

    public TextBoxPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "currentAddress")
    WebElement currentAddress;

    public TextBoxPage copyPast(String address) {
        scrollAndWaitOfElement(currentAddress,5,0,300);
        //enter address to field current address
        type(currentAddress,address);
        //select current address
        actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
        //copy current address
        actions.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).perform();
        //press TAB to switch focus to permanent address
        actions.sendKeys(Keys.TAB).perform();
        //past current address to permanent address
        actions.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform();
        return this;
    }

    @FindBy(id = "submit")
    WebElement submit;

    public TextBoxPage clickOnSubmit() {
        click(submit);
        return this;
    }

    @FindBy(css = "p#currentAddress")
    WebElement currentAddressResult;
    @FindBy(css = "p#permanentAddress")
    WebElement permanentAddressResult;

    public TextBoxPage verifyAddress() {
        String[] current = currentAddressResult.getText().split(":");
        String[] permanent = permanentAddressResult.getText().split(":");
        Assertions.assertEquals(current[1],permanent[1]);
        return this;
    }

    @FindBy(id = "userName")
    WebElement userName;
    @FindBy(id = "userEmail")
    WebElement userEmail;
    @FindBy(id = "permanentAddress")
    WebElement permanentAddress;


    public TextBoxPage enterData(String name, String email, String address) {
        typeWithJS(userName,name,0,600);
        type(userEmail,email);
        type(currentAddress,address);
        type(permanentAddress,address);
        return this;
    }
}
