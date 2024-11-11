package org.example;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class BaseTest {
    @BeforeClass
    public void setUp() {
        Properties properties = new Properties();
        try (FileInputStream fis = new FileInputStream("src/test/resources/config.properties")) {
            properties.load(fis);
            Configuration.browser = properties.getProperty("browser", "chrome");
            Configuration.baseUrl = properties.getProperty("baseUrl", "https://www.google.com");
            Configuration.browserSize = properties.getProperty("browserSize", "1920x1080");
            Configuration.timeout = Long.parseLong(properties.getProperty("timeout","10000"));
            System.setProperty("webdriver.chrome.driver", properties.getProperty("chromeDriverPath"));
        } catch (IOException e) {
            throw new RuntimeException("Configuration error", e);
        }
    }

    @AfterMethod
    public void tearDown() {
        closeWebDriver();
    }
}
