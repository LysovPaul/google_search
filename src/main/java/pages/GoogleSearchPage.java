package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class GoogleSearchPage {
    private final SelenideElement searchField = $(By.name("q"));

    public final void searchMethod(String text) {
        searchField.setValue(text).pressEnter();
    }

    public void verifyResultContains(String expectedText) {
        $x("(//span[text()='Libertex'])[1]").shouldHave(Condition.text(expectedText));
    }
}
