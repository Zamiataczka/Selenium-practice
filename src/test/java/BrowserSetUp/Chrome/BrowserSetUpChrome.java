package BrowserSetUp.Chrome;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BrowserSetUpChrome {
    protected WebDriver driver;
    //Перед начаом теста осуществляется ввод драйвера Chrome и ожидания загрузки страницы
    @Before
    public void open() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    //По ончанию тестирования браузер будет закрыт данным методом
    @After
    public void close() {
        driver.quit();
    }
}
