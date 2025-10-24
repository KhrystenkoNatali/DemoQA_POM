package com.demoqa.core;

import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class BasePage {

    protected WebDriver driver;

    public static JavascriptExecutor js;
    public static SoftAssertions softly;
    public static Actions actions;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        js = (JavascriptExecutor) driver;
        softly = new SoftAssertions();
        actions = new Actions(driver);
    }

    public void scrollWithJS(int x, int y){
        js.executeScript("window.scrollBy(" + x +"," + y + ")");
    }

    public void clickWithJS(WebElement element, int x, int y){
        scrollWithJS(x,y);
        click(element);
    }

    public void typeWithJS(WebElement element,String text, int x, int y){
        scrollWithJS(x,y);
        type(element, text);
    }

    public void click(WebElement element){
        element.click();
    }

    public void type(WebElement element, String text){
        if(text != null){
            click(element);
            element.clear();
            element.sendKeys(text);
        }
    }

    public WebDriverWait getWait(int seconds) {
        return new WebDriverWait(driver, Duration.ofSeconds(seconds));
    }

    public boolean isAlertPresent(int seconds) {
        Alert alert = getWait(seconds)
                .until(ExpectedConditions.alertIsPresent());
        if (alert == null) {
            return false;
        } else {
            driver.switchTo().alert().accept();
            return true;
        }
    }

    public boolean isContainsText(String text, WebElement element) {
        return element.getText().contains(text);
    }

    public boolean shouldHaveText(WebElement element, String text, int time) {
        return getWait(time)
                .until(ExpectedConditions.textToBePresentInElement(element,text));
    }

    public void switchToNewTabWindow(int index) {
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(index));
    }

    public void hideAd(WebElement element) {
        js.executeScript("document.getElementById('" + element + "').style.display='none';");
    }

    public void hideFooter() {
        js.executeScript("document.querySelector('footer').style.display='none';");
    }

    public void waiOfElementVisibility(WebElement element, int time) {
        getWait(time).until(ExpectedConditions.visibilityOf(element));
    }

    public boolean isElementVisible(WebElement element) {
        try {
            element.isDisplayed();
            return true;
        } catch (NoAlertPresentException e) {
            e.getMessage();
            return false;
        }
    }

    public void scrollAndWaitOfElement(WebElement element, int time, int x, int y) {
        scrollWithJS(x, y);
        waiOfElementVisibility(element, time);
    }

    public String getValueAttribute(WebElement element, final String value) {
        return element.getDomAttribute(value);
    }

    public void clickWithRectangle(WebElement element) {
        Rectangle rectangle = element.getRect();

        int xOffset = rectangle.getWidth() / 4;
        int yOffSet = rectangle.getHeight() / 2;

        actions.moveToElement(element).perform();
        actions.moveByOffset(-xOffset,-yOffSet).click().perform();
    }

    public void pause(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void verifyLinks(String url) {

        try {
            URL linkUrl = new URL(url);
            //create URL connection and get response code
            HttpURLConnection connection = (HttpURLConnection) linkUrl.openConnection();
            connection.setConnectTimeout(5000);
            connection.connect();
            if (connection.getResponseCode()>=400) {
                // System.out.println(url + " - " + connection.getResponseMessage() + " is a BROKEN link");
                softly.fail(url + " - " + connection.getResponseMessage() + " is a BROKEN link");
            } else {
                // System.out.println(url + " - " + connection.getResponseMessage());
                softly.assertThat(url + " - " + connection.getResponseMessage());
            }
        } catch (Exception e) {
            System.out.println(url + " - " + e.getMessage() + " ERROR occurred");
        }
        softly.assertAll();
    }
}
