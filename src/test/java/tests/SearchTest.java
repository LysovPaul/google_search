import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class SearchTest extends BaseTest {

    //Тестовый метод, проверяющий результаты поиска
    @Test(dataProvider = "dataProvider")
    public void openGoogle(String text) {
        open("https://www.google.com");
        SelenideElement searchField = $(By.name("q"));
        searchField.setValue(text).pressEnter();
        $(By.xpath("(//span[text()='Libertex'])[1]")).shouldHave(Condition.text("Libertex"));
    }
}