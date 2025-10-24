package com.demoqa.pages.interactions;

import com.demoqa.core.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DroppablePage extends BasePage{

    public DroppablePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "draggable")
    WebElement dragMe;
    @FindBy(id = "droppable")
    WebElement dropHere;

    public DroppablePage actionDragMe() {
        scrollAndWaitOfElement(dragMe,5,0,200);

        actions.dragAndDrop(dragMe,dropHere).perform();
        return this;
    }

    public DroppablePage verifyDropped(String text) {
        Assertions.assertTrue(shouldHaveText(dropHere,text,5));
        return this;
    }

    public DroppablePage actionDragMeBy() {
        scrollAndWaitOfElement(dragMe,5,0,200);

        //get coordinates of 'draggable' and print
        int xOffset1 = dragMe.getLocation().getX();
        int yOffset1 = dragMe.getLocation().getY();
        System.out.println("xOffset1 ->" + xOffset1 + "***" + "yOffset1 ->" + yOffset1);

        //get coordinates of 'droppable' and print
        int xOffset = dragMe.getLocation().getX();
        int yOffset = dragMe.getLocation().getY();
        System.out.println("xOffset ->" + xOffset + "***" + "yOffset ->" + yOffset);

        //find difference
        xOffset = xOffset1 - xOffset1;
        yOffset = yOffset1 - yOffset1;

        actions.dragAndDropBy(dragMe,xOffset,yOffset).perform();
        return this;
    }
}
