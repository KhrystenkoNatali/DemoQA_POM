package com.demoqa.pages.alertsFrameWindows;

import com.demoqa.core.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class FramesPage extends BasePage {

    public FramesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "iframe")
    List<WebElement> iframes;

    public FramesPage returnListOfIframes() {
        //by web list of web elements
        System.out.println("The total number of iframes is " + iframes.size());

        //by executing js
        Integer numberOfIframes = Integer.parseInt(js.executeScript("return window.length").toString());
        System.out.println("The total number of iframes is " + numberOfIframes);
        return this;
    }

    public FramesPage switchToIframeByIndex(int index) {
        driver.switchTo().frame(index);
        return this;
    }

    @FindBy(id = "sampleHeading")
    WebElement sampleHeading;

    public FramesPage verifyIframeByTitle(String title) {
        Assertions.assertTrue(isContainsText(title,sampleHeading));
        return this;
    }

    @FindBy(id = "frame1")
    WebElement frame1;

    public FramesPage switchToIframeById() {
        driver.switchTo().frame(frame1);
        return this;
    }

    public FramesPage switchToMainPage() {
        driver.switchTo().defaultContent();
        return this;
    }

    @FindBy(css = ".text-center")
    WebElement title;

    public FramesPage verifyMainPageTitle(String text) {
        Assertions.assertTrue(isContainsText(text,title));
        return this;
    }

    @FindBy(css = "body")
    WebElement body;

    public FramesPage handleNestedIframes() {
        //switch to parent iframe by ID
        driver.switchTo().frame(frame1);
        //assert parent by text
        softly.assertThat(isContainsText("Parent frame",body));
        //assert number of iframes in parent iframe
        softly.assertThat(1).isEqualTo(iframes.size());
        //switch to child iframe
        driver.switchTo().frame(0);
        //assert child by text
        softly.assertThat(isContainsText("Child Iframe",body));
        //switch to parent
        driver.switchTo().parentFrame();
        //assert parent by text
        softly.assertThat(isContainsText("Parent frame",body));
        softly.assertAll();
        return this;
    }
}

// css = [id*='iframe']
