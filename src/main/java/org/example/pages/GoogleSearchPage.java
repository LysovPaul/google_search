package org.example.pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class GoogleSearchPage {

    public GoogleSearchPage searchMethod(String text) {
        $(By.name("q")).setValue(text).pressEnter();
        return this;
    }
    public GoogleSearchPage verifyResultContains(String expectedText) {
        $(By.xpath("//span[contains(text(), '" + expectedText + "')]"))
                .shouldBe(Condition.visible);
        return this;
    }
}
