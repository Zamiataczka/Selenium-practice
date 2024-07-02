package Tests;

import POM.MainPageYS;
import Settings.BrowserSetUp;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class LinkScooterHeaderTest extends BrowserSetUp {

    @Test
    public void checkCurrentURL() {
        MainPageYS objMainPageYS = new MainPageYS(driver);
        objMainPageYS.orderButtonHeaderClick();
        objMainPageYS.headerScooterCheckUrl();
    }
}
