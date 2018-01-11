package com.selenide.tests;

import com.codeborne.selenide.Configuration;
import static com.codeborne.selenide.Selenide.*;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class TestConfig {

    @BeforeClass
    public void setUp(){
        ChromeDriverManager.getInstance().setup();
        Configuration.browser = "firefox";
        Configuration.baseUrl = "http://loco2.com";
        Configuration.startMaximized = true;
        open("/");

    }

    @AfterClass
    public void tearDown(){
        Configuration.holdBrowserOpen = true;
    }
}
