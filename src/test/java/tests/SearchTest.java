import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;


public class SearchTest extends BaseTest {

    //Тестовый метод, проверяющий результаты поиска
    @Test(dataProvider = "dataProvider")
    public void openGoogle(String text) throws InterruptedException {
        WebElement searchField = driver.findElement(By.name("q"));
        searchField.click();
        searchField.sendKeys(text);
        searchField.sendKeys(Keys.RETURN);
        Thread.sleep(3000);
        WebElement resultRow = driver.findElement(By.xpath("(//span[text()='Libertex'])[1]"));
        Assert.assertEquals(resultRow.getText(), "Libertex");
    }
}