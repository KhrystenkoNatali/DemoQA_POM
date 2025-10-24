package com.demoqa.tests;

import com.demoqa.core.TestBase;
import com.demoqa.pages.HomePage;
import com.demoqa.pages.JsExecutor;
import com.demoqa.pages.SidePanel;
import com.demoqa.pages.elements.ButtonsPage;
import com.demoqa.pages.elements.LinksImagesPage;
import com.demoqa.pages.elements.TextBoxPage;
import com.demoqa.pages.elements.UploadPage;
import com.demoqa.utils.MyArgumentsProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.CsvFileSource;

public class ElementsTests extends TestBase {

    SidePanel sidePanel;
    ButtonsPage buttons;

    TextBoxPage textBox;
    UploadPage upload;

    LinksImagesPage linksImages;

    @BeforeEach
    public void precondition() {
        new HomePage(driver).selectElements();
        sidePanel = new SidePanel(driver);
        buttons = new ButtonsPage(driver);
        textBox = new TextBoxPage(driver);
        upload = new UploadPage(driver);
        linksImages = new LinksImagesPage(driver);
    }

    @Test
    public void jsExecutorTest() {
        sidePanel.selectTextBox();
        new JsExecutor(driver).enterPersonalData("Jamal Musiala","jamal@gm.com")
                .clickOnSubmitButton()
                .getInnerText()
                .verifyUrl()
                .refreshPage()
                .navigateToNewTab("https://telranedu.web.app")
                .verifyNewPageFaveIconTitle()
        ;
    }

    @Test
    @Tag("smoky")
    public void doubleClickTest() {
        sidePanel.selectButtons();
        buttons.doubleClick()
                .verifyDoubleClick("double click");
    }

    @Test
    public void rightClickTest() {
        sidePanel.selectButtons();
        buttons.rightClick()
                .verifyRightClick("right click");
    }

    @Test
    public void copyPastTest() {
        sidePanel.selectTextBox();
        textBox.copyPast("Friedrichstr. 12, Berlin")
                .clickOnSubmit()
                .verifyAddress();
    }

    @Test
    public void performKeyEventWithRobotTest() {
        sidePanel.selectUpload();
        upload.performKeyEventWithRobot()
                .verifyFilePath("C:\\fakepath\\D1.txt");
    }

    @Test
    public void performMouseEventWithRobotTest() {
        sidePanel.selectUpload();
        upload.preformMouseEvent()
                .verifyFilePath("C:\\fakepath\\D1.txt")
        ;
    }

    @Test
    public void getAllLinksTest() {
        sidePanel.selectLinksImages();
        linksImages.getAllLinks();
    }

    @Test
    public void checkBrokenLinksTest() {
        sidePanel.selectLinksImages();
        linksImages.checkBrokenLinks();
    }

    @Test
    public void checkBrokenImagesTest() {
        sidePanel.selectLinksImages();
        linksImages.checkBrokenImages();
    }

    @ParameterizedTest
    @ArgumentsSource(MyArgumentsProvider.class)
    public void parametrizedTest(String name, String email, String address) {
        sidePanel.selectTextBox();
        textBox.enterData(name,email,address)
                .clickOnSubmit()
                .verifyAddress();
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/data.csv")
    public void parametrizedWithCsvFileTest(String name, String email, String address) {
        sidePanel.selectTextBox();
        textBox.enterData(name,email,address)
                .clickOnSubmit()
                .verifyAddress();
    }
}
