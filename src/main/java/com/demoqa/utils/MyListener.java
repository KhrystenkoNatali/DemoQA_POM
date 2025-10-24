package com.demoqa.utils;

import com.google.common.io.Files;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.events.WebDriverListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Random;

public class MyListener implements WebDriverListener {

    Logger logger = LoggerFactory.getLogger(MyListener.class);

    private final WebDriver driver;

    public MyListener(WebDriver driver) {
        this.driver = driver;
    }

    @Override
    public void onError(Object target, Method method, Object[] args, InvocationTargetException e) {
        logger.error("The test has a problem!!!");
        logger.info("========================================");
        logger.error("Method -> {}", method.getName());
        logger.info("========================================");
        logger.error("Object target -> {}", target);
        logger.info("========================================");
        logger.error("Target exception -> {}", e.getCause());
        logger.info("========================================");

        //WebDriver driver = (ChromeDriver) target;

        int i = new Random().nextInt(1000);
        String link = "screenshots/screen_" + i + ".png";
        logger.info("Screen with error --> {}",link);

        File tmp = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        try {
            Files.copy(tmp,new File(link));
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void beforeGet(WebDriver driver, String url) {
        logger.info("We will open web site {}",url);
    }

    @Override
    public void afterGetText(WebElement element, String result) {
        logger.info("{}",element.getText());
    }

    @Override
    public void afterPerform(WebDriver driver, Collection<Sequence> actions) {
        logger.info("{}",actions);
    }

    @Override
    public void afterClick(WebElement element) {
        logger.info("We clicked on {}",element);
    }

    @Override
    public void afterSendKeys(WebElement element, CharSequence... keysToSend) {
        logger.info("We enter to {}",element);
    }
}
