package com.demoqa.core;

import com.demoqa.utils.MyListener;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;

import java.time.Duration;

public class ApplicationManager {

    String browser;
    protected WebDriver driver;

    public ApplicationManager(String browser) {
        this.browser = browser;
    }

    public WebDriver startTest() {
        WebDriverManager.chromedriver().setup();
        WebDriverManager.edgedriver().setup();
        WebDriverManager.firefoxdriver().setup();
        switch (browser){
            case "chrome" -> driver = new ChromeDriver();
            case "edge" -> driver = new EdgeDriver();
            case "firefox" -> driver = new FirefoxDriver();
        }


        WebDriverListener listener = new MyListener(driver);
        driver = new EventFiringDecorator<>(listener).decorate(driver);

        driver.get("https://demoqa.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return driver;
    }

    public void stopTest() {
        driver.quit();
    }
}
