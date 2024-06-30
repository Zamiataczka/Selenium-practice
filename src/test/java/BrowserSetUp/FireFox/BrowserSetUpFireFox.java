package BrowserSetUp.FireFox;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

//Класс главной страницы сервиса Яндекс.Самокат
public class BrowserSetUpFireFox {
    protected WebDriver driver;
    //Перед начаом теста осуществляется ввод драйвера FireFox и ожидания загрузки страницы
    @Before
    public void open() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    //По ончанию тестирования браузер будет закрыт данным методом
    @After
    public void close() {
        driver.quit();
    }
}
