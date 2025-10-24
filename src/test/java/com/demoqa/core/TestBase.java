package com.demoqa.core;

import com.demoqa.utils.MyWatcher;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;

@ExtendWith(MyWatcher.class)

public class TestBase {

    protected WebDriver driver;

    protected ApplicationManager app = new ApplicationManager(System
            .getProperty("browser","chrome"));

    @BeforeEach
    public void init() {
        driver = app.startTest();
    }

    @AfterEach
    public void tearDown() {
        app.stopTest();
    }
}
