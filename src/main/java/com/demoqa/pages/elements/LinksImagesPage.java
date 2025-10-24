package com.demoqa.pages.elements;

import com.demoqa.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Iterator;
import java.util.List;

public class LinksImagesPage extends BasePage {

    public LinksImagesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "a")
    List<WebElement> allLinks;

    public LinksImagesPage getAllLinks() {
        System.out.println("Total links on th page: " + allLinks.size());

        String url = "";
        Iterator<WebElement> iterator = allLinks.iterator();
        while (iterator.hasNext()) {
            url = iterator.next().getText();
            System.out.println(url);
            System.out.println("*************************************************");
        }
        return this;
    }

    public LinksImagesPage checkBrokenLinks() {
        for (int i = 0; i < allLinks.size(); i++) {
            WebElement link = allLinks.get(i);
            String url = link.getDomAttribute("href");
            verifyLinks(url);
        }
        return this;
    }

    @FindBy(css = "img")
    List<WebElement> images;

    public LinksImagesPage checkBrokenImages() {
        System.out.println("Total images on the page: " + images.size());

        for (int i = 0; i < images.size(); i++) {
            WebElement image = images.get(i);
            String imageUrl = image.getAttribute("src");
            verifyLinks(imageUrl);

            try {
                //verify display image using JavaScriptExecutor
                boolean imageDisplayed;
                imageDisplayed = (Boolean) js.executeScript
                        ("return (typeof arguments[0].naturalWidth!=undefined&&arguments[0].naturalWidth>0)",image);
                if (imageDisplayed) {
//                    System.out.println("DISPLAY - OK!");
//                    System.out.println("*********************************************");
                    softly.assertThat(imageDisplayed);
                }else {
//                    System.out.println("DISPLAY - BROKEN!");
//                    System.out.println("********************************************");
                    softly.fail("Broken image is " + imageUrl);
                }
            } catch (Exception e) {
                System.out.println("ERROR occurred");
            }
            softly.assertAll();
        }
        return this;
    }
}
