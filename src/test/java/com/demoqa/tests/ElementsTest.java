package com.demoqa.tests;

import com.demoqa.core.TestBase;
import com.demoqa.pages.HomePage;
import com.demoqa.pages.JsExecutor;
import com.demoqa.pages.SidePanel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ElementsTest extends TestBase {

    SidePanel sidePanel;

    @BeforeEach
    public void precondition(){
        new HomePage(driver).selectElements();
        sidePanel = new SidePanel(driver);
    }

    @Test
    public void jsExecutorTest(){
       sidePanel.selectTextBox();
       new JsExecutor(driver).enterPersonalData("Lee Adam","lee@gm.com")
               .clickOnSubmitButton()
               .getInnerText()
               .verifyUrl()
               .refreshPage()
               .navigateToNewTab("https://telranedu.web.app")
               .verifyNewPageFaveIconTitle()
               ;
    }
}
