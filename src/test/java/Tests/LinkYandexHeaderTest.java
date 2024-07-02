package Tests;

import POM.MainPageYS;
import Settings.BrowserSetUp;
import org.junit.Test;

public class LinkYandexHeaderTest extends BrowserSetUp {

    @Test
    public void checkCurrentURL() {
        MainPageYS objMainPageYS = new MainPageYS(driver);
        objMainPageYS.headerYandexCheckUrl();
    }
}

