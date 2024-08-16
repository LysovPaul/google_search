package tests;
import com.codeborne.selenide.Configuration;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import static com.codeborne.selenide.Selenide.*;

public class BaseTest {

    //Запускаем поисковик гугл в браузере
    @BeforeClass
    public void setUp() {
        Configuration.browser = "chrome";
        Configuration.baseUrl = "https://www.google.com";
        Configuration.startMaximized = true;
        Configuration.timeout = 10000;
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        open("https://www.google.com/");
    }

    //Закрываем браузер
    @AfterClass
    public void tearDown() {
        closeWebDriver();
    }

    // Возвращаемся назад после выполения тестовго метода
    @AfterMethod
    public void goBack(){
        back();
    }

    //Задаём поисковые запросы в виде параметров
    @DataProvider(name = "dataProvider")
    public Object[][] dataProviderMethod(){
        return new Object[][]{{"Libertex"},{"Forex Club"}};
    }
}
