package com.demoqa.tests;

import com.demoqa.core.TestBase;
import com.demoqa.pages.HomePage;
import com.demoqa.pages.SidePanel;
import com.demoqa.pages.widgets.MenuPage;
import com.demoqa.pages.widgets.SelectPage;
import com.demoqa.pages.widgets.SliderPage;
import com.demoqa.pages.widgets.ToolTipsPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class WidgetsTests extends TestBase {

    SidePanel sidePanel;
    SelectPage select;

    @BeforeEach
    public void precondition() {
        new HomePage(driver).selectWidgets();
        sidePanel = new SidePanel(driver);
        select = new SelectPage(driver);
    }

    @Test
    @Tag("smoky")
    public void oldStyleSelectMenuTest() {
        sidePanel.selectSelect();
        select.oldStyleSelect("Yellow")
                .verifyColor();
    }

    @Test
    public void multiSelectTest() {
        sidePanel.selectSelect();
        select.multiSelect(new String[]{"Green","Red"})
                .verifyMultiSelect(new String[]{"Green","Red"});
    }

    @Test
    public void standardMultiSelectTest() {
        sidePanel.selectSelect();
        select
                //.verifySelectedCarByValue("opel","rgba(25, 103, 210, 1)");
                .verifySelectedCarByHexFormat("opel","#1967d2");
    }

    @Test
    public void hoverMouseOnMenuTest() {
        sidePanel.clickOnMenu();
        new MenuPage(driver).hoverMouseOnMenu()
                .verifySubMenu();
    }

    @Test
    public void toolTipsTest() {
        sidePanel.selectToolTips();
        new ToolTipsPage(driver).hoverMouseOnToolTips()
                .verifyToolTips("buttonToolTip");
    }

    @Test
    public void sliderTest() {
        sidePanel.selectSlider();
        new SliderPage(driver).moveSliderInHorizontalDirection()
                .verifySliderValue("0");
    }
}
