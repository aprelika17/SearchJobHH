package ru.hh.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;
import ru.hh.pages.PageObject;

import java.util.Map;

public class TestBase {
    PageObject pageObject = new PageObject();
    TestData testData = new TestData();

    @BeforeAll
    static void beforeAll() {
        //Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = "https://hh.ru";
        Configuration.browserSize = System.getProperty("resolution", "1920x1080");
        Configuration.browser = System.getProperty("browser","chrome");
        Configuration.browserVersion = System.getProperty("version","100.0");
        Configuration.remote = System.getProperty("selenoid");

//        Configuration.browserSize = "1920x1080";
//        Configuration.browser = "chrome";
//        Configuration.browserVersion = "102";


        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));
        Configuration.browserCapabilities = capabilities;
    }

    @BeforeEach
    void addListener() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterEach
    void afterEach(){
        Selenide.closeWindow();
    }

    @AfterEach
    void addAttachments(){
        quru.qa.helpers.Attach.screenshotAs("Last screenshot");
        quru.qa.helpers.Attach.pageSource();
        quru.qa.helpers.Attach.browserConsoleLogs();
        quru.qa.helpers.Attach.addVideo();
    }
}
