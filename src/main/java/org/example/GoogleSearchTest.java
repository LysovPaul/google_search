package org.example;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.*;
import pages.GoogleSearchPage;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static com.codeborne.selenide.Selenide.*;

public class GoogleSearchTest {

    private GoogleSearchPage googleSearchPage;

    @BeforeClass
    public void setUp() {
        Properties properties = new Properties();
        try (FileInputStream fis = new FileInputStream("src/test/resources/config.properties")) {
            properties.load(fis);
            Configuration.browser = properties.getProperty("browser");
            Configuration.baseUrl = properties.getProperty("baseUrl");
            Configuration.browserSize = properties.getProperty("browserSize", "1920x1080");
            Configuration.timeout = Long.parseLong(properties.getProperty("timeout"));
            System.setProperty("webdriver.chrome.driver", properties.getProperty("chromeDriverPath"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        googleSearchPage = new GoogleSearchPage();
    }

    @Test(dataProvider = "dataProvider")
    public void openGoogle(String text) {
        open("https://www.google.com");
        googleSearchPage.searchMethod(text);
        googleSearchPage.verifyResultContains("Libertex");
    }

    @DataProvider(name = "dataProvider")
    public Object[][] dataProviderMethod() {
        return new Object[][]{{"Libertex"}, {"Forex Club"}};
    }

    @AfterMethod
    public void tearDown() {
        closeWebDriver();
    }
}
