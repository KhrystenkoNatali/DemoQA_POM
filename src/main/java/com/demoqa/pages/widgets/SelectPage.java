package com.demoqa.pages.widgets;

import com.demoqa.core.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class SelectPage extends BasePage {

    public SelectPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "oldSelectMenu")
    WebElement oldSelectMenu;

    public SelectPage oldStyleSelect(String color) {

        new Select(oldSelectMenu).selectByVisibleText(color);
        return this;
    }

    public SelectPage verifyColor() {
        String firstSelectedOption = new Select(oldSelectMenu).getFirstSelectedOption().getText();
        Assertions.assertTrue(shouldHaveText(oldSelectMenu,firstSelectedOption,5));
        return this;
    }

    @FindBy(id = "react-select-4-input")
    WebElement selectInput;

    @FindBy(css = "html")
    WebElement space;

    public SelectPage multiSelect(String[] colors) {
        for (String text: colors) {
            selectInput.sendKeys(text);
            selectInput.sendKeys(Keys.ENTER);
        }
        click(space);
        return this;
    }

    public SelectPage verifyMultiSelect(String[] colors) {
        for (String text: colors) {
            WebElement element = driver.findElement(By.xpath("//*[.='" + text + "']"));
            softly.assertThat(isContainsText(text,element));
        }
        softly.assertAll();
        return this;
    }

    public SelectPage verifySelectedCarByValue(String car, String color) {
        WebElement selectedCar = driver.findElement(By.cssSelector("[value='" + car + "']"));
        click(selectedCar);
        //  System.out.println(selectedCar.getCssValue("background-color"));
        Assertions.assertTrue(selectedCar.getCssValue("background-color").contains(color));
        return this;
    }

    public SelectPage verifySelectedCarByHexFormat(String car, String color) {
        WebElement selectedCar = driver.findElement(By.cssSelector("[value='" + car + "']"));
        click(selectedCar);
        String rgbFormat = selectedCar.getCssValue("background-color");
        String hexFormat = Color.fromString(rgbFormat).asHex();
        // System.out.println(hexFormat);
        Assertions.assertTrue(hexFormat.contains(color));
        return this;
    }
}
