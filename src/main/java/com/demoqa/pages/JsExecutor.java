package com.demoqa.pages;

import com.demoqa.core.BasePage;
import org.openqa.selenium.WebDriver;

public class JsExecutor extends BasePage {

    public JsExecutor(WebDriver driver) {
        super(driver);
    }

    public JsExecutor enterPersonalData(String name, String email) {
        js.executeScript("document.getElementById('userName').value='" + name +"';" );
        js.executeScript("document.getElementById('userName').style.border='3px solid green';" );
        js.executeScript("document.getElementById('userEmail').value='" + email +"';" );
        js.executeScript("document.getElementById('userEmail').style.border='3px solid red';" );
        return this;
    }

    public JsExecutor clickOnSubmitButton() {
        js.executeScript("document.querySelector('#submit').click();");
        js.executeScript("document.querySelector('#submit').style.backgroundColor='red';");
        return this;
    }

    public JsExecutor getInnerText() {
        String innerText = js.executeScript("return document.documentElement.innerText;").toString();
        System.out.println(innerText);
        System.out.println("======================");
        return this;
    }

    public JsExecutor verifyUrl() {
        String url = js.executeScript("return document.URL;").toString();
        System.out.println("URL = " + url);
        return this;
    }

    public JsExecutor refreshPage() {
        js.executeScript("history.go(0);");
        return this;
    }

    public JsExecutor navigateToNewTab(String url) {
        js.executeScript("window.location='" + url + "';");
        return this;
    }

    public JsExecutor verifyNewPageFaveIconTitle() {
        String faveIconTitle = js.executeScript("return document.title;").toString();
        System.out.println("Fave icon title -> " + faveIconTitle);
        return this;
    }
}
