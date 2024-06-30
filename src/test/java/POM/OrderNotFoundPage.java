package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderNotFoundPage {
    private WebDriver driver;
    public OrderNotFoundPage(WebDriver driver) {
        this.driver = driver;
    }

    private By notFoundImg = By.xpath(".//img[@src = '/assets/not-found.png']");

    public boolean orderNotFoundImg() {
        return driver.findElement(notFoundImg).isDisplayed();
    }
}
