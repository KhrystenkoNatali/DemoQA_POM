package com.demoqa.pages;

import com.demoqa.core.BasePage;
import com.demoqa.pages.alertsFrameWindows.AlertsPage;
import com.demoqa.pages.alertsFrameWindows.FramesPage;
import com.demoqa.pages.alertsFrameWindows.WindowsPage;
import com.demoqa.pages.bookStore.LoginPage;
import com.demoqa.pages.elements.ButtonsPage;
import com.demoqa.pages.elements.LinksImagesPage;
import com.demoqa.pages.elements.UploadPage;
import com.demoqa.pages.interactions.DroppablePage;
import com.demoqa.pages.widgets.MenuPage;
import com.demoqa.pages.widgets.SelectPage;
import com.demoqa.pages.widgets.SliderPage;
import com.demoqa.pages.widgets.ToolTipsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SidePanel extends BasePage {

    public SidePanel(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[.='Login']")
    WebElement login;

    public LoginPage selectLogin() {
        clickWithJS(login,0,1080);
        return new LoginPage(driver);
    }

    @FindBy(xpath = "//span[.='Text Box']")
    WebElement textBox;

    public JsExecutor selectTextBox() {
        click(textBox);
        return new JsExecutor(driver);
    }

    @FindBy(xpath = "//span[.='Alerts']")
    WebElement alerts;

    public AlertsPage selectAlerts() {
        clickWithJS(alerts, 0, 400);
        return new AlertsPage(driver);
    }

    @FindBy(xpath = "//span[.='Browser Windows']")
    WebElement browserWindows;

    public WindowsPage selectWindows() {
        clickWithJS(browserWindows,0,200);
        return new WindowsPage(driver);
    }

    @FindBy(xpath = "//span[.='Frames']")
    WebElement frames;

    public FramesPage selectFrame() {
        clickWithJS(frames,0,300);
        return new FramesPage(driver);
    }

    @FindBy(xpath = "//span[.='Nested Frames']")
    WebElement nestedFrames;

    public FramesPage selectNestedFrames() {
        clickWithJS(nestedFrames,0,400);
        return new FramesPage(driver);
    }

    @FindBy(xpath = "//span[.='Select Menu']")
    WebElement selectMenu;

    public SelectPage selectSelect() {
        clickWithJS(selectMenu,0,1500);
        return new SelectPage(driver);
    }

    @FindBy(xpath = "//span[.='Menu']")
    WebElement menu;

    public MenuPage clickOnMenu() {
        clickWithJS(menu,0,1500);
        return new MenuPage(driver);
    }

    @FindBy(xpath = "//span[.='Tool Tips']")
    WebElement toolTips;

    public ToolTipsPage selectToolTips() {
        clickWithJS(toolTips,0,1000);
        return new ToolTipsPage(driver);
    }

    @FindBy(xpath = "//span[.='Slider']")
    WebElement slider;

    public SliderPage selectSlider() {
        clickWithJS(slider,0,600);
        return new SliderPage(driver);
    }

    @FindBy(xpath = "//span[.='Droppable']")
    WebElement droppable;

    public DroppablePage selectDroppable() {
        clickWithJS(droppable,0,700);
        return new DroppablePage(driver);
    }

    @FindBy(xpath = "//span[.='Buttons']")
    WebElement buttons;

    public ButtonsPage selectButtons() {
        clickWithJS(buttons,0,400);
        return new ButtonsPage(driver);
    }

    @FindBy(xpath = "//span[.='Upload and Download']")
    WebElement upload;

    public UploadPage selectUpload() {
        clickWithJS(upload,0,400);
        return new UploadPage(driver);
    }

    @FindBy(xpath = "//span[.='Practice Form']")
    WebElement practiceForm;

    public PracticeFormPage selectPracticeForm() {
        click(practiceForm);
        return new PracticeFormPage(driver);
    }

    @FindBy(xpath = "//span[.='Broken Links - Images']")
    WebElement linksImages;

    public LinksImagesPage selectLinksImages() {
        clickWithJS(linksImages,0,600);
        return new LinksImagesPage(driver);
    }
}
