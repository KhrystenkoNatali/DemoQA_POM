package com.demoqa.tests;

import com.demoqa.core.TestBase;
import com.demoqa.pages.HomePage;
import com.demoqa.pages.SidePanel;
import com.demoqa.pages.bookStore.LoginPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BookStoreTests extends TestBase {

    @BeforeEach
    public void precondition(){
        new HomePage(driver).selectBookStore();
    }

    @Test
    public void loginPositiveTest(){
        new SidePanel(driver).selectLogin();
        new LoginPage(driver).enterUserData("Pinki","!A1234567a")
                .clickOnLoginButton()
                .veriyUserName("Pinki");
    }
}
