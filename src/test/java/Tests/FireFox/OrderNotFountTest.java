package Tests.FireFox;

import POM.MainPageYS;
import POM.OrderNotFoundPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class OrderNotFountTest {
    protected WebDriver driver;
    //Перед начаом теста осуществляется ввод драйвера FireFox и ожидания загрузки страницы
    @Before
    public void open() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void checkNotFoundPage() {

        MainPageYS objOrderNotFoundPage = new MainPageYS(driver);
        objOrderNotFoundPage.headerStatusOrderFinder("55");
        new OrderNotFoundPage(driver)
                .orderNotFoundImg();
    }

    //По ончанию тестирования браузер будет закрыт данным методом
    @After
    public void close() {
        driver.quit();
    }
}
