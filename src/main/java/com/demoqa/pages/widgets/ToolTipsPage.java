package com.demoqa.pages.widgets;

import com.demoqa.core.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ToolTipsPage extends BasePage {

    public ToolTipsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "toolTipButton")
    WebElement toolTipButton;

    @FindBy(css = "[aria-describedby='buttonToolTip']")
    WebElement toolTip;

    public ToolTipsPage hoverMouseOnToolTips() {
        scrollAndWaitOfElement(toolTipButton,5,0,100);

        actions.moveToElement(toolTipButton).perform();

        waiOfElementVisibility(toolTip,10);
        return this;
    }

    public ToolTipsPage verifyToolTips(String value) {
        Assertions.assertEquals(value, getValueAttribute(toolTipButton, "aria-describedby"));
        return this;
    }
}
