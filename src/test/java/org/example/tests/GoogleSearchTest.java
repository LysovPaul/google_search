package org.example.tests;

import org.testng.annotations.*;
import org.example.pages.GoogleSearchPage;

import static com.codeborne.selenide.Selenide.*;

public class GoogleSearchTest extends BaseTest {

    private GoogleSearchPage googleSearchPage = new GoogleSearchPage();

    @Test(dataProvider = "dataProvider")
    public void openGoogle(String text) {
        open("/");
        googleSearchPage
                .searchMethod(text)
                .verifyResultContains("Libertex");
    }

    @DataProvider(name = "dataProvider")
    public Object[][] dataProviderMethod() {
        return new Object[][]{{"Libertex"}, {"Forex Club"}};
    }
}
