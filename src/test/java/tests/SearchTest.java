import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.File;

public class SearchTest {

    @Test
    public void openGoogle() throws InterruptedException {
        File file = new File("src/test/resources/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        WebElement searchField = driver.findElement(By.name("q"));
        searchField.click();
        searchField.sendKeys("libertex");
        searchField.sendKeys(Keys.RETURN);
        Thread.sleep(3000);
        WebElement resultRow = driver.findElement(By.xpath("(//span[text()='Libertex'])[1]"));
        System.out.println(resultRow.getText());
        driver.quit();
    }
}