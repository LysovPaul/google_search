package org.example;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.*;
import pages.GoogleSearchPage;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static com.codeborne.selenide.Selenide.*;

public class GoogleSearchTest extends BaseTest {

    private GoogleSearchPage googleSearchPage = new GoogleSearchPage();

    @Test(dataProvider = "dataProvider")
    public void openGoogle(String text) {
        open(Configuration.baseUrl);
        googleSearchPage
                .searchMethod(text)
                .verifyResultContains("Libertex");
    }

    @DataProvider(name = "dataProvider")
    public Object[][] dataProviderMethod() {
        return new Object[][]{{"Libertex"}, {"Forex Club"}};
    }
}
