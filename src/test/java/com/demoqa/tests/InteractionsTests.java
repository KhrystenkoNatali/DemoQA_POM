package com.demoqa.tests;

import com.demoqa.core.TestBase;
import com.demoqa.pages.HomePage;
import com.demoqa.pages.SidePanel;
import com.demoqa.pages.interactions.DroppablePage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class InteractionsTests  extends TestBase {

    SidePanel sidePanel;
    DroppablePage droppable;

    @BeforeEach
    public void precondition() {
        new HomePage(driver).selectInteractions();
        sidePanel = new SidePanel(driver);
        droppable = new DroppablePage(driver);
    }

    @Test
    @Tag("smoky")
    public void actionDragMeTest() {
        sidePanel.selectDroppable();
        droppable.actionDragMe()
                .verifyDropped("Dropped!");
    }

    @Test
    public void actionDragMeByTest() {
        sidePanel.selectDroppable();
        droppable.actionDragMeBy()
        // .verifyDropped("Dropped!")
        ;
    }
}
