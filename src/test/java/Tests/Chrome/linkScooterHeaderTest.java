package Tests.Chrome;

import POM.MainPageYS;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class linkScooterHeaderTest {
    protected WebDriver driver;
    //Перед начаом теста осуществляется ввод драйвера Chrome и ожидания загрузки страницы
    @Before
    public void open() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
    @Test
    public void checkCurrentURL() {
        MainPageYS objMainPageYS = new MainPageYS(driver);
        objMainPageYS.headerScooterCheckUrl();
    }

    //По ончанию тестирования браузер будет закрыт данным методом
    @After
    public void close() {
        driver.quit();
    }
}
