package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class GoogleSearchPage {

    public GoogleSearchPage searchMethod(String text) {
        $(By.name("q")).setValue(text).pressEnter();
        return this;
    }
    public GoogleSearchPage verifyResultContains(String expectedText) {
        $(By.xpath("//span[contains(text(), '" + expectedText + "')]"))
                .shouldHave(Condition.text(expectedText));
        return this;
    }
}
