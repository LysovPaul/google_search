package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

import java.io.File;

public class BaseTest {
    protected WebDriver driver;

    //Запускаем поисковик гугл в браузере
    @BeforeClass
    public void setUp() {
        File file = new File("src/test/resources/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        driver = new ChromeDriver();
        driver.get("https://www.google.com/");
    }

    //Закрываем браузер
    @AfterClass
    public void tearDown(){
        driver.quit();
    }

    // Возвращаемся назад после выполения тестовго метода
    @AfterMethod
    public void goBack(){
        driver.navigate().back();
    }

    //Задаём поисковые запросы в виде параметров
    @DataProvider(name = "dataProvider")
    public Object[][] dataProviderMethod(){
        return new Object[][]{{"Libertex"},{"Forex Club"}};
    }
}
