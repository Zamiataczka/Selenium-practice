package Tests;

import Settings.BrowserSetUp;
import POM.MainPageYS;
import POM.OrderNotFoundPage;
import org.junit.Test;


public class OrderNotFountTest extends BrowserSetUp {
    @Test
    public void checkNotFoundPage() {
        MainPageYS objOrderNotFoundPage = new MainPageYS(driver);
        objOrderNotFoundPage.headerStatusOrderFinder("55");
        new OrderNotFoundPage(driver)
                .orderNotFoundImg();
    }
}
