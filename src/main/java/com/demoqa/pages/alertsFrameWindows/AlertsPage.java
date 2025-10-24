package com.demoqa.pages.alertsFrameWindows;

import com.demoqa.core.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AlertsPage extends BasePage {

    public AlertsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "timerAlertButton")
    WebElement timerAlertButton;

    public AlertsPage verifyAlertWithTimer() {
        clickWithJS(timerAlertButton,0,400);
        Assertions.assertTrue(isAlertPresent(5));
        return this;
    }

    @FindBy(id = "confirmButton")
    WebElement confirmButton;

    public AlertsPage clickOnConfirmButton() {
        clickWithJS(confirmButton,0,540);
        return this;
    }

    public AlertsPage selectResult(String result) {
        if (result != null && result.equals("Ok")) {
            driver.switchTo().alert().accept();
        } else if (result != null && result.equals("Cancel")) {
            driver.switchTo().alert().dismiss();
        }
        return this;
    }

    @FindBy(id = "confirmResult")
    WebElement confirmResult;

    public AlertsPage verifyResult(String text) {
        Assertions.assertTrue(isContainsText(text, confirmResult));
        return this;
    }

    @FindBy(id = "promtButton")
    WebElement promtButton;

    public AlertsPage clickOnPromptButton() {
        clickWithJS(promtButton,0,300);
        return this;
    }

    public AlertsPage sendMessageToAlert(String text) {
        if (text != null) {
            driver.switchTo().alert().sendKeys(text);
            driver.switchTo().alert().accept();
        }
        return this;
    }

    @FindBy(id = "promptResult")
    WebElement promptResult;

    public AlertsPage verifyMessage(String text) {
        Assertions.assertTrue(isContainsText(text,promptResult));
        return this;
    }
}
